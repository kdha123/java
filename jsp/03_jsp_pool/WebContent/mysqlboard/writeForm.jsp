<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/view/color.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>writeForm.jsp</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src="script.js"></script>
</head>
<%

int num=0;//변수
int ref=1;//글 그룹
int re_step=0;//글 순서 정리 
int re_level=0;//글깊이 depth=들여쓰기
String reddate="";

if(request.getParameter("num") != null){//답글
	num=Integer.parseInt(request.getParameter("num"));
	ref=Integer.parseInt(request.getParameter("ref"));
	re_step=Integer.parseInt(request.getParameter("re_step"));
	re_level=Integer.parseInt(request.getParameter("re_level"));
}//if end
%>

<body>
<h2><center>글쓰기, 답글쓰기</center></h2>
<form name="writeForm" method="post" action="writePro.jsp" onSubmit="return writeSave()">
  <input type="hidden" name="num" value="<%=num%>">
  <input type="hidden" name="ref" value="<%=ref%>">
  <input type="hidden" name="re_step" value="<%=re_step%>">
  <input type="hidden" name="re_level" value="<%=re_level%>">
	
  <table width="500" cellpadding="3" bgColor="<%=bodyback_c%>" align="center">
    <tr>
    <td colspan="2" align="right" bgColor="<%=value_c %>">
      <a href="list.jsp">글목록보기</a>
    </td>
    </tr>
    
    <%--이름 --%>
    <tr bgColor="<%=value_c%>">
      <td width="70">이름</td>
      <td width="330">
        <input type="text" name="writer" id="writer" size="12">
      </td>
    </tr>
   <%--글제목 --%>
    <tr bgColor="<%=value_c%>">
      <td>글제목</td>
      <td>
      <%
       if(request.getParameter("num")==null){//원글
    	 %>
    	 <input type="text" name="subject" id="subject" size="40">
    	 <%  
       }else{//답글
    	 %>
    	 <input type="text" name="subject" id="subject" size="40" value="[답글]">
    	 <%
       }//else end--
      %>
      
      </td>
    </tr>
    
    <%--email --%>
    <tr bgColor="<%=value_c%>">
      <td>이메일</td>
      <td><input type="text" name="email" id="email" size="30" placeholder="aaa@nate.com"></td>
    </tr>
    
    <%--글내용 --%>
    <tr bgColor="<%=value_c%>">
      <td>글내용</td>
      <td>
       <textarea name="content" id="content" rows="10" cols="50"></textarea>
      </td>
    </tr>
    
    <%--비밀번호 --%>
    <tr bgColor="<%=value_c%>">
      <td>비밀번호</td>
      <td>
       <input type="password" name="passwd" id="passwd" size="12">
      </td>
    </tr>
    
    <tr bgColor="<%=value_c%>">
      <td colspan="2" align="center">
        <input type="submit" value="글쓰기">
        <input type="reset" value="취소">
        <input type="button" value="글목록보기" onClick="window.location='list.jsp'">
      </td>
    </tr>
  </table>
</form>

</body>
</html>