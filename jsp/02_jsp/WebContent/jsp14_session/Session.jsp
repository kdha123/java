<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--Session.jsp --%>
<%
request.setCharacterEncoding("utf-8");//post 요청 한글처리
//클라이언트가 보낸 자료 받기
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

session.setAttribute("id", id); //session에 값 설정★★★★★★★★★★
session.setMaxInactiveInterval(60*5);//300초

%>

<form method="post" action="Session_2.jsp">
 1. 가장 좋아하는 계절을 선택하세요.<br>
 <input type="radio" name="season" value="봄">봄<br>
 <input type="radio" name="season" value="여름">여름<br>
 <input type="radio" name="season" value="가을">가을<br>
 <input type="radio" name="season" value="겨울">겨울<br>
 <br>
 2. 가장 좋아하는 과일을 선택하세요.<br>
 <input type="radio" name="fruit" value="사과">사과<br><input type="radio" name="fruit" value="멜론">멜론<br>
 <input type="radio" name="fruit" value="딸기">딸기<br>
 <input type="radio" name="fruit" value="망고">망고<br>
 <input type="radio" name="fruit" value="오렌지">오렌지<br>
	<br>
 <input type="submit" value="전송">
</form>


