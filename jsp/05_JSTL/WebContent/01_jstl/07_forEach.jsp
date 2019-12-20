<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardmysql.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--07_forEach.jsp --%>
<%
BoardDAO dao = BoardDAO.getDAO();
%>
<%
List<BoardDTO> list=dao.getList(1,10);
request.setAttribute("list", dao.getList(1, 10));
%>
<c:set var="list2" value="<%=list %>"/>

<c:forEach var="dto" items="${list2 }">
${dto.writer }&nbsp;&nbsp;
${dto.subject }&nbsp;&nbsp;
${dto.content }<br>
</c:forEach>
    