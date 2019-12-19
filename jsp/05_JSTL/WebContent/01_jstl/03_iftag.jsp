<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--03_iftag.jsp --%>
<%--
<c:if test="조건">
	조건이 참이면 처리할 내용
</c:if>

<c:if test="${true}">
 무조건 실행
</c:if>
 --%>
<h2>if tag 실습</h2>
 <c:if test="${param.name=='kim'}">
 	${param.name }님 환영합니다.
 </c:if>
 <%--http://localhost:9000/05_JSTL/01_jstl/03_iftag.jsp?name=kim --%>
 
 <c:if test="${param.age>18 }">
 	당신의 나이는 ${param.age}살이며 성인입니다.
 </c:if>
 
 <c:if test="${param.age<=18 }">
 	당신의 나이는 ${param.age }살이며 미성년자입니다.
 </c:if>
 <%--http://localhost:9000/05_JSTL/01_jstl/03_iftag.jsp?name=kim&age=26 --%>