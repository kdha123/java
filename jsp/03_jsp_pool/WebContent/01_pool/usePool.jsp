<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- usePool.jsp --%>
<html>
	<body>
		<h2>커넥션 풀 사용하기</h2>
		<table border="1" width="70%">
			<tr>
				<th width="100">글쓴이</th>		
				<th width="150">이메일</th>		
				<th width="200">주소</th>		
			</tr>
			<%
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			Context ct = new InitialContext();
// 			Context ct2 = (Context)ct.lookup("java:comp/env");
// 			DataSource ds = (DataSource)ct2.lookup("jdbc/mysql");
			DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			con= ds.getConnection();//connection 얻기
			
			String sql = " select * from test ";
			stmt = con.createStatement();//Statement 생성
			rs = stmt.executeQuery(sql);//쿼리 실행
			
			while(rs.next()){
				String name = rs.getString("name");
				String email = rs.getString("email");
				String addr = rs.getString("addr");
				%>
				<tr>
					<td><%=name %></td>
					<td><%=email %></td>
					<td><%=addr %></td>
				</tr>
				<%
			}//while end
			rs.close();
			stmt.close();
			con.close();
			%>
		</table>
	</body>
</html>

<%--
// 현재환경의 naming Context 획득하기 
//InitialContext()는 웹 어플리케이션이 처음으로 배치될때 설정되고
//모든 설정된 엔트리와 자원은 JNDI namespace 의 
//java:comp/env 부분에 놓이게 됩니다.
//그래서 자원 접근을
Context ct=new InitialContext(); : 이렇게 한다.

//JNDI에 등록된 생성할 자원 이름 
//(즉. 컨텍스트에 대한 상대적인 이름) 
Context ct2=(Context)ct.lookup("java:comp/env"); : 이렇게 한다.

//server.xml 또는 context.xml,web.xml 에서 
//설정해놓은 이름 : jdbc/mysql
//DataSource ds=(DataSource)ct2.lookup("jdbc/mysql");

con=ds.getConnection();//커낵션 얻기 
--%>
