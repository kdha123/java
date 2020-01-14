<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>질문답변 리스트</title>

<style type="text/css">
.dataRow:hover {
	background: #5CEEE6;
	cursor: pointer;
}
</style>
<script type="text/javascript">
	$(function() {
		// 	alert("start");
		//이벤트처리
		$(".dataRow").click(function() {
// 			alert("dataRow click");
			// text() -> getter, text(100) - setter
			no = $(this).find(".no").text();
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
</head>
<body>
	<div class="container">
		<h1>질문답변리스트</h1>
		<table class="table table-bordered">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자[ID]</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<!-- for each써서 데이터가 없을 때 까지 반복 위의 태그라이브러리에서 c라는 코어를 쓴다고 해야 쓸 수 있다  -->
			<c:forEach items="${list }" var="dto">
				<tr class="dataRow">
					<td class="no">${dto.no }</td>
					<td><c:forEach begin="1" end="${dto.levNo * 5 }">&nbsp;</c:forEach>
						<i class="material-icons">${(dto.levNo > 0)?"&#xe5da;":"" }</i>${dto.title }</td>
					<td>${dto.name }[${dto.id }]</td>
					<td>${dto.writeDate }</td>
					<td>${dto.hit }</td>
				</tr>
			</c:forEach>
			<!-- 페이지를 이동시키는 페이지네이션 -->
			<tr>
				<td colspan="5">
					<ul class="pagination">
						<li data-page=1><a href="#">&lt;&lt;</a></li>
						<c:if test="${pageObject.startPage > 1 }">
							<li data-page=${pageObject.startPage - 1}><a href="#">&lt;</a>
							</li>
						</c:if>
						<c:forEach begin="${pageObject.startPage }"
							end="${pageObject.endPage }" var="cnt">
							<li ${(pageObject.page == cnt)?"class=\"active\"":"" }
								data-page=${cnt }><a href="#">${cnt}</a></li>
						</c:forEach>
						<c:if test="${pageObject.endPage < pageObject.totalPage }">
							<li data-page=${pageObject.endPage + 1 }><a href="#">&gt;</a>
							</li>
						</c:if>
						<li data-page=${pageObject.totalPage }><a href="#">&gt;&gt;</a>
						</li>


					</ul>
				</td>
			</tr>
			<tr>
				<td colspan="5"><a href="writeForm.do"><button>질문하기</button></a></td>
			</tr>
		</table>
	</div>
</body>
</html>