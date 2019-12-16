package emailupload;
import java.io.*;

import javax.servlet.http.*;//HttpServletRequest

import com.oreilly.servlet.*;//cos.jar
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class EmailUpload {

	//사용자 정의 메소드
	public String upload(HttpServletRequest request){
		String reply ="";
		
		try {
			//파일 업로드
			MultipartRequest mrequest
			= new MultipartRequest(request, "c:/_jsp/upload/",1024*1024*5,"utf-8", new DefaultFileRenamePolicy());
			
			//메일 자료 받기
			String from = mrequest.getParameter("from");
			String to = mrequest.getParameter("to");
			String subject = mrequest.getParameter("subject");
			String content = mrequest.getParameter("content");
			
			//host=smpt.name.com
			MailMessage msg = new MailMessage("smpt.nate.com");
			msg.from(from);
			msg.to(to);
			msg.setSubject(subject);
			
			//MailMessage 에서 출력용 스트림 생성
			PrintStream out = msg.getPrintStream();
			out.println(content);
			
			msg.sendAndClose();//출력용 스트림의 내용을 보내고 종료
			
			reply="메일보내기, 파일 업로드 성공";
			
		} catch (Exception ex) {
			reply="메일보내기, 파일업로드 실패"+ex;
		}//catch end
		
		return reply;
	}// upload() end
	
}//class end
