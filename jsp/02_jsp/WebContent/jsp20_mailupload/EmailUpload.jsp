<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- EmailUpload --%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="emailUpload" class="emailupload.EmailUpload"/>
<%
//emailupload.EmailUpload emailUpload2 = new emailupload.EmailUpload();
%>

<%= emailUpload.upload(request)%>
    