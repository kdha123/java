package emailupload;
import java.io.*;

import javax.servlet.http.*;//HttpServletRequest

import com.oreilly.servlet.*;//cos.jar
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class EmailUpload {

	//����� ���� �޼ҵ�
	public String upload(HttpServletRequest request){
		String reply ="";
		
		try {
			//���� ���ε�
			MultipartRequest mrequest
			= new MultipartRequest(request, "c:/_jsp/upload/",1024*1024*5,"utf-8", new DefaultFileRenamePolicy());
			
			//���� �ڷ� �ޱ�
			String from = mrequest.getParameter("from");
			String to = mrequest.getParameter("to");
			String subject = mrequest.getParameter("subject");
			String content = mrequest.getParameter("content");
			
			//host=smpt.name.com
			MailMessage msg = new MailMessage("smpt.nate.com");
			msg.from(from);
			msg.to(to);
			msg.setSubject(subject);
			
			//MailMessage ���� ��¿� ��Ʈ�� ����
			PrintStream out = msg.getPrintStream();
			out.println(content);
			
			msg.sendAndClose();//��¿� ��Ʈ���� ������ ������ ����
			
			reply="���Ϻ�����, ���� ���ε� ����";
			
		} catch (Exception ex) {
			reply="���Ϻ�����, ���Ͼ��ε� ����"+ex;
		}//catch end
		
		return reply;
	}// upload() end
	
}//class end
