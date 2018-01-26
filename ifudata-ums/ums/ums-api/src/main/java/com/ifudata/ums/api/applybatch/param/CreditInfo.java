package com.ifudata.ums.api.applybatch.param;


public class CreditInfo extends AbstractBatchData{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
//	account":"8528",
//	"password":"e717ebfd5271ea4a98bd38653c01113d",
//	"msgid":"2c92825934837c4d0134837dcba00150",
//	"phones":"15711666132",
//	"content":"您好，您的手机验证码为：430237。",
//	"sign":"【8528】",
//	"subcode":"8528",
//	"sendtime":"201405051230"}
	
//	account：用户账号；
//	password：账号密码，需采用MD5加密(32位小写)；
//	msgid：该批短信编号(32位UUID)，需保证唯一，选填；
//	phones：接收手机号码，多个手机号码用英文逗号分隔，最多500个，必填；
//	content：短信内容，最多350个汉字，必填；
//	sign：短信签名，该签名需要提前报备，生效后方可使用，不可修改，必填
//	，示例如：【大汉三通】；
//	subcode：短信签名对应子码(大汉三通提供)+自定义扩展子码(选填)，必须是数字，选填，未填使用签名对应子码；
//	sendtime：定时发送时间，格式yyyyMMddHHmm，为空或早于当前时间则立即发送
	
	/**
	 * 接收手机号码
	 */
	private String phone;
	/**
	 * 短信内容，最多350个汉字，必填；
	 */
	private String content;
	/**
	 * 渠道id 选填
	 */
	private String chiId;
	/**
	 * 分组好 内容相同的同一号 选填
	 */
	private String groupNum;
	/**
	 *省份代码 选填
	 */
	private String provinceCode;
	/**
	 * 城市代码 选填
	 */
	private String cityCode;
	
	/**
	 * 定时发送时间，格式yyyyMMddHHmmss，为空或早于当前时间则立即发送
	 */
	//private long sendtime;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChiId() {
		return chiId;
	}

	public void setChiId(String chiId) {
		this.chiId = chiId;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}

	
	
	
	
    
}
