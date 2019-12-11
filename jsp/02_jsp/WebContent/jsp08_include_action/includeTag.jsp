<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");// post 요청 한글처리
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>includeTag.jsp</title>
</head>
<body>
<%--include 액션 태그는 처리 결과가 들어온다  --%>
includeTag.jsp<br>
includeTag.jsp<br>
<%
String name = "Korea Football";//변수
%>
<hr>
<jsp:include page="includeTagTop.jsp"/>
<hr>

<%=name %><br><br>
includeTag.jsp<br>
includeTag.jsp<br>

</body>
</html>