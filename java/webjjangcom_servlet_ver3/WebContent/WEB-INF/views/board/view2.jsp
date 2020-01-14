<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 보기</title>
<style type="text/css">
.updateDiv {
	display: none;
}
</style>
<script type="text/javascript">
	$(function() {
		// 버튼 이벤트 처리
		$("#deleteBtn").click(function() {
			if (!confirm("정말 삭제하시겠습니까?"))
				return false; //a tag의 href를 취소 시킨다.--> location.href를 변경하는 태그 a
		});
		
		$(".updateBtns").click(function(){
			$(".updateDiv").hide();
			$(this).parent().next().show();
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h1>게시판 글 보기</h1>
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
				<th>작성자</th>
				<td>${dto.writer}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${dto.hit}</td>
			</tr>
			<tr>
				<td colspan="2"><a
					href="updateForm.do?no=${dto.no }&page=${param.page }&perPageNum=${param.perPageNum }&key=${param.key }&word=${param.word}"><button>수정</button></a>
					<a href="delete.do?no=${dto.no }"><button id="deleteBtn">삭제</button></a>
					<a
					href="list.do?page=${param.page }&perPageNum=${param.perPageNum }&key=${param.key }&word=${param.word}"><button>목록</button></a>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<h3>댓글</h3>
					<hr />
					<div>
						<!-- 댓글 쓰기 폼 -->
						<form method="post" action="replyWrite.do">
							<input type="hidden" name="no" value="${dto.no }">
							 <input	type="hidden" name="page" value="${param.page }"> <input
								type="hidden" name="perPageNum" value="${param.perPageNum }">
							<div class="form-group">
								<label for="content">내용:</label>
								<textarea class="form-control" rows="3" id="content"
									name="content"></textarea>
							</div>
							<div class="form-group">
								<label for="writer">작성자:</label> <input type="text"
									class="form-control" id="writer" name="writer">
							</div>
							<button>댓글달기</button>
						</form>
					</div>
					<div id="replyList">
						<!--  댓글 리스트 -->
						<c:if test="${empty replyList }">댓글이 존재하지 않습니다.</c:if>
						<c:if test="${!empty replyList }">
							<ul class="list-group">
								<c:forEach var="dto" items="${replyList }">
									<li class="list-group-item" data-rno="${dto.rno }"><b>${dto.writer }(${dto.writeDate })</b><br>
										${dto.content } <span class="badge btn-group"
										style="background: white">
											<button type="button" class="btn btn-primary updateBtns">수정</button>
											<button type="button" class="btn btn-warning">삭제</button>
									</span>
										<div class="updateDiv">
											<form method="post" action="replyUpdate.do">
												<input type="hidden" name="rno" value="${dto.rno }">
												<input type="hidden" name="writer" value="${dto.writer }">
												<div class="form-group">
													<textarea class="form-control" rows="3" id="content"
														name="content">${dto.content}</textarea>
												</div>
												<button>수정</button>


											</form>
										</div></li>
								</c:forEach>
							</ul>
						</c:if>
					</div>
				</td>
			</tr>

		</table>
	</div>
</body>
</html>