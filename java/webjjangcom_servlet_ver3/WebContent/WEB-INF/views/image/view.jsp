<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 게시판 보기</title>

<script type="text/javascript">
$(function(){
	// 버튼 이벤트 처리
	$("#deleteBtn").click(function(){
		if(!confirm("정말 삭제하시겠습니까?"))
			return false; // a tag의 href를 취소 시킨다. -> location.href를 변경하는 태그 a
		
	});
});
</script>

</head>
<body>
<h1>이미지 게시판 보기</h1>
<table class="table">
<tr>
	<th>글번호</th><td>${dto.no}</td>
</tr>
<tr>
	<th>제목</th><td>${dto.title}</td>
</tr>
<tr>
	<th>이미지</th><td><img alt="" src="${dto.fileName }"></td>
</tr>
<tr>
	<th>내용</th><td><pre>${dto.content}</pre></td>
</tr>
<tr>
	<th>작성자</th><td>${dto.id }</td>
</tr>
<tr>
	<td colspan="2">
		<a href="updateForm.do?no=${dto.no }&page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}"><button>수정</button></a>
		<a href="delete.do?no=${dto.no }&perPageNum=${param.perPageNum }&deleteFile=${dto.fileName}"
		 id="deleteBtn"><button>삭제</button></a>
		<a href="list.do?page=${param.page }&perPageNum=${param.perPageNum }&key=${param.key }&word=${param.word}"><button>목록</button></a>
	</td>
</tr>
</table>

</body>
</html>