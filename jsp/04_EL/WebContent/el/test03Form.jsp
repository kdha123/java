<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- test03Form.jsp--%>
<%
session.setAttribute("id", "admin");
%>
<html>
	<body>
	 <form method="post" action="test03.jsp">
	 	<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name" size="20" value="아이유"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" id="addr" size="50" value="경기도 부천시"></td>
			</tr>
			
			<tr>
				<td>전화</td>
				<td><input type="text" name="tel" id="tel" size="14" value="010-1111-1111"></td>
			</tr>
			
			<tr>
				<td>취미</td>
				<td>
					<input type="checkbox" name="hobby" value="수영">수영<br>
					<input type="checkbox" name="hobby" value="축구">축구<br>
					<input type="checkbox" name="hobby" value="여행">여행<br>
					<input type="checkbox" name="hobby" value="영화">영화<br>
					<input type="checkbox" name="hobby" value="먹기">먹기<br>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="전송">
					<input type="reset" value="취소">
				</td>
			</tr>
				
	 	</table>
	 </form>
	</body>
</html>