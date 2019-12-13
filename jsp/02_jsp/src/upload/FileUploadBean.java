package upload;
import java.io.*;

import javax.servlet.http.*;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

//dto
public class FileUploadBean {

	public String upload(HttpServletRequest request){
		String reply="";
		try{
//			MultipartRequest multi=new MultipartRequest(request,"c:\\_jsp\\upload\\");
			int size = 1024*1024*5;
			MultipartRequest multi=new MultipartRequest(request,"c:\\_jsp\\upload\\",size, "uft-8",new DefaultFileRenamePolicy());
			reply="파일 업로드 성공";

		}catch(Exception ex){
			reply="파일 업로드 실패:"+ex;
		}
		return reply;
	}

}// class end
