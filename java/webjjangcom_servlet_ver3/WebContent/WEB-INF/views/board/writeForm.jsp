<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<!-- jQuery lib는 default_decorator.jsp에서 등록 -->
<script type="text/javascript" src="/js/regExutil.js"></script>
<script type="text/javascript">
$(function(){
	//js 패턴 객체
// 	title_RegEx = /^.{4,100}$/;
// 	content_RegEx = /^.{4,1000}$/;
// 	writer_RegEx = /^.{2,10}$/;
	
	// writeForm안에 데이터가 넘어갈 때(submit) testing
	$("#writeForm").submit(function(){
// // 		alert("데이터가 넘어 가기전 확인 함수.");
// 		//title 체크
// 		// 앞뒤공백제거
// 		$("#title").val($("#title").val().trim());
// // 		alert("["+$("#title").val()+"]");
// 		if(!title_RegEx.test($("#title").val())){
// 			//경고창을 띄운다.
// 			alert("제목은 4글자 이상 100글자 이내로 작성하셔야 합니다.");
// 			//다시 제목을 입력할 수 있도록 제목 입력란에 커서를 위치시킨다.
// 			$("#title").focus();
// 			return false;
// 		}
// 		//content체크
// 		$("#content").val($("#content").val().trim());
// 		if(!content_RegEx.test($("#content").val())){
// 			//경고창을 띄운다.
// 			alert("내용은 4글자 이상 1000글자 이내로 작성하셔야 합니다.");
// 			//다시 제목을 입력할 수 있도록 제목 입력란에 커서를 위치시킨다.
// 			$("#content").focus();
// 			return false;
// 		}
// 		$("#writer").val($("#writer").val().trim());
// 		if(!writer_RegEx.test($("#writer").val())){
// 			//경고창을 띄운다.
// 			alert("작성자는 2글자 이상 10글자 이내로 작성하셔야 합니다.");
// 			//다시 제목을 입력할 수 있도록 제목 입력란에 커서를 위치시킨다.
// 			$("#writer").focus();
// 			return false;
// 		}

	// 데이터를 검사하는 regExUtil.js 파일 사용한 데이터 검사
	// 제목 - 데이터가 유효하지 않으면(!) 더 이상 진행하지 않고 false를 리턴한다.
	alert("submit()");
	if(!inputDataCheck(title_RegEx,"#title",title_err_msg))
		return false;
	// 내용
	if(!inputDataCheck(content_RegEx,"#content",content_err_msg))
		return false;
	// 작성자
	if(!inputDataCheck(writer_RegEx,"#writer",writer_err_msg))
		return false;
	
	
	});
	
});

</script>
</head>
<body>
	<div class="container">
		<h2>글쓰기</h2>
		<!-- 많은 데이터를 넘길 때는 form action -->
		<form action="write.do" method="post" id="writeForm">
			<div class="form-group">
				<label for="title">제목 :</label>
				<!-- 입력한 데이터의 앞뒤 공백문자는 제거(trim()) id, class : 화면 컨트롤을 위해서(빠른 선택), name:넘어가는 데이터 이름 -->
				 <input type="text"
					class="form-control" id="title" placeholder="제목입력" name="title">
<!-- 					pattern="^.{4,100}$" title="제목을 4~100 글자 사이로 입력하셔야 합니다." required="required"> -->
					<br />
			</div>
			<div class="form-group">
				<label for="content">내용:</label><br />
				<textarea rows="5" cols="100" name="content" class="form-control"
					id="content" placeholder="내용입력" ></textarea>
<!-- 					required="required" -->
				<br />
			</div>
			<div class="form-group">
				<label for="title">작성자</label> <input type="text"
					class="form-control" id="writer" placeholder="작성자입력" name="writer" >
<!-- 					required="required" pattern="^.{2,10}$" title="작성자는 4~10글자 사이로 입력하셔야합니다."> -->
					<br />
			</div>
			<button class="btn btn-default">등록</button>
			<button type="reset" class="btn btn-default">다시 입력</button>
			<!-- 	버튼 기능만 사용하고 다른 동작은 하지 않도록 하는 타입 : button -->
			<!-- 	동작을 따로 정의하는데 onclick(클릭할 때 동작) / history.bak()<-이전페이지로이동 -->
			<button type="button" onclick="history.back()"
				class="btn btn-default">취소</button>


		</form>
	</div>
</body>
</html>