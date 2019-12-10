<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>02_request.jsp</title>
</head>
<body>
<h2>02_request.jsp 김동현</h2>
<%
String ip=request.getRemoteAddr();
/*
if(ip.equals("192.168.1.39")){
	out.println("이 ip로는 접속할 수 없습니다");
	return;
}
*/

%>
<li> 메서드 방식:<%= request.getMethod()%>
<li> 요청 URI :<%= request.getRequestURI() %>
<li> 요청 URL :<%= request.getRequestURL() %>
<p>

<li>프로토콜 :<%=request.getProtocol() %><%--서버 HTTP/1.1 --%>
<li>서버이름 :<%=request.getServerName() %> <%--도메인 이름 --%>
<li>서버포트번호 :<%=request.getServerPort() %> <%--9000 --%>
<p>
<li>사용자 컴퓨터 주소:<%=request.getRemoteAddr() %><%--클라이언트 ip --%>
<li>사용자 컴퓨터이름 :<%= request.getRemoteHost() %><%--클라이언트 --%>

<p>
<li>현재 사용중인 웹 브라우저 :
<%=request.getHeader("User-Agent") %>

<p>
<li>브라우저를 지원하는 file의 type: text/html
<%=request.getHeader("Accept") %>

<p>
<li>이전 URL 알아내기 :
<%=request.getHeader("referer") %>


</body>
</html>