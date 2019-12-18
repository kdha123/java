<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardmysql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="/view/color.jsp" %>    
<%--content.jsp--%>
<html>
 <head>
   <link href="style.css" rel="stylesheet" type="text/css">
 </head>
 
 <%
 int num=Integer.parseInt(request.getParameter("num"));
 String pageNum=request.getParameter("pageNum");
 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
 BoardDAO dao=BoardDAO.getDAO();;//dao 객체 얻기 
 BoardDTO dto=dao.getArticle(num);//dao메서드 호출 
 
 int ref=dto.getRef();
 int re_step=dto.getRe_step();
 int re_level=dto.getRe_level();
 %>
 <body>
   <h1><center>글내용보기</center></h1>
   <table width="60%" cellpadding="3" align="center">
   
     <tr height="30">
       <td align="center" width="125" bgcolor="<%=value_c%>">글번호</td>
       <td align="center" width="125"><%=dto.getNum() %></td>
       
       <td align="center" width="125" bgcolor="<%=value_c%>">조횟수</td>
       <td align="center" width="125"><%=dto.getReadcount() %></td>
     </tr>
     
     <tr height="30">
       <td align="center" width="125" bgcolor="<%=value_c%>">글쓴이</td>
       <td align="center" width="125"><%=dto.getWriter() %></td>
       
       <td align="center" width="125" bgcolor="<%=value_c%>">작성일</td>
       <td align="center" width="125"><%=dto.getReg_date() %></td>
     </tr>
   
     <tr height="30">
       <td align="center" width="125" bgcolor="<%=value_c%>">글제목</td>
       <td colspan="3" align="center" width="125"><%=dto.getSubject() %></td>
     </tr>
     
     <tr height="30">
       <td align="center" width="125" bgcolor="<%=value_c%>">글내용</td>
       <td colspan="3" align="center" width="125" bgcolor=<%=value_c %>>
       
       <%
	     String im = dto.getContent();
        im = im.replace("\n", "<br>");
       %>
        <%=im %>
       
       </td>
     </tr>
      
     <tr height="30">
       <td colspan="4" bgcolor="<%=value_c%>" align="right">
       <input type="button" value="글수정" onClick="document.location.href='updateForm.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>'">
       <input type="button" value="글삭제" onClick="document.location.href='deleteForm.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>'">
       <input type="button" value="답글쓰기" onClick="document.location.href='writeForm.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>&ref=<%=ref%>&re_step=<%=re_step%>&re_level=<%=re_level%>'">
       <input type="button" value="리스트" onClick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
       </td>
     </tr>
      
   </table>
 </body>

</html>