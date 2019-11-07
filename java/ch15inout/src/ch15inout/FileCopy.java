package ch15inout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.webjjang.util.io.Input;

public class FileCopy {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// 복사하려는 원본 파일명을 입력한다. -> 파일명만 입역을 하면 프로젝트 맨 처음 위치가 된다.
			String inFile = Input.getStringWithMessage("소스파일");
			String outFile = Input.getStringWithMessage("복사본 파일");
			
			String copyPath = "d:/data/";
			
			// 저장하려는 폴더가 없으면 만든다.
			File copyDir = new File(copyPath);
			if(!copyDir.exists())
				copyDir.mkdirs();
			
			
			FileInputStream fis = new FileInputStream(inFile);
			FileOutputStream fos = new FileOutputStream(copyPath + outFile);

			// 문자 단위로 파일을 복사하려고 한다. 문자 = char = int
			// 파일 복사 처리
			int data = 0;
			// 입력 파일 객체에서 데이터를 읽어왔을 때 -1인 경우 데이터가 없는 경우이다.
			while((data=fis.read()) != -1) {
				// 복사본으로 만들 파일에 기록을 한다. 출력 -> write(), print(), println()
				fos.write(data);
			}
			fis.close();
			fos.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
