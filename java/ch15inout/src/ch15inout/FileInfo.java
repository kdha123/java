package ch15inout;

import java.io.File;

import com.webjjang.util.io.FileUtil;

public class FileInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 문자열 정보
		String fileName="source.txt";
		
		// 파일 객체로 만든다.
		File file = new File(fileName);
		// 파일 / 폴더의 존재여부
		System.out.println(file.exists());
		// 파일을 지운다.
//		System.out.println(file.delete());
		// 파일이 존재하지 않으면 c:/data/source.txt 파일을 복사해온다.
		if(!file.exists())
			System.out.println(
			FileUtil.copy("d:\\data\\source.txt", "./source.txt"));
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
	}

}
