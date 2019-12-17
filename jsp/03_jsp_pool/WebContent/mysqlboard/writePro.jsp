<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="boardmysql.*" %>    
<%--writePro.jsp--%>

<%
request.setCharacterEncoding("utf-8");
%>

<%-- dto에 setter 작업--%>
<jsp:useBean id="dto" class="boardmysql.BoardDTO">
  <jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
 //ip setter 작업 
 dto.setIp(request.getRemoteAddr());

 BoardDAO dao=BoardDAO.getDAO();//dao 객체 얻기
 dao.insertArticle(dto);//dao메서드 호출 , DB에 글쓰기
 response.sendRedirect("list.jsp");//list.jsp 페이지 이동
%>