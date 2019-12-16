<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="mail.MailSender"
    import="com.oreilly.servlet.*"
    %>
    
<%--MailSend.jsp --%>
<jsp:useBean id="mailSender" class="mail.MailSender">
	<jsp:setProperty name="mailSender" property="*"/>
</jsp:useBean>

<%=mailSender.send() %>
