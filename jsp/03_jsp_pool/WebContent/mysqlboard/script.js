function writeSave(){
	
	if(document.writeForm.writer.value==""){
		 alert("이름을 입력 하시요 ");
		 document.writeForm.writer.focus();
		 return false;
	}
	if(document.writeForm.subject.value==""){
		alert("글제목을 입력 하시요 ");
		document.writeForm.subject.focus();
		return false;
	}
	if(document.writeForm.email.value==""){
		alert("email을 입력 하시요 ");
		document.writeForm.email.focus();
		return false;
	}
	if(document.writeForm.content.value==""){
		alert("글내용을 입력 하시요 ");
		document.writeForm.content.focus();
		return false;
	}
	if(document.writeForm.passwd.value==""){
		alert("비밀번호를 입력 하시요 ");
		document.writeForm.passwd.focus();
		return false;
	}
	
 //script.js	
	/*
	if($("#writer").val()==''){
	   alert("이름을 입력 하시요 ");
	   $("#writer").focus();
	   return false;
   }
   if($("#subject").val()==''){
	   alert("글제목을 입력 하시요 ");
	   $("#subject").focus();
	   return false;
   }
   if($("#content").val()==''){
	   alert("글내용을 입력 하시요 ");
	   $("#content").focus();
	   return false;
   }
   if($("#passwd").val()==''){
	   alert("암호을 입력 하시요 ");
	   $("#passwd").focus();
		   return false;
	   }
	   */
   }//writeSave() end
	 
	

