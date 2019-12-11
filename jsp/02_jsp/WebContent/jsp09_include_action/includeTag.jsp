<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");//post 요청시 한글처리
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>includeTag.jsp</title>
</head>
<body>
includeTag.jsp<br>
includeTag.jsp<br>
includeTag.jsp<br>
<hr>
<jsp:include page="includeTagTop.jsp">
<jsp:param value="벤틀리" name="name"/>
<jsp:param value="서울구로구" name="addr"/>
<jsp:param value="010-1111-1111" name="tel"/>
</jsp:include>
<hr>

includeTag.jsp<br>
includeTag.jsp<br>
includeTag.jsp<br>
</body>
</html>