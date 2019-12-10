<%@ page
info="page객체 예제"
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>07_page.jsp</title>
</head>
<body>
<h2>page 객체실습</h2>

info:<%=this.getServletInfo() %><br>
서블릿이름:<%=this.getServletName() %><br>
클래스 :<%=this.getClass() %><br>

</body>
</html>