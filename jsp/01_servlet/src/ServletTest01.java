import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest01 extends HttpServlet{
	
	//디폴트 doGet() : 기본적으로 실행되는 메서드
	//오버라이딩
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		//html페이지의 표준 MIME 컨텐츠 타입 지정
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();// 클라이언트로 응답하려고 out 객체 생성
		
		//클라이언트로 응답
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>HelloWorld!</h2>");
		out.println("<h2>안녕하세요!</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
		
		
	}// end of doGet()
	
}// end of class
