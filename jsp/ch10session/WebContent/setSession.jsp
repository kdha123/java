<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//강제 로그인 처리-> 아이디, 이름, 등급번호
	String id="test";
	String name="홍길동";
	int grade = 1;
	// 다른 페이지에서 사용하기 위해서 session에 저장해둔다.
	session.setAttribute("id", id);
	session.setAttribute("name", name);
	session.setAttribute("grade", grade);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>강제로그인 페이지</h1>
SESSIONID:<%=session.getId()%><br/>
<button onclick="location='infoSession.jsp'">확인하는 페이지로 이동</button>
</body>
</html>