<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="mybean.TestBean"
    %>
<%--TestBean.jsp --%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="tb" class="mybean.TestBean">
	<jsp:setProperty name="tb" property="*"/>
</jsp:useBean>
<%--
4. <jsp:setProperty name="id명" property="*"/>
 --%>
 ID:<jsp:getProperty name="tb" property="id"/><br>
 PWD:<jsp:getProperty name="tb" property="pwd"/><br>
 Name:<jsp:getProperty name="tb" property="name"/><br>
 Addr:<jsp:getProperty name="tb" property="addr"/><br>
 Email:<jsp:getProperty name="tb" property="email"/><br>
 Tel:<jsp:getProperty name="tb" property="tel"/><br>
<br>

아이디:<%=tb.getId() %><br>
비밀번호:<%=tb.getPwd()%><br>
이름:<%=tb.getName() %><br>
주소:<%=tb.getAddr() %><br>
이메일:<%=tb.getEmail() %><br>
전화번호:<%=tb.getTel() %><br>
