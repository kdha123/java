<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>클라이언트 및 서버 정보</title>
</head>
<body>
<!-- JSP 기본객체 : JSP 프로그램에서 생성을 하지 않더라도 이미 생성이되어서 사용할 수 있는 객체 변수 -->
클라이언트 IP = <%=request.getRemoteAddr()%><br/>
<%System.out.println(request.getRemoteAddr());%>
요청정보길이 = <%=request.getContentLength()%><br/>
<!-- 한글처리 utf-8 -->
<%request.setCharacterEncoding("utf-8"); %>
엔코딩 = <%=request.getCharacterEncoding()%><br/>
콘텐트타입 = <%=request.getContentType()%><br/>
프로토콜 = <%=request.getProtocol()%><br/>
전송방식 = <%=request.getMethod()%><br/>
URL = <%=request.getRequestURL()%><br/>
경로 = <%=request.getContextPath()%><br/>
경로 = <%=request.getServletPath()%><br/>
서버이름 = <%=request.getServerName()%><br/>
서버포트 = <%=request.getServerPort()%><br/>
서버포트 = <%=request.getServerPort()%><br/>

<h2>넘어오는 데이터 확인 </h2>
글번호 = <%=request.getParameter("no") %><br/>
증가여부 = <%=request.getParameter("cnt") %><br/>

<h2>데이터를 저장하고 확인 </h2>
<%request.setAttribute("name", "김동현"); %>
이름 = <%=request.getAttribute("name") %><br/>
이름 = ${name }
</body>
</html>