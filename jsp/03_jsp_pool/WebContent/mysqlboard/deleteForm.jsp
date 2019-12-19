<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/color.jsp"%>
<%--deleteForm.jsp --%>
<%
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
%>

<html>
<head>
	<link rel="stylesheet" href="style.css" type="text/css">
	<script type="text/javascript">
	  function deleteSave(){
		  if(document.delForm.passwd.value==''){
			  alert("암호를 입력하세요");
			  document.delForm.passwd.focus();
			  return false;
		  }//if end
	  }//deleteSave() end
</script>
</head>
<body>
 <b><center><font size="+2">글삭제</font></center></b>
 <form name="delForm" method="post" action="deletePro.jsp?pageNum=<%=pageNum%>" onsubmit="return deleteSave()">
 	<table cellpadding="5" width="360" align="center">
 		<tr height="30">
 			<td align="center" bgcolor="<%=value_c%>">
 				<b>암호를 입력하세요.</b>
 			</td>
 		</tr>
 		
 		<tr height="30">
 			<td align="center"> 비밀번호
 				<input type="password" name="passwd" id="passwd" size="10">
 				<input type="hidden" name="num" value="<%=num%>">
 			</td>
 		</tr>
 		<tr height="30">
 			<td align="center" bgcolor="<%=value_c%>">
 			<input type="submit" value="글삭제">
 			<input type="button" value="글목록" onclick="document.location='list.jsp?pageNum=<%=pageNum%>'">
 			</td>
 		</tr>
 	</table>
 </form>
</body>
</html>