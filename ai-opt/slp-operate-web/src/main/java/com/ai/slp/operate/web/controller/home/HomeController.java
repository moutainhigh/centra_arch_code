package com.ai.slp.operate.web.controller.home;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.PageInfoResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.components.idps.IDPSClientFactory;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.opt.sdk.web.model.ResponseData;
import com.ai.paas.ipaas.PaasRuntimeException;
import com.ai.paas.ipaas.image.IImageClient;
import com.ai.paas.ipaas.image.ImageSizeIllegalException;
import com.ai.slp.operate.web.constants.SysCommonConstants;
import com.ai.slp.operate.web.vo.ImgFileInfoVo;
import com.ai.slp.user.api.keyinfo.interfaces.IUcKeyInfoSV;
import com.ai.slp.user.api.keyinfo.param.QueryGroupInfoRequest;
import com.ai.slp.user.api.keyinfo.param.UcGroupKeyInfoVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


@Controller
@RequestMapping("/home")
public class HomeController {
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping({"","/"})
	public String index(Model uiModel) {
		return "forward:/prodquery/add";
	}

	/**
	 * ckedit上传图片
	 * @param file
	 * @param request
	 * @param ckeditFuncNum
	 * @param ckCsrfToken
     * @return
     */
	@RequestMapping("/ckeditUpImg")
	@ResponseBody
	public String ckEditUploadImg(@RequestParam("upload") MultipartFile file, HttpServletRequest request,
							@RequestParam("CKEditorFuncNum") String ckeditFuncNum, String ckCsrfToken){
		printParams(request);
		StringBuffer strBuffer = new StringBuffer();
		try {
			ImgFileInfoVo imgFileInfoVo = saveImg(file,null,0,0);
			logger.info("\rfileUid:"+imgFileInfoVo.getVfsId()+"\rfileUrl:"+imgFileInfoVo.getImgUrl());
			strBuffer.append("<script type=\"text/javascript\">");
			strBuffer.append("window.parent.CKEDITOR.tools.callFunction("+ckeditFuncNum+",'"+imgFileInfoVo.getImgUrl()+"','')");
			strBuffer.append("</script>");
		} catch (BusinessException|IOException e) {
			logger.error("Add file faile.",e);
			strBuffer.reverse();
			strBuffer.append("<font color=\"red\" size=\"2\">*上传文件错误</font>");
		}
		return strBuffer.toString();
	}

	/**
	 * 图片上传
	 * @return
     */
	@RequestMapping("/upImg")
	@ResponseBody
	public ResponseData<ImgFileInfoVo> uploadImg(@RequestParam("uploadFile") MultipartFile file,String imgSize){
		ResponseData<ImgFileInfoVo> responseData = null;
		try {
			ImgFileInfoVo imgFileInfoVo = saveImg(file,imgSize,700,700);
			logger.info("\rfileUid:"+imgFileInfoVo.getVfsId()+"\rfileUrl:"+imgFileInfoVo.getImgUrl());
			responseData = new ResponseData<ImgFileInfoVo>(ResponseData.AJAX_STATUS_SUCCESS,"上传成功",imgFileInfoVo);
		} catch (IOException e) {
			logger.error("Add file faile.",e);
			responseData = new ResponseData<ImgFileInfoVo>(ResponseData.AJAX_STATUS_FAILURE,"上传失败:文件获取失败");
		} catch (BusinessException e){
			logger.error("Add file faile.",e);
			responseData = new ResponseData<ImgFileInfoVo>(ResponseData.AJAX_STATUS_FAILURE,"上传失败:"+e.getMessage());
		} catch (ImageSizeIllegalException e){
			logger.error("Add file faile.",e);
			responseData = new ResponseData<ImgFileInfoVo>(ResponseData.AJAX_STATUS_FAILURE,"上传失败:图片的高度或宽度不符合要求");
		}
		return responseData;
	}

	@RequestMapping("/queryuser")
	@ResponseBody
	public ResponseData<PageInfoResponse<UcGroupKeyInfoVo>> queryUserList(Integer pageSize, Integer pageNo, String userType, String userName){
		ResponseData<PageInfoResponse<UcGroupKeyInfoVo>> responseData;
		QueryGroupInfoRequest infoRequest = new QueryGroupInfoRequest();
		infoRequest.setTenantId(SysCommonConstants.COMMON_TENANT_ID);
		infoRequest.setPageNo(pageNo);
		infoRequest.setPageSize(pageSize);
		infoRequest.setCustName(userName);
		infoRequest.setUserType(userType);
		IUcKeyInfoSV ucKeyInfoSV = DubboConsumerFactory.getService(IUcKeyInfoSV.class);
		PageInfoResponse<UcGroupKeyInfoVo> infoResponse = ucKeyInfoSV.queryGroupInfo(infoRequest);
		ResponseHeader header = infoResponse.getResponseHeader();
		if (header!=null && header.isSuccess()){
			responseData = new ResponseData<PageInfoResponse<UcGroupKeyInfoVo>>(ResponseData.AJAX_STATUS_SUCCESS,
					"查询成功",infoResponse);
		}else {
			responseData = new ResponseData<PageInfoResponse<UcGroupKeyInfoVo>>(ResponseData.AJAX_STATUS_FAILURE,
					"查询失败:"+header.getResultMessage());
		}
		return responseData;
	}

	/**
	 * 获取文件扩展名
	 * @param fileName
	 * @return
     */
	private String getFileExtName(String fileName){
		String extName = "";
		if (StringUtils.isNotBlank(fileName)){
			int ind =fileName.lastIndexOf(".");
			extName = fileName.substring(ind);
		}
		return extName;
	}

	/**
	 * 打印参数
	 * @param request
     */
	private void printParams(HttpServletRequest request){
		Map<String,String[]> paramMap = request.getParameterMap();
		for (Map.Entry<String,String[]> entry:paramMap.entrySet()){
			System.out.println("the param:"+entry.getKey());
			String[] vals = entry.getValue();
			for (String val:vals){
				System.out.print(val+",");
			}
			System.out.println("\r");
		}
	}

	/**
	 * 保存图片信息
	 * @param file
	 * @param imgSize
	 * @param minHeight 图片最小高度
	 * @param minWidth 图片最小宽度
	 * @return
     */
	private ImgFileInfoVo saveImg(MultipartFile file,String imgSize,int minWidth,int minHeight) throws PaasRuntimeException,IOException {
		if (file==null)
			throw new BusinessException("","上传文件为空");
		String fileName = file.getOriginalFilename();
		String fileExt = getFileExtName(fileName);
		IImageClient imageClient = IDPSClientFactory.getImageClient(SysCommonConstants.ProductImage.IDPSNS);
//		String fileUid = imageClient.upLoadImage(file.getBytes(),fileName);
		String fileUid = imageClient.upLoadImage(file.getBytes(),fileName,minWidth,minHeight);
		String imageUrl = "";
		if (StringUtils.isNotBlank(imgSize))
			imageUrl = imageClient.getImageUrl(fileUid, fileExt,imgSize);
		else
			imageUrl = imageClient.getImageUrl(fileUid, fileExt);
		ImgFileInfoVo fileInfoVo = new ImgFileInfoVo();
		fileInfoVo.setVfsId(fileUid);
		fileInfoVo.setImgUrl(imageUrl);
		fileInfoVo.setFileType(fileExt);
		return fileInfoVo;
	}
}
