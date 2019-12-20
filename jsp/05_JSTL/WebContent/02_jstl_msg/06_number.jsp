<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--06_number.jsp --%>
<%--
Variable---var
value---value

 --%>
<html>
<body>
   <h2>JSTL fmt 예제 formatNumeric, formatDate</h2>
   
   number(숫자표시) : <fmt:formatNumber value="12345.678" type="number"/><br>
   
   currency(통화기호) : 
	<fmt:formatNumber value="12345.678" type="currency" currencySymbol="￦"/>
	<br>
	
   percent(퍼센트) : <fmt:formatNumber value="12345.678" type="percent"/><br>
  
   pettern : ".0":<fmt:formatNumber value="12345.678" pattern=".0"/><br>
  
  <%--------날짜----------------------------------------- --%>
  <h2>날짜시간</h2>
    <c:set var="now" value='<%= new java.util.Date()%>'/>
  
    <c:out value="${now}"/><br>
	
	date :<fmt:formatDate value="${now}" type="date"/><br>
	time :<fmt:formatDate value="${now}" type="time"/><br>
	both :<fmt:formatDate value="${now}" type="both"/><br>
</body>

</html>
