<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%--remove.jsp --%>
<%
	//장바구니 내용을 vec에 할당
	Vector vec = (Vector) session.getAttribute("cart");
%>
<h2>삭제할 CD를 고르세요</h2>
<form method="post" action="cart.jsp">
	<select name="item">
		<%
			for (int i = 0; i < vec.size(); i++) {
		%>
		<option value="<%=vec.get(i).toString()%>">
			<%=vec.get(i).toString()%>
		</option>
		<%
			}//for end
		%>

	</select> 
	<input type="hidden" name="step" value="remove">
	 <input type="submit" value="삭제">
</form>




