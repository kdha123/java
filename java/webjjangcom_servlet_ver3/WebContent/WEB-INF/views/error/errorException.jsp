<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <%--Exception 객체를 받아오기위해서 isErrorPage="true"를 쓴다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서버오류</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
#logoDiv{
	font-size: 50px;
	padding: 50px;
	text-align: center;
	background: black;
	color: white;
}

</style>
</head>
<body>
<div class="container">
<h2>서버오류</h2>
    <div class="panel panel-danger">
      <div class="panel-heading"><%=exception.getMessage()%></div>
      <div class="panel-body">
      	<div id="logoDiv"><span class="glyphicon glyphicon-remove"></span></div>
      </div>
      <div>
      	요청하신 페이지를 처리하는 중 서버에 오류가 발생되었습니다.<br>
      	다시 한번 시도해 주세요<br>
      	지속적으로 오류가 발생이 되면 전산담당자(김동현: 012rlaehdgus@naver.com)로 연락주세요.<br>
      </div>
      <div class="panel-footer">
      	<a href="/board/list.do"><button>게시판으로 이동</button></a>
      </div>
    </div>

</div>
</body>
</html>