<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>03_response.jsp</title>
</head>
<body>
<%
// out.println("현재 설정된 인코딩 문자 내용 알아보기<br>");
// out.println(response.getCharacterEncoding());

//2초후에 네이버로 이동
// response.setHeader("Refresh","2;URL=https://www.naver.com");

// response.sendRedirect("https://www.daum.net");

// response.sendRedirect("02_request.jsp");//로컬 URL

%>
<%-- forward 액션태그 --%>
<%-- <jsp:forward page="02_request.jsp"/> --%>

<%-- 외부 url은 안됨 --%>
<jsp:forward page="https://www.daum.net"/>
</body>
</html>