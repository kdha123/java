<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%--05_message.jsp --%>
<fmt:setLocale value="en"/>
<fmt:setLocale value="ko"/>
<fmt:bundle basename="resource.message">
 <fmt:message key="title" var="tt"/>
 <h2>${tt }</h2>
 <fmt:message key="greeting"/><br>
 
 <c:if test="${! empty param.id}">
    <fmt:message key="visitor">
   	 	<fmt:param value="${param.id}" />
   	 	<fmt:param value="${param.pwd}" />
	</fmt:message>
  </c:if>
</fmt:bundle>
<%--http://localhost:9000/05_JSTL/02_jstl_msg/05_message.jsp?id=kim --%>
<%--http://localhost:9000/05_JSTL/02_jstl_msg/05_message.jsp?id=kim&pwd=12345 --%>
