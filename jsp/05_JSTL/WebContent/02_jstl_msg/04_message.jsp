<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--04_message.jsp --%>
<fmt:setLocale value="en"/>
<fmt:setLocale value="ja"/>
<fmt:setLocale value="ko"/>

<fmt:bundle basename="resource.testBundle">
	<html>
<body>
	<h2>JSTL fmt 예제 bundle message</h2>

	<fmt:message key="name" /><br>
	<fmt:message key="MSG" /><br>

	<fmt:message key="MSG" var="msg" />
	<c:out value="${msg}" />
	<%--변수내용 출력 --%>

</body>
	</html>
</fmt:bundle>

