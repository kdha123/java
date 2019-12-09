

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*; //DB���

@WebServlet("/MemberInput")
public class MemberInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//��������
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/mydb";
	private static final String USER = "root";
	private static final String PWD = "12345";
	
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		//post ��û �ѱ�ó��
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//Ŭ�󸮾�Ʈ�� ������ ������ �ޱ�
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		String db_pwd=""; //DB���� ������ ��ȣ ���� ����
		try {
			Class.forName(DRIVER); //����̹� �ε�
			System.out.println("����̹��ε� ���� ");
		} catch (ClassNotFoundException cnf) {
			System.out.println("����̹��ε� ���� : " + cnf);
		}
		
		try {
			con = DriverManager.getConnection(URL,USER,PWD);
			System.out.println("DB���� ����");
			stmt = con.createStatement();// Statement ����
			rs = stmt.executeQuery(" select pwd from member1 where id='"+id+"'");
			
			if(rs.next()){
				db_pwd = rs.getString("pwd");
			}// if end
			
			if(db_pwd==""){ //�ű԰��� ����
				String sql = " insert into member1 values(?,?,?,?,?,?) ";
				pstmt = con.prepareStatement(sql);
				
				// ?�� �� ä���
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				pstmt.setString(3, name);
				pstmt.setString(4, email);
				pstmt.setString(5, tel);
				pstmt.setString(6, addr);
				
				pstmt.executeUpdate(); //����
				
				out.println("<html><body>");
				out.println("<Meta http-equiv=refresh content=\'2;url=/01_servlet/html1/login.html\'>");
				out.println("<font color='blue' size='5'>"+id+"�� ȸ�������� �����մϴ�.</font>");
				out.println("</body></html>");
				
				rs.close();
				stmt.close();
				pstmt.close();
				con.close();
				out.close();
				
			}else{ // �̹� �����ϴ� id
				out.println("<html><body>");
				out.println("<Meta http-equiv=refresh content=\'2;url=/01_servlet/html1/MemberForm.html\'>");
				out.println("<font color='blue' size='5'>"+id+"�� ��� �� �Դϴ�.</font>");
				out.println("</body></html>");
				
				rs.close();
				stmt.close();
				pstmt.close();
				con.close();
				out.close();
				
			}// else end
		} catch (SQLException se) {
			System.out.println("DB���� ����" + se);
			
		}
	}//doPost end

}//class end
