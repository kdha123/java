<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.main.Service"%>
<%@page import="com.webjjang.member.dto.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// MemberJoinservice 생성된 객체를 저장하는 변수
System.out.println(request.getServletPath());
Service service = Beans.getService("memberJoinService");
 
//한글처리
request.setCharacterEncoding("utf-8");
// 넘어오는 데이터를 받는다.
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String gender = request.getParameter("gender");
String birth = request.getParameter("birth");
String[] tels = request.getParameterValues("tel");
String tel = String.join("-", tels);
String email = request.getParameter("email");
// MemberDTO 객체를 생성 - 자료 저장
memberDTO dto = new memberDTO();
dto.setId(id);
dto.setPw(pw);
dto.setName(name);
dto.setGender(gender);
dto.setBirth(birth);
dto.setTel(tel);
dto.setEmail(email);

// MemberJoinService -> MemberDAO.join(dto)
// 실행방법. Execute.service(service, dto)
Execute.service(service, dto);

// 회원가입이 되면 자동으로 환영 메시지 페이지 이동
response.sendRedirect("/member/welcome.jsp?id="+id);
%>
