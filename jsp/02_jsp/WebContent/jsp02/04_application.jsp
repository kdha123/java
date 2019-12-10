<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>04_application.jsp</title>
</head>
<body>
<%
out.println("서버정보<br>");
out.println(application.getServerInfo());//서버 정보 표시
out.println("<br><br>");

out.println("aa.html MIME type 은<br>");
out.println(application.getMimeType("aa.html")); //MimeType을 알수있다. text/html같은..


%>
<br><br>

메이저 버전(정수부분) :<%= application.getMajorVersion()%><br>
마이너 버전(소수부분) :<%= application.getMinorVersion()%><br>
실제 경로   :<%= application.getRealPath("/") %><br>

<%
application.log("오늘 화요일 아직 안온 사람 ~");
%>
</body>
</html>