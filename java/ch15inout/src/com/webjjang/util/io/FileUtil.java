package com.webjjang.util.io;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

	public static boolean copy(String source, String target) {
	try {
		FileInputStream fis = new FileInputStream(source);
		FileOutputStream fos 
		= new FileOutputStream(target);

		// 문자 단위로 파일을 복사하려고 한다. 문자 = char = int
		// 파일 복사 처리
		int data = 0;
		// 입력 파일 객체에서 데이터를 읽어 왔을 때 -1인 경우 데이터가 없는 경우이다.
		while((data=fis.read())!= -1) {
			// 복사본으로 만들 파일에 기록을 한다. 출력 -> write(), print() println()
			fos.write(data);
		}
		fis.close();
		fos.close();
		return true;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}

}
}