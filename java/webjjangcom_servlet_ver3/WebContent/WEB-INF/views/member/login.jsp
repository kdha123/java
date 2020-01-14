<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.member.dto.LoginDTO"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Service service = Beans.getService("memberLoginService");
 
//한글처리
request.setCharacterEncoding("utf-8");
//데이터 받기
String id = request.getParameter("id");
String pw = request.getParameter("pw");
//넘겨줄 데이터(DTO)
LoginDTO dto = new LoginDTO();
dto.setId(id);
dto.setPw(pw);
//처리
session.setAttribute("login",Execute.service(service, dto));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리 페이지</title>
</head>
<body>
<h1>로그인 처리 페이지</h1>
<%if(session.getAttribute("login") == null){ %>
	<h2>로그인 실패</h2>
	<p>
	로그인정보(아이디, 비밀번호)를 확인하시고 다시 시도해주세요.
	</p>
	<button onclick="location = 'loginForm.jsp'">로그인페이지 이동</button>
<% }else {%>
	<h2>로그인 정보 출력</h2>
	<p>
		아이디 : ${login.id }<br/>
		이름 : ${login.name }<br/>
		등급 : ${login.grade }<br/>
		등급이름 : ${login.gradeName }<br/>
	</p>
	<button onclick="location='logout.jsp'">로그아웃</button>
	
<%}%>
</body>
</html>