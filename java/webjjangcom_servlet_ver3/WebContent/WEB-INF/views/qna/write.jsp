<%@page import="com.webjjang.member.dto.LoginDTO"%>
<%@page import="com.webjjang.qna.dto.QnaDTO"%>
<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//질문답변의 질문하기 처리 - Beans 객체에 등록이 되어 있는지 확인한다.
Service service = Beans.getService("qnaWriteService");

System.out.println("질문하기 처리~~~qna/write.jsp");
//한글처리 -> 서버의 ISO-18~~~코드를 사용하므로 utf-8과는 다르다. 한글이 깨진다.
// 데이터가 넘어오는쪽(한글이 넘어올 때)
// request.setCharacterEncoding("utf-8");

// 1.데이터를 받는다.
// id는 로그인한 후에 처리해야 하므로 session에서 부터 꺼내는 것으로 한다.
String id = ((LoginDTO)session.getAttribute("login")).getId();
String title = request.getParameter("title");
String content = request.getParameter("content");

// 2. dto 객체를 만든다. 데이터 셋팅
QnaDTO dto = new QnaDTO();
dto.setTitle(title); 
dto.setContent(content);
dto.setId(id);
// 3. service객체를 호출해서 DB에서 호출받는다.
Execute.service(service, dto);

response.sendRedirect("list.jsp");%>
