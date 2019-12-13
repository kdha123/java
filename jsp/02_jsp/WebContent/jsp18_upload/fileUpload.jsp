<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>

<%--fileUpload.jsp --%>
<%
request.setCharacterEncoding("utf-8");
String savePath="c:/_jsp/upload";
int sizeLimit = 1024*1024*5; //5MB

try{
	MultipartRequest mul = 
			new MultipartRequest(request, savePath,sizeLimit,"utf-8", new DefaultFileRenamePolicy());
	
	//form에서 전송된 파일정보를 가져오기.
	Enumeration formNames=mul.getFileNames();
	
	//파일 업로드가 여러개  일 경우 while문 사용
	String formName=(String)formNames.nextElement();
	
	//서버에 저장된 파일 이름를 리턴 (파일의 이름 얻기)
	String fileName=mul.getFilesystemName(formName); 
	
	  if(fileName == null) {// 파일이 업로드 되지 않았을때
		    out.print("파일 업로드 되지 않았음");
		    
  	  }else{  // 파일이 업로드 되었을때
  		//웹 브라우저에 출력
  		//일반 자료
  	  out.print("Name:"+mul.getParameter("name")+"<BR>");//★★★
  	  out.print("ID:"+mul.getParameter("id")+"<BR>");//★★★
  	  out.print("PWD:"+mul.getParameter("pwd")+"<BR>");//★★★

  	  //참고
  	  out.print("Form 안의  Name : " + formName + "<BR>");//별의미 없음
	  out.print("File Name  : " + fileName);//별의미 없음

	  //input 태그속성이 file인것,//서버에 저장된 파일 이름  
	  String fileName2=mul.getFilesystemName("upfile");

	  // 전송된 원래 파일 이름
	  String original=mul.getOriginalFileName("upfile");
	  
	  //input 항목이름에 해당하는 
	  //파일 정보를 File형으로 리턴합니다
	  File file=mul.getFile("upfile"); 
	  
	  // 전송된 file 의 contentType
	  String type=mul.getContentType("upfile");
	  
	  out.print("<br><br>실제파일이름 :"+original+"<br>");
	  out.print("저장된 파일 이름 :"+fileName2+"<br>");
	  out.print("file getFile : "+file+"<br>");
	  out.print("파일 타입 :"+type+"<br>");
	  
	  if(file != null){
		  out.print("파일 size : "+ file.length()+"<br>");
	  }//if
		  
  	  
      }//else end
	
}catch(Exception ex){
	out.println("파일업로드 예외");
}// try catch end
%>

