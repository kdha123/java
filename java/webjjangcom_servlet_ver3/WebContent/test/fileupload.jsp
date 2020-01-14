<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//여기가 자바입니다.
//첨부파일의 용량 제한
int size = 100*1024*1024;
// 파일을 업로드할 서버의 절대위치: 하드디스크의 위
String uploadPath = request.getServletContext().getRealPath("upload");
System.out.println(uploadPath);
//new MultipartRequest(request, 파일이 올라간 하드디스크의 위치와 파일명, 용량제한, encoding, 중복처리프로그램)
MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());

// 서버에 올라간 파일명
String fsName = multi.getFilesystemName("multiFile");
// 내 컴퓨터의 파일명
String oName = multi.getOriginalFileName("multiFile");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 처리</title>
</head>
<body>
<h2>파일업로드 처리</h2>
<p>파일 업로드 처리됨.</p>
<div>서버의 올라간 정보:<%=fsName %></div>
<div>내 컴퓨터 올라가기전 정보:<%=oName %></div>
<div><img alt="<%=fsName%>" src="/upload/<%=fsName%>"></div>
</body>
</html>