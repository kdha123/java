<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>05_application.jsp</title>
</head>
<body>
이름:<%=application.getInitParameter("name") %><br>
TEL:<%=application.getInitParameter("tel") %><br>
주소:<%=application.getInitParameter("addr") %>
</body>

</html>