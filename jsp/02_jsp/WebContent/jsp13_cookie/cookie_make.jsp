<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--cookie_make.jsp --%>
<%
request.setCharacterEncoding("utf-8");
%>
<html>
<body>
	<%
	//쿠키심기
	String visitor=request.getParameter("visitor");
	Cookie cookie=new Cookie("visitor",URLEncoder.encode(visitor));//쿠키생성
	//                         name,        value
	
	cookie.setMaxAge(30*24*60*60);// 쿠키 유효기간 설정 
//               30일*24시간*60분*60초
	//클라이언트에 쿠키를 심는다 
	response.addCookie(cookie);
	
	%>
	
	<a href="cookie_view.jsp">cookie_view.jsp 돌아가기</a>
	
	
</body>
</html>




