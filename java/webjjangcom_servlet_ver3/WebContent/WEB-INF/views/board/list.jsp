<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tl" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동현이의 게시판 리스트</title>
<style type="text/css">
.dataRow:hover {
	background: #5CEEE6;
	cursor: pointer;
}
</style>
<!-- <script lang="javascript"> -->
<!-- <script> -->
<script type="text/javascript">
	//이벤트처리
	$(function() {
		// 하나의 글을 선택하면 (tr tag를 클릭)하면 글번호를 받아내서 글보기로 보낸다.
		$(".dataRow").click(function() {
			var no = $(this).find(".no").text();
			location = "view.do?no=" + no
					+ "&cnt=1"
					+ "&page=${pageObject.page}"
					+ "&perPageNum=${pageObject.perPageNum}"
					// el 객체에서 empty -> null || "" 체크 -> 데이터가 넘어오지 않았다.
					// el 객체에서 문자열 연결을 "+" 로 사용 불가능 => "+=" 로 사용한다.
				   ${(!empty pageObject.word)?   
						   " + \"&key=" += pageObject.key += "&word="
						   += pageObject.word += "\"":""};
		});

		// 페이지 네이션의 클릭 이벤트 처리
		$(".pagination > li:not('.active')").click(
				function() {
					// 		alert("페이지 이동 클릭");
					// .data("page") ==> 속성 중에서 data-page 라는 속성의 값을 가져온다.
					var page = $(this).data("page");
// 					alert(page + "-" + typeof page);

					location = "list.do?page=" + page
							+ "&perPageNum=${pageObject.perPageNum}"
							+ "&key=${pageObject.key}"
							+ "&word=${pageObject.word}";
					// a tag의 페이지 이동을 취소 시킨다.
					return false;
				});
		$("li.active").click(function() {
			return false;
		});
		
		// 한페이지에 나타날 글의 갯수 변경 이벤트 처리
		$("#perPageRow").on({
			"change":function(){
// 				alert("change");
				perPageNum = $("#perPageRow").val();
				location="list.do?page=1"
					+ "&perPageNum=" + perPageNum
					+ "&key=${pageObject.key}"
					+ "&word=${pageObject.word}";
			}
		});
	});
</script>

</head>
<body>
	<div class="container">
		<h1>게시판리스트</h1>
		<div id="searchDiv">
			<form action="list.do" class="form-inline">
				<input name="page" value="1" type="hidden" />
				<div class="form-group">
					<select class="form-control" id="key" name="key">
						<option value="t" ${(param.key == "t")?"selected":"" }>제목</option>
						<option value="c" ${(param.key == "c")?"selected":"" }>내용</option>
						<option value="w" ${(param.key == "w")?"selected":"" }>작성자</option>
						<option value="tc" ${(param.key == "tc")?"selected":"" }>제목/내용</option>
						<option value="tw" ${(param.key == "tw")?"selected":"" }>제목/작성자</option>
						<option value="cw" ${(param.key == "cw")?"selected":"" }>내용/작성자</option>
						<option value="tcw" ${(param.key == "tcw")?"selected":"" }>전체</option>
					</select>
				</div>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search"
						name="word" value="${param.word }" id="word">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
				<div class="input-group right">
						<span class="input-group-addon">Rows/Page</span>
					  <select class="form-control" id="perPageRow">
					    <option ${(pageObject.perPageNum == 10)?"selected='selected'":"" }>10</option>
					    <option ${(pageObject.perPageNum == 15)?"selected='selected'":"" }>15</option>
					    <option ${(pageObject.perPageNum == 20)?"selected='selected'":"" }>20</option>
					    <option ${(pageObject.perPageNum == 25)?"selected='selected'":"" }>25</option>
					  </select>
					</div>
			</form>
		</div>
		<table class="table table-bordered">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<!-- for each써서 데이터가 없을 때 까지 반복 위의 태그라이브러리에서 c라는 코어를 쓴다고 해야 쓸 수 있다  -->
			<c:forEach items="${list }" var="dto">
				<tr class="dataRow">
					<td class="no">${dto.no }</td>
					<td>${dto.title }</td>
					<td>${dto.writer }</td>
					<td>${dto.writeDate }</td>
					<td>${dto.hit }</td>
				</tr>
			</c:forEach>

			<!-- 페이지를 이동시키는 페이지네이션 -->
			<tr>
			<td colspan="5">
				<tl:pageNav  page="${pageObject.page }"
			 	startPage="${pageObject.startPage }" endPage="${pageObject.endPage }" 
			 	totalPage="${pageObject.totalPage }" />
				</td>
			</tr>


			<tr>
				<td colspan="5"><a href="writeForm.do"><button>글쓰기</button></a></td>
			</tr>
		</table>
	</div>
</body>
</html>