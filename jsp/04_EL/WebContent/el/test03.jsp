<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--test03.jsp --%>

<%
request.setCharacterEncoding("utf-8");
%>

<h2>${sessionScope.id }님 완전 환영 </h2>

이름 : ${param.name }<br><%--request.getParameter("name"); --%>
주소 : ${param.addr}<br>
전화 : ${param.tel }<br>
취미 :<br>
${paramValues.hobby[0]}<br><%--request.getParameterValues("hobby") --%>
${paramValues.hobby[1]}<br>
${paramValues.hobby[2]}<br>
${paramValues.hobby[3]}<br>
${paramValues.hobby[4]}<br><%--배열로 넘어온다. --%>

    