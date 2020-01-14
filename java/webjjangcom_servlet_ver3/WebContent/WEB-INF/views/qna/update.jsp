<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.qna.dto.QnaDTO"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 이곳을 실행했다는 처리내용 출력
Service service = Beans.getService("qnaUpdateService");
// 한글처리
request.setCharacterEncoding("utf-8");
// 데이터를 받는다.
int no = Integer.parseInt(request.getParameter("no"));
String title = request.getParameter("title");
String content = request.getParameter("content");
// dto를 만든다. 
QnaDTO dto = new QnaDTO();
dto.setNo(no);
dto.setTitle(title);
dto.setContent(content);
// 서비스를 호출해서 데이터를 수정
Execute.service(service, dto);

System.out.println("글 수정처리~");

response.sendRedirect("view.jsp?no="+dto.getNo()+"&cnt=0");%>
