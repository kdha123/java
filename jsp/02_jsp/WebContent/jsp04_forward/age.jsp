<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>age.jsp</title>
</head>
<body>
<%
int age = Integer.parseInt(request.getParameter("age"));

if(age>0 && age<=10){
%>
<jsp:forward page="aa.jsp"/>
<%
}else if(age>10 && age<=20){
	
}else if(age>20 && age<=60){
	
}else if(age>60){
	
}

%>

</body>
</html>