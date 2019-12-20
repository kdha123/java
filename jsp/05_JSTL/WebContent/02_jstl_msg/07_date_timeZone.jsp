<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--07_date_timeZone.jsp --%>
<html>
  <body>
     <h2>JSTL fmt 예제 timeZone</h2>
     <c:set var="now" value='<%= new java.util.Date()%>'/>
     
       Korea KST :
		<fmt:formatDate value="${now}" type="both" dateStyle="full" 
		timeStyle="full"/>
		<br>

		UK GMT : 
		<fmt:timeZone value="GMT">
			<fmt:formatDate value="${now}" type="both" dateStyle="full"
			 timeStyle="full"/>
		</fmt:timeZone>
		
  </body>
</html>
<%--
timeZone : 각 나라별 시간대를 나타냅니다 

<fmt:formatDate value="${now}" .../> 사용해서 현재 우리나라 시간대를 표시
<fmt:timeZone value="GMT"> 로 설정해서 영국 시간대를 표시 합니다 

GMT [Greenwich Mean Time] 그리니치평균시.
런던교외의 그리니치 천문대의 자오선상에서의 평균 태양시를 기준으로 하여
전세계의 지방표준시를 나타냄.
--%>
    