<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- template.jsp --%>

<%
String pageFile = request.getParameter("page");

if(pageFile == null){
	pageFile="newItem.jsp";
}
%>
<html>
<body bgcolor="skyblue">
	<table width="90%" heigth="99%" border="1" align="center">
		<%--상단메뉴 --%>
		<tr>
			<td colspan="2" width="15%" align="right" valign="top">
			<jsp:include page="top.jsp" /></td>
		</tr>


		<tr>
			<%--왼쪽메뉴 --%>
			<td width="15%" align="right" valign="top"><br>
			<br> <jsp:include page="left.jsp" /></td>

			<%--중앙에 내용표시 --%>
			<td align="center">
			<jsp:include page="<%=pageFile %>" /></td>
		</tr>

		<tr>
			<td colspan="2" height="40" align="center">
			<jsp:include page="bottom.jsp" /></td>
		</tr>
	</table>


</body>

</html>
