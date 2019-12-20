import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//Servlet에서 JSP로 포워딩 하기 
public class ServletToJsp extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		// 클라이언트에 응답하기 위한 한글처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();//out객체 생성

		//Vector 
		String user="아이린";
		Vector vec = new Vector();
		vec.add("코카콜라");
		vec.add("마운틴듀");
		vec.add("밀키스");
		
		req.setAttribute("user", user);
		req.setAttribute("vec", vec);
		
		//Servlet에서 Jsp로 forwarding
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/targer.jsp");
		rd.forward(req, res);//jsp 포워딩
	}//doGet() end

}// class end
