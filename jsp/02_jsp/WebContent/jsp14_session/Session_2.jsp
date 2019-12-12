<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--Session_2.jsp --%>
<%
request.setCharacterEncoding("utf-8");

String season = request.getParameter("season");
String fruit = request.getParameter("fruit");

//****** id 얻기*******
String id = (String)session.getAttribute("id");

//session ID얻기 session ID는 자동으로 부여된다.
String sessionId= session.getId();

int intervalTime = session.getMaxInactiveInterval(); //세션 유지 시간 얻기
%>

<%
if(id != null){//로그인 상태이면
%>
<b><%=id %></b>님이 좋아하는 계절과 과일은<br>
<b><%=season %></b>과 <b><%=fruit %></b>입니다.
<br>

sessionID: <%=sessionId %><br>
세션유지시간:<%=intervalTime %>초<br>
<%
session.invalidate();//세션 무효화

}else{//로그인 상태가 아니면
%>
세션시간이 경과하였거나 다른 이유로 연결할 수 없습니다.<br>
<a href="Session.html">로그인을 다시해주세요.</a>
<%
}//else end
%>


    