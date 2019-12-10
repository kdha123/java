<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>08_config.jsp</title>
</head>
<body>

서블릿이름 : <%= config.getServletName() %><br>
서블릿 Context:<%= config.getServletContext() %><br>

이름: <%= config.getServletContext().getInitParameter("name")%><br>
이름: <%= application.getInitParameter("name")%>


</body>
</html>