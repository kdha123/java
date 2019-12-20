import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//Servlet���� JSP�� ������ �ϱ� 
public class ServletToJsp extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		// Ŭ���̾�Ʈ�� �����ϱ� ���� �ѱ�ó��
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();//out��ü ����

		//Vector 
		String user="���̸�";
		Vector vec = new Vector();
		vec.add("��ī�ݶ�");
		vec.add("����ƾ��");
		vec.add("��Ű��");
		
		req.setAttribute("user", user);
		req.setAttribute("vec", vec);
		
		//Servlet���� Jsp�� forwarding
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/targer.jsp");
		rd.forward(req, res);//jsp ������
	}//doGet() end

}// class end
