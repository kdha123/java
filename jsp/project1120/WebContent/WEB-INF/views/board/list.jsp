<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<!-- BootStrap lib 등록 : CDN-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
.dataRow:hover {
	background: #5CEEE6;
	cursor: pointer;
}
</style>
</head>
<body>
<div class="container">
<h2>게시판 리스트</h2>
<table class = "table">
<tr>
<th>번호</th>
<th>제목</th>
<th>작성자</th>
<th>작성일</th>
<th>조회수</th>
</tr>
<c:forEach items="${list }" var="dto" >
<tr class="dataRow">
<td>${dto.no }</td>
<td>${dto.title }</td>
<td>${dto.writer }</td>
<td>${dto.writeDate }</td>
<td>${dto.hit }</td>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>