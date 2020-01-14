<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>존재하지 않는 URL</title>
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
<h2>오류페이지 입니다.</h2>
    <div class="panel panel-danger">
      <div class="panel-heading">요청하신 URL이 존재하지 않습니다.</div>
      <div class="panel-body">
      	<div id="logoDiv"><span class="glyphicon glyphicon-remove"></span></div>
      </div>
      <div class="panel-footer">
      	<a href="/board/list.do"><button>게시판으로 이동</button></a>
      </div>
    </div>

</div>
</body>
</html>