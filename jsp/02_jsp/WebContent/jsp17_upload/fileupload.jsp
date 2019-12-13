<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <jsp:useBean id="bb" class="upload.FileUploadBean" scope="request"/>
  <%--객체생성 기능이다 --%>
  
  <%= bb.upload(request) %>
    