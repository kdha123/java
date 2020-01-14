<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문하기</title>

</head>
<body>
	<div class="container">
		<h2>질문하기</h2>
		<!-- 많은 데이터를 넘길 때는 form action -->
		<form action="write.jsp" method="post">
			<div class="form-group">
				<!-- 제목 입력 : 한줄 - 키보드입력 -->
				<label for="title">제목 :</label> 
				<!-- id: 한개 태그 - 화면단 컨트롤하기 위해서 붙인다./ name:넘어가는 데이터 키에 해당된다. -->
				<input type="text" class="form-control" id="title" placeholder="제목입력" name="title"
					maxlength="300" required="required"><br />
			</div>
			<div class="form-group">
				<!-- 내용 입력 : 여러줄 - 키보드입력 -->
				<label for="content">내용:</label><br />
				<textarea rows="5" name="content" class="form-control"
					id="content" placeholder="내용입력" maxlength="2000"
					required="required"></textarea>
				<br />
			</div>
			<!-- button tag의 기본 type은 submit이다. 그래서  생략가능 -->
			<button type="submit" class="btn btn-default">등록</button>
			<button type="reset" class="btn btn-default">다시 입력</button>
			<!-- 	버튼 기능만 사용하고 다른 동작은 하지 않도록 하는 타입 : button -->
			<!-- 	동작을 따로 정의하는데 onclick(클릭할 때 동작) / history.bak()<-이전페이지로이동 -->
			<button type="button" onclick="history.back();"
				class="btn btn-default">취소</button>
		</form>
	</div>
</body>
</html>