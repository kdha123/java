<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션정보확인</title>
</head>
<body>
<h1>세션정보 확인 페이지</h1>
<h2>저장되어 있는 데이터 출력</h2>
<!-- 세션유지시간을 10초로 셋팅<br/> -->
<%-- <% session.setMaxInactiveInterval(10); %>  --%>
SESSIONID:<%=session.getId()%><br/>
SESSION TIME:<%=session.getMaxInactiveInterval()%><br/>

<% if(session.getAttribute("id") != null) {%>
	아이디:<%=session.getAttribute("id")%><br/>
	이름:<%=session.getAttribute("name")%><br/>
	등급:<%=session.getAttribute("grade")%><br/>
	<button onclick="location='removeSession.jsp'">로그아웃</button>
	<%}else{%>
		로그인되어 있지 않습니다.<br/>
	<% }%>
	<button onclick="location='setSession.jsp'">강제로그인처리로 이동</button>
</body>
</html>