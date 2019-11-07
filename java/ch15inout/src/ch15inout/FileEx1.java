package ch15inout;

import java.io.File;
import java.io.IOException;

public class FileEx1 {

	public static void main(String[] args) throws IOException{
		File f = new File("D:\\workspace\\java\\ch15inout\\src\\ch15inout\\FileEx1.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");
		
		System.out.println("경로를 제외한 파일 이름 - " + f.getName());
		System.out.println("확장자를 제외한 파일 이름 - " + fileName.substring(0,pos));
		System.out.println("확장자 - " + fileName.substring(pos+1));

		System.out.println("경로를 포함한 파일이름  - "+ f.getPath());
		System.out.println("파일의 절대경로            - "+ f.getAbsolutePath());
		System.out.println("파일의 정규경로            - "+ f.getCanonicalPath());
		System.out.println("파일에 속해 있는 디렉토리  - "+ f.getParent());
		System.out.println();
		System.out.println("File.pathSeparator -"+ File.pathSeparator);
		System.out.println("File.pathseparatorChar -  "+ File.pathSeparatorChar);
		System.out.println("File.separator -  "+ File.separator);
		System.out.println("File.separatorChar -  "+ File.separatorChar);
		System.out.println();
		System.out.println("user.dir = "+ System.getProperty("user.dir"));
		System.out.println("sun.boot.class.path = "+ System.getProperty("sun.boot.class.path"));
	}

}
