import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest01 extends HttpServlet{
	
	//����Ʈ doGet() : �⺻������ ����Ǵ� �޼���
	//�������̵�
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		//html�������� ǥ�� MIME ������ Ÿ�� ����
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();// Ŭ���̾�Ʈ�� �����Ϸ��� out ��ü ����
		
		//Ŭ���̾�Ʈ�� ����
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>HelloWorld!</h2>");
		out.println("<h2>�ȳ��ϼ���!</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
		
		
	}// end of doGet()
	
}// end of class
