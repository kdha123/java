

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLifeCycle
 */
@WebServlet("/ServletLifeCycle")
public class ServletLifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//��������
	public int count = 0; 
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() method called....");
	}// init end
	
	//service():Ŭ���̾�Ʈ�� ��û�� ������ ���������� ȣ��ȴ�. ������ ����� �ִ�.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() method called....");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();//�����ϱ� ���ؼ� out��ü ����
		
		out.println("<html><body>");
		count++;//�湮Ƚ�� count
		out.println("<h2>service() method called : "+count+"</h2>");
		out.println("</body></html>");
		
	}// service end
	
	//destroy()
	public void destroy() {
		System.out.println("destroy() method called...");
	}// destroy end


}// class end
