<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardmysql.*" %>   
<%--updatePro.jsp--%>
<%
request.setCharacterEncoding("utf-8");
%>
<%--dto에 setter작업 --%>
<jsp:useBean id="dto" class="boardmysql.BoardDTO">
 <jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
String pageNum=request.getParameter("pageNum");
BoardDAO dao=BoardDAO.getDAO();//dao객체 얻기 
int check=dao.updateArticle(dto);//dao메서드 호출 

if(check==1){//정상 수정
	response.sendRedirect("list.jsp?pageNum="+pageNum);
}else{
	%>
	 <script>
	 alert("비밀번호가 틀립니다 ");
	 history.back();
	 </script>
	<%
	}//else---
%>