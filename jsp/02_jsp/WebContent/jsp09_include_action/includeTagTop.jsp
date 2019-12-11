<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>includeTagTop.jsp</title>
</head>
<body>

<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

String name = request.getParameter("name");
String addr = request.getParameter("addr");
String tel = request.getParameter("tel");
%>
<hr>
<h2>includeTagTop.jsp</h2>
ID:<%=id %><br>
PWD:<%=pwd %><br>
Name:<%=name %><br>
Addr:<%=addr %><br>
Tel:<%=tel %><br>
<hr>
</body>
</html>