<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문답변 글 보기</title>
<!-- Bootstrap 라이브러리 -->
</head>
<body>
	<div class="container">
		<h1>질문답변 글 보기</h1>
		<table class="table">
			<tr>
				<th>글번호</th>
				<td>${dto.no}</td>
			</tr>
			<tr>
				<th>글제목</th>
				<td>${dto.title}</td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><pre>${dto.content}</pre></td>
			</tr>
			<tr>
				<th>이름[아이디]</th>
				<td>${dto.name}[${dto.id }]</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${dto.hit}</td>
			</tr>
			<tr>
				<td colspan="2">
				<a href="updateForm.do?no=${dto.no }"><button>수정</button></a> 
				<a href="answerForm.do"><button>답변하기</button></a>
				<a href="delete.do?no=${dto.no }"><button>삭제</button></a>
				<a href="list.do"><button>목록</button></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>