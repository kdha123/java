<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 사용자컴퓨터의 저장되어 있는 캐시 파일을 사용하지 않도록 설정 -> 소스가 자주 변경이 되는 경우만 사용
	response.setHeader("Cache-Control", "no-cache");
	// 페이지 이동
	// response.sendRedirect("url?k=v");
	// 서버는 속도가 빠르다. 통신장비는 속도가 느리다. 클라이언트 컴퓨터도 속도가 다르다.
	// 서로 속도가 다른 장비들을 가지고 처리하려고 하면 속도가 제일 느린 것에맞춰야한다.
	// 데이터를 한개 씩 처리하지 않고 한꺼번에 모아서(버퍼) 처리하도록 하자.
	// 마지막 남은 데이터를 넘겨주는 메서드-> flushBuffer
	response.flushBuffer();
	response.setContentType("text/html;charset=utf-8");
	// response.set
	PrintWriter out2 = response.getWriter();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response 객체</title>
</head>
<body>
	변경되는 대로 바로 적용시키기 : header(Cache-Control)-> no-cache<br />
	변경되는 대로 바로 적용시키기 : &lt;F5&gt; 키 대신에 &lt;Ctrl&gt;+&lt;F5&gt;<br />
	버퍼사이즈 :<%=response.getBufferSize()%><br/>
	버퍼사이즈 :<% out.print(response.getBufferSize()); %><br/>
	버퍼사이즈 :<% out2.print(response.getBufferSize()); %><br/>

</body>
</html>