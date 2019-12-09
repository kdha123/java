<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test02</title>
</head>
<body>
jsp페이지는 HTML코드, JSP코드, JAVA코드...등을 사용할 수 있다.<br>

<h2>HTML코드</h2>
HTML코드<br>
HTML코드<br>
HTML코드<br>


<h2>JSP코드</h2>
<%="JSP코드" %><br>
<%= "JSP코드"%><br>
<%= "JSP코드"%><br>


<h2>JAVA코드</h2>
<%
out.println("JAVA코드<br>");
out.println("JAVA코드<br>");
out.println("JAVA코드<br>");
%>



</body>
</html>