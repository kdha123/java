<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 03_requestEncoding.jsp --%>

<%
// request.setCharacterEncoding("utf-8");
%>

<fmt:requestEncoding value="utf-8"/>
<html>
<body>
<pre>
out 태그는 웹을 출력하는 태그입니다.
</pre>

<c:out value="out태그는 웹으로 출력하는 태그이다."/>
<br>
파라미터값:<c:out value="${param.name }"/>

<form method="post" action="03_requestEncoding.jsp">
이름:<input type="text" name="name" value="아이린">
<input type="submit" value="전송">
</form>
</body>

</html>
    