function writeSave(){
 //script.js		   
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
   }//writeSave() end
	 

