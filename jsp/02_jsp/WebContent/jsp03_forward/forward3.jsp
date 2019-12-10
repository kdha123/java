<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forward3.jsp</title>
</head>
<body>
<h2>forward액션태그 forward3.jsp</h2>

<table border="1">
	<tr>
		<td>이름</td>
		<td><%=request.getParameter("name") %></td>
	</tr>
	<tr>
		<td>나이</td>
		<td><%=request.getParameter("age") %></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><%=request.getParameter("addr") %></td>
	</tr>
	<tr>
		<td>번호</td>
		<td><%=request.getParameter("tel") %></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><%= request.getParameter("email") %></td>
	</tr>

</table>
</body>
</html>