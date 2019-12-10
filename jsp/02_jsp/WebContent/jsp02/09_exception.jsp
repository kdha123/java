<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="09_err.jsp" %>

<%--예외가 발생하면 09_err.jsp 가서 메시지를 뿌리게 한다 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>09_exception.jsp</title>
</head>
<body>
<%
//지역변수
int a=7;
int b=0;
%>
a+b=<%= a+b%><br>
a-b=<%= a-b%><br>
a*b=<%= a*b%><br>
a/b=<%= a/b%><br>
a%b=<%= a%b%><br>

</body>
</html>