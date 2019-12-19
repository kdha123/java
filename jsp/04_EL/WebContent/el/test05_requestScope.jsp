<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--test05_requestScope.jsp --%>

<br>
파라미터값 id: ${param.id }<br>
파라미터값 pwd : ${param.pwd }<br>

<br>
요청URI : ${pageContext.request.requestURI }<br>
요청URL : ${pageContext.request.requestURL }<br>
