package mail;

import java.io.*;
import com.oreilly.servlet.*;

public class MailSender {
	//�ʵ�=��������=property=�Ӽ�
	private String from;
	private String to;
	private String subject;
	private String content;

	//������
	public MailSender() {
		from="";
		to="";
		subject="";
		content="";
	}//cons end

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	//��Ÿ �޼���
	public String send(){
		String reply="";//����
		try {
			MailMessage msg = new MailMessage("smtp.nate.com");
			msg.from(from);
			msg.to(to);
			msg.setSubject(subject);
			
			//MailMessage ���� ��¿� ��Ʈ�� ����
			PrintStream out = msg.getPrintStream();
			out.println(content);
			
			// ��¿� ��Ʈ���� ������ ������ ����
			msg.sendAndClose();
			reply="�������� ����";
			
		} catch (Exception ex) {
			reply="���� ���� ����"+ex;
		}// catch end
		
		return reply;
	}// send() end
}//class end
