import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*; //Date
import java.text.*; //SimpleDateFormat(��¥����)

public class ServletTest02 extends HttpServlet{

	//�������̵� : ��ӹ��� �޼��� ���� ������
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter(); //�����ϱ� ���� out��ü ����
		
		java.util.Date date = new java.util.Date(); //���� �ý��� ��¥ ���ϱ�
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss EEEE");
		
		//����
		out.println("<html>");
		out.println("<body bgcolor=\'yellow\'>");
		out.println("<font color='blue' size=5>");
		out.println("<center><br><br><br>");
		out.println("<img src=\'imgs/song.jpg\'>");
		out.println("<marquee>");// �ڸ�ó�� �������� �۾�
		out.println("<h3>������ ��ſ� �ݿ��� �Դϴ�.</h3>");
		out.println("</marquee>");
		out.println("<br><br><hr size=10 color='red'><br>");
		out.println(date.toString());//��¥ ���
		out.println("<br>");
		out.println(sdf.format(date));
		out.println("</font>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		//����=������ web.xml�� ���
	}//doGet end
}//class end
