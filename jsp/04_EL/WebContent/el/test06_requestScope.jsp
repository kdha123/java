<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--test06_requestScope.jsp --%>

<%
request.setAttribute("name", "아이린");
%>
request의 name속성값 : ${requestScope.name }<br> 
request의 name속성값 : ${requestScope["name"]}<br>







    