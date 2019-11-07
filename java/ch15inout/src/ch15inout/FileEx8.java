package ch15inout;

import java.io.File;

public class FileEx8 {
	static int deletedFiles = 0;

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("USAGE : java FileEx8 Extension");
			System.exit(0);
		}
		
		String currDir = System.getProperty("user.dir");
		
		File dir = new File(currDir);
		String ext = "." + args[0];

		delete(dir, ext);
		System.out.println(deletedFiles + "개의 파일이 삭제되었습니다.");
	}// end of main
	
	public static void delete(File dir, String ext) {
		File[] files = dir.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				delete(files[i], ext);
			} else {
				String filename = files[i].getAbsolutePath();
				
				if(filename.endsWith(ext)) {
					System.out.print(filename);
					if(files[i].delete()) {
						System.out.println(" - 삭제성공");
						deletedFiles++;
					} else
						System.out.println(" - 삭제실패");
				}
			}// end of if(files[i].isDrectory())
			
		}// end of for 
	}// end of delete

}
