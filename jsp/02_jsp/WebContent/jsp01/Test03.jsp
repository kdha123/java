<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test03</title>
</head>
<body>
<%--JSP주석 --%>
<%
// java 주석
/* java 주석*/
%>
<!-- HTML주석 -->
<h2>JSP주석</h2>
<%--
JSP주석은 숨은 주석이라한다.왜냐하면 웹상에서 소스보기 할 때 안보인다.
 --%>
<h2>JAVA주석</h2>
<%
//out.println("안녕");
/*out.println("hello");*/
%>
<h2>HTML주석</h2>
<!-- 
안녕<br>
hello<br>
보인다<br>
 -->

</body>
</html>