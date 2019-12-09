<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
jspInit(), jspDestroy() 메서드는 프로그래머가 선언부에 선언해야한다.
</h3>
<%!
// 전역변수
String str="hello~";
%>

<%!
//jspInit()
public void jspInit(){
	str += "jspInit()  ";
	
	System.out.println("jspInit() method called...");
}
%>

<%!
//jspDestroy()
public void jspDestroy(){
	
	System.out.println("jspDestroy() method called...");
}
%>

<%--_jspService 부분 --%>
<%
str +="  _jspService() method called...  ";
%>

<%=str %><%--표현식 --%>
</body>
</html>