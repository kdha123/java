<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--import.jsp --%>

<c:import url="url.jsp" var="url1"/>

<c:import url="http://localhost:9000/05_JSTL/03_jstl_url_import/header.jsp" var="hh">
  <c:param name="id"  value="park"/>
</c:import>

<c:import url="https://www.daum.net" var="daum"/>
<c:import url="http://localhost:9000/03_jsp_pool/mysqlboard/list.jsp" var="board"/>

<c:import url="footer.jsp" var="foot"/>

<%--디자인, 배치 --%>
<html>
<body>
<table border="1">
	<tr>
		<td>${hh }</td>
	</tr>
	<tr>
		<td>
			<table height="70%">
				<tr>
<%-- 				<td>${url1 }</td> --%>
<%-- 				<td>${daum }</td> --%>
				<td>${board }</td>
				</tr>
			</table>
		</td>
	</tr>
	
	   
     <tr>
     <td>${foot}</td>
     </tr>
	
</table>
</body>
</html>

    