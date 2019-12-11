<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--pageController.jsp --%>
pageController.jsp는 (흐름제어)
<br>

<h2>페이지 흐름제어</h2>
<%
	request.setCharacterEncoding("utf-8");

	String product = request.getParameter("product");

	String control = null;//변수선언
	String contentPage = null;
	String pageTitle = null;
%>

<%
	if (product.equals("d")) {
		control = "dc";
		contentPage = "dc.jsp";
		pageTitle = "디지털카메라";
	} else if (product.equals("p")) {
		control = "pmp";
		contentPage = "pmp.jsp";
		pageTitle = "PMP";
	}
%>
<jsp:forward page="template.jsp">
	<jsp:param value="<%=control%>" name="control" />
	<jsp:param value="<%=contentPage%>" name="contentPage" />
	<jsp:param value="<%=pageTitle%>" name="pageTitle" />
</jsp:forward>