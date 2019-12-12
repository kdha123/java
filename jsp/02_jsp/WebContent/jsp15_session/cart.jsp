<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--cart.jsp --%>
<%
request.setCharacterEncoding("utf-8");
%>
<html>
<body>
<%@ include file="menu.jsp" %>
<%
String item = request.getParameter("item");
String step = request.getParameter("step");
Vector vec = null;
%>
<%
if(item != null){//선택한 item이 있으면
	
	//장바구니 내용을 가져온다.
	vec = (Vector)session.getAttribute("cart");
	
	if(vec==null){//장바구니에 아무것도 없으면, 처음 물건을 선택했을 때
		vec = new Vector();//객체생성
		vec.add(item);//장바구니에 item넣기
		session.setAttribute("cart", vec);//session에 설정
	}else{
		//이미 선택된 CD가 있을 때
		if(step.equals("add")){
			vec.add(item);//장바구니에 추가(넣기)
		}else if(step.equals("remove")){
			vec.remove(item);//장바구니에서 item을 제거
		}//else if
	}//else
	out.println("쇼핑 cart에 담긴 CD<br>");
	for(int i=0; i<vec.size(); i++){//장바구니 내용을 뿌려준다.
		out.println((i+1)+":"+(vec.get(i).toString())+"<br>");
	}//for end
	%>
	현재 cart에 모두 <%=vec.size() %>개 담겨 있습니다.<br>
	<%
		if(vec.size()>0){//장바구니에 물건이 있을 때
		%>
		<jsp:include page="remove.jsp" flush="true"/>
		<%
		}//if
}//if
%>
</body>
</html>
    