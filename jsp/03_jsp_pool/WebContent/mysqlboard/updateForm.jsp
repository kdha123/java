<%@page import="boardmysql.BoardDTO"%>
<%@page import="boardmysql.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/view/color.jsp" %>
<%--updateForm.jsp --%>
<%
request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<%
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
BoardDAO dao = BoardDAO.getDAO();// dao 객체 
BoardDTO dto = dao.updateGetArticle(num);
%>
<body>
	<center><b><font size="+2">글수정</font></b></center>
	<form method="post" action="updatePro.jsp?pageNum=<%=pageNum %>" name="writeForm">
		<table width="60%" cellpadding="5" align="center">
			<tr bgcolor="<%=value_c%>">
				<td width="70" align="center">이름</td>
				<td width="330">
					<input type="text" name="writer" id="writer" size="16" value="<%=dto.getWriter()%>">
					<input type="hidden" name="num" value="<%=num%>">
				</td>
			</tr>
			
			<tr bgcolor="<%=value_c%>">
				<td width="70" align="center">글제목</td>
				<td width="330">
					<input type="text" name="subject" id="subject" size="16" value="<%=dto.getSubject() %>">
				</td>
			</tr>
			<tr bgcolor="<%=value_c%>">
				<td width="70" align="center">이메일</td>
				<td width="330">
					<input type="text" name="email" id="email" size="16" value="<%=dto.getEmail() %>">
				</td>
			</tr>
			
			<tr bgcolor="<%=value_c%>">
				<td width="70" align="center">글내용</td>
				<td width="330">
				<textarea name="content" id="content" rows="10" cols="50"><%=dto.getContent() %></textarea>
				</td>
			</tr>
			
			<tr bgcolor="<%=value_c%>">
				<td width="70" align="center">암호</td>
				<td width="330">
					<input type="password" name="passwd" id="passwd" size="16">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글수정">
					<input type="reset" value="취소">
					<input type="button" value="글목록보기" onclick="document.location='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
