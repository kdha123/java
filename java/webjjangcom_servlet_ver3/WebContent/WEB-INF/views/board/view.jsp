<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 보기</title>
<style type="text/css">

</style>
<script type="text/javascript">
	$(function() {
		// 버튼 이벤트 처리
		$("#deleteBtn").click(function() {
			if (!confirm("정말 삭제하시겠습니까?"))
				return false; //a tag의 href를 취소 시킨다.--> location.href를 변경하는 태그 a
		});
		
		$("#writeBtn").click(function(){
			//모달창 제목 셋팅
			$(".modal-header > h4").html("<span class='glyphicon glyphicon-pencil'></span> 댓글쓰기");
			
			//값을 비운다.
			$("#modal_content").val("");
			$("#modal_writer").val("");
			
			// 전송 버튼의 글자 셋팅
			$("#updateModal_updateBtn").text("등록");

			// 작성자 수정 가능르로 만든다.
			$("#modal_writer").attr("disabled", false);
			
			// 받는 url을 정한다.
			$("#modal_form").attr("action", "replyWrite.do")
			
			$("#updateModal").modal();
		});
		
		
		$(".updateBtns").click(function(){
			//데이터 수집
			var row = $(this).closest(".dataRow");
			var rno = row.data("rno");
			var content = row.find(".content").text();
			var writer = row.find(".writer").text();
			
			// 모달창 제목 셋팅
			$(".modal-header > h4").html("<span class='glyphicon glyphicon-pencil'></span> 댓글 수정");
			
			// 전송 버튼의 글자 셋팅
			$("#updateModal_updateBtn").text("수정");
			
			// 모달창에 셋팅
			$("#modal_rno").val(rno);
			$("#modal_content").val(content);
			$("#updateModal").modal();
			
			// 작성자 수정 불가로 만든다.
			$("#modal_writer").attr("disabled", true);
			
			// 받는 url을 정한다.
			$("#modal_form").attr("action", "replyUpdate.do")
			
			$("#updateModal").modal();
		});
		
		$(".deleteBtns").click(function(){
			var row = $(this).closest(".dataRow");
			var rno = row.data("rno");
			var content = row.find(".content").text();
			$("#delete_modal_content").text(content);
			$("#delete_modal_rno").val(rno);
			$("#deleteModal").modal();
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
					<h3 style="border-bottom: 1px solid #ccc">댓글</h3>
					<div style="padding-bottom: 5px;">
						<button id="writeBtn">
					 <span class="glyphicon glyphicon-pencil"></span>
					  댓글 등록
						</button>
					</div>
						<!--  댓글 리스트 -->
					<div id="replyList">
						<c:if test="${empty replyList }">댓글이 존재하지 않습니다.</c:if>
						<c:if test="${!empty replyList }">
							<ul class="list-group">
								<c:forEach var="dto" items="${replyList }">
									<li class="list-group-item dataRow" data-rno="${dto.rno }">
									<b>${dto.writer }(${dto.writeDate })</b><br>
										<span class="content">${dto.content }</span> 
										<span class="badge btn-group" style="background: white">
											<button type="button" class="btn btn-primary updateBtns">수정</button>
											<button type="button" class="btn btn-warning deleteBtns">삭제</button>
									</span>
										</li>
								</c:forEach>
							</ul>
						</c:if>
					</div>
				</td>
			</tr>

		</table>
	</div>
	  <!-- Modal -->
  <div class="modal fade" id="updateModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-pencil"></span> 댓글 수정</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form" method="post" id="modal_form">
			<input type="hidden" name="no" value="${dto.no }">
		<input	type="hidden" name="page" value="${param.page }">
		 <input	type="hidden" name="perPageNum" value="${param.perPageNum }">
          <input type="hidden" name="rno" id="modal_rno">
            <div class="form-group">
            <label for="modal_content">
             <span class="glyphicon glyphicon-calendar"></span>
             	내용
            </label>
              <textarea class="form-control" id="modal_content" name="content" rows="3"></textarea>
            </div>
             <div class="form-group">
              <label for="modal_content">
                <span class="glyphicon glyphicon-user"></span>
               	작성자
              </label>
              <input class="form-control" id="modal_writer" name="writer">
            </div>
         	  <div class="btn-group right">
             <button type="submit" class="btn btn-primary"
              id="updateModal_updateBtn">수정</button>
          	 <button type="button" class="btn btn-warning" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> 취소</button>
			</div> 
          </form>
        </div>
      </div>
    </div>
  </div> 
  
  <!-- 댓글 삭제를 위한 Modal -->
  <div class="modal fade" id="deleteModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-remove"></span> 댓글 삭제</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
	        <div class="alert alert-warning">
			  <strong>주의</strong> 아래 댓글의 정말로 삭제하시겠습니까?
			</div>
			<div id="delete_modal_content">
				댓글 내용
			</div>
		</div>
        <div class="modal-footer" style="padding:40px 50px;">
          <form role="form" method="post" id="modal_delete_form" action="replyDelete.do">
          	<input type="hidden" name="rno" id="delete_modal_rno">
            <input name="no" type="hidden" value="${dto.no }" />
			<input name="page" type="hidden" value="${param.page }" />
			<input name="perPageNum" type="hidden" value="${param.perPageNum }" />
            <div class="btn-group">
             <button type="submit" class="btn btn-primary">삭제</button>
          	 <button type="button" class="btn btn-warning" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> 취소</button>
			</div> 
          </form>
        </div>
      
    </div>
  </div> 
</div>
  
	
</body>
</html>