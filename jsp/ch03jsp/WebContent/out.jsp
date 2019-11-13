<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- html 5에서는 dtd파일을 따로 지정하지는 않는다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
1~10까지 출력<br>
<!-- 1~10까지 출력하는 프로그램 작성 -->
<%
// 스크립트릿작성 - 자바부분입니다.
for(int i = 1; i<=10; i++)
	out.write(""+i+"<br>");
%>
 표현식을 이용한 숫자 출력&lt;%=data %&gt;<br>
<%
// 스크립트릿작성 - 자바부분입니다.
for(int i = 1; i<=10; i++){
%>
<%=i %><br>
<% }// end of for%>
<%
// 스크립트릿작성 - 자바부분입니다.
for(int i = 1; i<=10; i++){
	request.setAttribute("i", i);
%>
<!-- 서버저장 객체 사용해서 출력 -> 서버저장 객체에 저장을 해놓아야한다. -->
<!-- :application, session, request,page--> 
${i } <br>
<% }// end of for%>

</body>
</html>