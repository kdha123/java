<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%--redirect.jsp --%>

<%--
response.sendRedirect("list.jsp");
--%>

<c:redirect url="/01_jstl/03_iftag.jsp">
  <c:param name="name" value="park"/>
</c:redirect>
