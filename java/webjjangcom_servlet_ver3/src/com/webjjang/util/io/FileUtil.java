package com.webjjang.util.io;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class FileUtil {

	// 파일을 삭제하는 메서드
	public static void deleteFile(String fileName) throws Exception{
		File deleteFile = new File(fileName);
		if(!deleteFile.exists())
			throw new Exception("삭제하려는 파일이 존재하지 않습니다.");
		deleteFile.delete();
		System.out.println("FileUtil.deleteFile().fileName:"+fileName);
		System.out.println("파일이 성공적으로 삭제되었습니다.");
	}
	
	// 웹 위치를 컴퓨터의 실제 위치로 바꿔주는 메서드
	public static String realPath(HttpServletRequest request, String url) 
	throws Exception{
		if(url == null) throw new Exception("삭제할 파일이 선택되지 않았습니다.");
		return request.getServletContext().getRealPath(url);
	}
	
}
