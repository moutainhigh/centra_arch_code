package com.ifudata.ums.system.util;

public class ThumbnailImageUtil {
	/**
	 * 给一个图片文件重命名，加上缩略后缀
	 * @param fileName
	 * @return
	 */
	public static String  getSuolueString(String fileName){
		int dotaIndex=fileName.lastIndexOf(".");
		return fileName.substring(0,dotaIndex)+"_suolue"+fileName.substring(dotaIndex);		
	}
}
