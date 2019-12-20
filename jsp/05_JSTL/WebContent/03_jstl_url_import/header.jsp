<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--header.jsp --%>

<hr size="3">
<c:if test="${param.id != null }">
  [HEADER] ${param.id }님의 방문을 완전 환영합니다 
</c:if>
<hr size="3">