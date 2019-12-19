<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--test01.jsp --%>    
    
<%--default 값은 get방식! --%>
메서드방식 알아보기:<br>
 표현식: <%=request.getMethod()%><br>
 표현언어 : ${pageContext.request.method}<br>

 <br>
 요청시 헤더부분의 정보 알아보기 <p>
 
  표현식<%=request.getHeader("host")%><p>
  
  표현언어 ${header.host}<p>
  표현언어 ${header["host"]}<p>
  표현언어 ${headerValues}<p>
  <br><br>