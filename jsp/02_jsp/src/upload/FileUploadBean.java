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
			reply="���� ���ε� ����";

		}catch(Exception ex){
			reply="���� ���ε� ����:"+ex;
		}
		return reply;
	}

}// class end
