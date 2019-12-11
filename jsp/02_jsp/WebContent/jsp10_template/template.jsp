<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String contentPage = request.getParameter("contentPage");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>template.jsp</title>
</head>
<body>

	<table align="center" width="90%" height="90%" border=3	bgColor="orange">
	<%--상단메뉴 --%>
		<tr>
			<td colspan="2" bgcolor="margenta" height="10%">
			<jsp:include page="top.jsp" flush="false" /> 
			<%-- flush="false"는 출력버퍼를 비우지 않는다. --%>
			</td>
		</tr>
		<tr>
			<%--왼쪽메뉴 --%>
			<td width="10%" valign="top" bgcolor="skyblue">
				<jsp:include page="left.jsp" flush="false"/>
			</td>
			
			<%--중앙배치 --%>
			<td width="80%" valign="top">
				<jsp:include page="<%=contentPage %>" flush="false"/>
			</td>
		</tr>
			<%--하단메뉴 --%>
		<tr>
			<td align="center" bgcolor="lightGray" height="10%" colspan="2">
				<jsp:include page="bottom.jsp" flush="false"/>
			</td>
		</tr>

	</table>

</body>
</html>