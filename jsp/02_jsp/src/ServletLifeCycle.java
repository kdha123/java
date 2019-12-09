

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
       
	//전역변수
	public int count = 0; 
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() method called....");
	}// init end
	
	//service():클라이언트가 요청할 때마다 병행적으로 호출된다. 스레드 기능이 있다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() method called....");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();//응답하기 위해서 out객체 생성
		
		out.println("<html><body>");
		count++;//방문횟수 count
		out.println("<h2>service() method called : "+count+"</h2>");
		out.println("</body></html>");
		
	}// service end
	
	//destroy()
	public void destroy() {
		System.out.println("destroy() method called...");
	}// destroy end


}// class end
