<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--04_chooseTag.jsp --%>
<%--
choose 태그는 : java의 switch~case문과 유사하다.

choose 태그형식

<c:choose>
	<c:when test="${조건1}">
		처리내용
	</c:when>
	
	<c:when test="${조건2}">
		처리내용
	</c:when>
	
	<c:when test="${조건3}">
		처리내용
	</c:when>
	...
	
	<c:otherwise>
	위의 조건에 해당 사항이 없을 때 처리
	</c:otherwise>
</c:choose>

설명 : 조건이 true이면 when 태그 바디 부분을 처리한다.
모든 조건이 false이면 <c:otherwise> 태그에서 실행한다.
 --%>
 
<h2>choose 태그 실습</h2>
<ul>
	<c:choose>
		<c:when test="${param.name=='kim' }">
			<li>당신의 이름은 ${param.name }입니다.</li>
		</c:when>
		
		<c:when test="${param.age>18 }">
			<li>당신의 나이는 ${param.age }살이며 성인입니다.</li>
		</c:when>
		
		<c:when test="${param.age<=18 }">
			<li>당신의 나이는 ${param.age }살이며 미성년자입니다.</li>
		</c:when>
	
		<c:otherwise>
			 <li>당신의 이름은 ${param.name} 아닙니다.
		</c:otherwise>
	</c:choose>
<%-- http://localhost:9000/05_JSTL/01_jstl/04_chooseTag.jsp?name=kim&age=26
	switch case 문에서 break로 빠져나가는 것처럼 하나의 조건이 달성되면 그것을 실행하고 빠져나간다.
 --%>
</ul>

