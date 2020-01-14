<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- bootstrap 라이브러리 등록 : CDN 방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(function() {
		$("#birth").datepicker();
		$("#birth").datepicker("option", "dateFormat", "yy-mm-dd");
		//이벤트 처리
	$("#id").on("keyup",function(){
		// 앞 뒤에 있는 공백문자를 제거한다.
		var id = $("#id").val().trim();
		$("#id").val(id);
		// id는 4~20자 글자
		//아이디가 비어있는 경우
		if(id.length == 0)
			$("#idCheck").html("아이디를 입력하세요.");
		// 4글자 미만, 20글자 초과인 경우 경고
		else if(id.length < 4 || id.length > 20)
			$("#idCheck").html("아이디는 4자이상 20자 이내로 작성해 주세요.");
		else
		//적당한 아이디를 입력한 경우 Ajax를 이용해서 서버에 아이디 확인을 한다.
			$("#idCheck").load("/ajax/idCheck.do?id="+id);
	}); // 아이디 중복체크의 끝
	
	// 데이터를 넘기기전 데이터 확인 처리
	$("#joinForm").on("submit",function(){
		if($("#idCheck").text().indexOf("사용 가능한") <= -1){
			alert("사용 가능한 아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}
	});
});
</script>
</head>
<body>
	<div class="container">

		<!-- header - > h1 : 첫번째 나오는 제목 / 자동줄바꿈 -->
		<h2>회원가입</h2>
		<form action="join.do" method="post" id="joinForm">
			<div class="form-group">
				<!-- 아이디 입력 - 4자이상 20자이내, 영문자와 숫자만 가능, 맨앞자리는 영문자 필수입력 -->
				<!-- maxlength : 최대입력 글자수, pattern : 입력글자의 형식,title : 마우스를 올려놨을 때 메세지, 또는 형식에 안맞을 때 경고메세지 -->
				<label for="id">아이디:</label> <input type="text" class="form-control"
					id="id" placeholder="아이디입력" name="id" maxlength="20"
					required="required" pattern="^[A-Za-Z][A-Za-z0-9]{3,19}$"
					title="4-20자 영숫자, 맨앞자는 영문자" autocomplete="off" />
				<div id="idCheck">아이디를 입력하셔야만 합니다.</div>
			</div>
			<div class="form-group">
				<!-- 비밀번호 입력 - 아무문자나 가능, 4자 20자 이내, 입력된 문자가 대체  필수입력 -->
				<label for="pw">비밀번호:</label> <input type="password"
					class="form-control" id="pw" placeholder="비밀번호입력" name="pw"
					maxlength="20" required="required" pattern="^.{4,20}$"
					title="4-20자 이내의 글자입력" />
			</div>
			<div class="form-group">
				<!-- 비밀번호 입력 - 아무문자나 가능, 4자 20자 이내, 입력된 문자가 대체 필수입력 -->
				<label for="pw2">비밀번호확인:</label> <input type="password"
					class="form-control" id="pw2" placeholder="비밀번호 확인 입력" name="pw2"
					maxlength="20" required="required" pattern="^.{4,20}$"
					title="4-20자 이내의 글자입력" />
			</div>
			<div class="form-group">
				<!-- 이름 입력  - 2자이상 10자이내, 한글만가능, 필수입력 -->
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name" placeholder="이름입력" name="name"
					maxlength="10" required="required" pattern="^[가-힣]{2,10}$"
					title="2자-10자 이내의 한글입력" />
			</div>
			<div class="form-group">
				<label for="gender">성별 :</label> <label class="radio-inline"><input
					type="radio" name="gender" checked value="남자">남자</label> <label
					class="radio-inline"><input type="radio" name="gender"
					value="여자">여자</label>
			</div>
			<div class="form-group">
				<!-- 생년월일 입력  - pattern : YYYY-MM-DD -->
				<label for="birth">생년월일:</label> <input type="text"
					class="form-control" id="birth" placeholder="생년월일 입력 -클릭"
					name="birth" maxlength="10" required="required"
					pattern="^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$" />
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<!-- 전화번호 입력  -->
					<label for="tel">핸드폰:</label>
				</div>
				<div class="col-md-2">
					<select class="form-control" id="tel1" name="tel">
						<option selected="selected">010</option>
						<option>011</option>
						<option>016</option>
						<option>017</option>
						<option>018</option>
						<option>019</option>
					</select>
				</div>
				<div class="col-md-2">
					<input type="number" class="form-control" id="tel2"
						placeholder="4자리숫자 입력" name="tel" maxlength="4"
						required="required" pattern="^[0-9]{3,4}$" title="숫자로 3~4자리 입력" />
				</div>
				<div class="col-md-2">
					<input type="number" class="form-control" id="tel3"
						placeholder="4자리숫자 입력" name="tel" maxlength="4"
						required="required" pattern="^[0-9]{3,4}$" title="숫자로 3~4자리 입력" />
				</div>
			</div>

			<div class="form-group">
				<!-- 이메일 입력  - type = "email" 작성하면 이메일 형식에 맞는지도 검사한다.-->
				<label for="email">이메일:</label> <input type="email"
					class="form-control" id="email" placeholder="이메일 입력 " name="email"
					maxlength="50" required="required"
					pattern="^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$"
					title="이메일형식 - ex) 012rlaehdgus@naver.com" /><br /> 이메일형식 - ex)
				012rlaehdgus@naver.com
			</div>
			<button type="submit" class="btn btn-default">회원가입</button>
		</form>
	</div>
</body>
</html>