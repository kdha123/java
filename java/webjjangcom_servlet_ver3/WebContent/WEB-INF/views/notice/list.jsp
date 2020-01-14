<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tl" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트</title>

<script type="text/javascript">
	//이벤트처리
	$(function() {
		// 하나의 글을 선택하면 (tr tag를 클릭)하면 글번호를 받아내서 글보기로 보낸다.
		$(".dataRow").click(function() {
			// 			alert("dataRow click");
			// text() -> getter, text(100) - setter
			var no = $(this).find(".no").text();
			// 			alert(no);
			location = "view.do?no=" + no + "&cnt=1";
		});
		// 페이지네이션의 클릭 이벤트 처리
		$(".pagination > li:not('.active')").click(function(){
// 			alert("페이지이동 클릭")
			var page = $(this).data("page");
			//.data("page") ==> 속성 중에서 data-page 라는 속성의 값을 가져온다.
// 			alert(page + "-" + typeof page);
			
			location = "list.do?page="+ page + "&perPageNum=${pageObject.perPageNum}";
		// a tag의 페이지 이동을 취소시킨다.
			return false;
		});
		$("li.active").click(function(){
			return false;
		});
	});
</script>

<style type="text/css">
.dataRow:hover {
	background: #5CEEE6;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container">
		<h1>공지사항리스트</h1>
		<table class="table table-bordered">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>공지시작일</th>
				<th>공지종료일</th>
				<th>최종수정일</th>
			</tr>
			<!-- for each써서 데이터가 없을 때 까지 반복 위의 태그라이브러리에서 c라는 코어를 쓴다고 해야 쓸 수 있다  -->
			<c:forEach items="${list }" var="dto">
				<tr class="dataRow">
					<td class="no">${dto.no }</td>
					<td>${dto.title }</td>
					<td>${dto.writeDate }</td>
					<td>${dto.startDate }</td>
					<td>${dto.endDate }</td>
					<td>${dto.updateDate }</td>
				</tr>
			</c:forEach>
			<!-- 페이지를 이동시키는 페이지네이션 -->
			<tr>
				<td colspan="6">
				<tl:pageNav  page="${pageObject.page }"
			 	startPage="${pageObject.startPage }" endPage="${pageObject.endPage }" 
			 	totalPage="${pageObject.totalPage }" />
				</td>
			</tr>
			<tr>
				<td colspan="6"><a href="writeForm.do"><button>공지등록</button></a></td>
			</tr>
		</table>
	</div>
</body>
</html>