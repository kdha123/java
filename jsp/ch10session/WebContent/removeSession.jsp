<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%session.invalidate(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃페이지</title>
</head>
<body>
<h1>로그아웃 페이지</h1>
<button onclick="location='setSession.jsp'">강제로그인처리</button>
<button onclick="location='infoSession.jsp'">로그인 정보확인</button>
</body>
</html>