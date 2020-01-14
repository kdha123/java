<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정 폼</title>
<script type="text/javascript" src="/js/regExUtil.js"></script>

<style type="text/css">
.attachFile {
	display: none;
}
</style>

<script type="text/javascript">
	$(function() {
		// 첨부파일 변경 이벤트
		$("#changeImageBtn").click(function() {
			if ($(this).text() == "이미지 바꾸기")
				$(this).text("이미지 바꾸기 취소");
			else
				$(this).text("이미지 바꾸기");
			$(".attachFile").toggle();
		});

		// 데이터 전송 전 검사.
		$("#writeForm").submit(function() {
			// 데이터 유효성 검사.
			if (!inputDataCheck(title_RegEx, "#title", title_err_msg))
				return false;
			if (!inputDataCheck(content_RegEx, "#content", content_err_msg))
				return false;
			;
			if (!inputDataCheck(writer_RegEx, "#writer", writer_err_msg))
				return false;
		});
	});
</script>
</head>
<body>
	<h1>글수정 폼</h1>
	<!-- 많은 데이터를 넘길때 form -->
	<!-- url 작성시 *.do :  spring 3.1까지의 기본 url에 *.do pattern 기본으로 사용 -->
	<!-- 많은 데이터를 넘길때 form -->
	<form action="update.do" method="post" id="writeForm"
		enctype="multipart/form-data">
		<input type="hidden" name="page" value="${param.page }"> <input
			type="hidden" name="perPageNum" value="${param.perPageNum }">
		<input type="hidden" name="key" value="${param.key }"> <input
			type="hidden" name="word" value="${param.word }">
					<input type="hidden" name="deleteFile" value="${dto.fileName}">
			
		<div class="form-group">
			<label for="title">번호(수정불가)</label> <input type="text"
				class="form-control" id="no" name="no" value="${dto.no }"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="title">제목</label>
			<!-- 입력한 데이터의 앞뒤 공백문자는 제거(trim())
    			 id, class : 화면 컨트롤을 위해서(빠른 선택), name : 넘어가는 데이터 이름 -->
			<!-- 			<input type="text" class="form-control" id="title" name="title" -->
			<!-- 				required="required" pattern="^.{4,100}$" -->
			<!-- 				title="제목을 4~100 글자 사이로 입력하셔야 합니다."> -->
			<input type="text" class="form-control" id="title" name="title"
				title="제목을 4~100 글자 사이로 입력하셔야 합니다." value="${dto.title }">
		</div>
		<div>
			<img alt="" src="${dto.fileName }">
			<hr />
			<button id="changeImageBtn" type="button">이미지 바꾸기</button>
		</div>
		<div class="form-group attachFile">
			<label for="fileName">첨부파일</label> <input type="file"
				class="form-control" id="fileName" name="fileName">
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea class="form-control" rows="5" id="content" name="content">${dto.content }</textarea>
		</div>
		<!-- input, select, textarea : 입력 항목 만들기 : 생략 -->
		<button>수정</button>
		<button type="reset">다시입력</button>
		<button onclick="history.back()">취소</button>
	</form>
</body>
</html>