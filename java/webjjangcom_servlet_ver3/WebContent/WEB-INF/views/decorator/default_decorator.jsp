<!-- sitemesh 사용을 위한 설정 파일 -->
<!-- 작성자 : 이영환 -->
<!-- 작성일 : 2018-11-14 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- title을 개별 jsp에 있는 title로 적용한다. -->
<title>웹짱::<decorator:title /></title>

<!-- jQuery, BootStrap 웹 라이브러리를 등록 했으므로 url 적용되는 개별 jsp에 등록 금지 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- 구글아이콘 라이브러리 등록 : CSS -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
header, footer {
	background: AntiqueWhite;
}

pre {
	background: white;
	border: 0px;
}

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
	min-height: 200px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}

article {
	min-height: 460px;
}

#welcome {
	color: grey;
	margin: 0 auto;
}
</style>
<!-- <script type="text/javascript" src="../js/jquery.js"></script> -->
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
<!-- 개별 jsp의 head 태그안에 있는 css, js를 넣어준다. -->
<decorator:head/>
</head>
<body>
	<div class="container">
	<!-- 메뉴나 로고 등 -->
	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
			<!-- 회사로고 -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/main.do">Logo</a>
				</div>
				<!-- 모듈메뉴 -->
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="/notice/list.do">공지사항</a></li>
						<li><a href="/image/list.do">이미지</a></li>
						<li><a href="/board/list.do">일반게시판</a></li>
						<li><a href="/qna/list.do">질문답변</a></li>
						<!-- 회원관리는 관리자 권한으로 로그인하면 보인다. -->
						<c:if test="${!empty login }">
						<!-- 관리자 메뉴  -->
							<c:if test="${login.grade==9 }">
								<li><a href="/member/list.do">회원관리</a></li>
							</c:if>
						</c:if>
					</ul>
					<!-- 오른쪽에 위치하는 메뉴바 -->
					<ul class="nav navbar-nav navbar-right">
						<!-- 로그인을 안한 경우의 메뉴 -->
						<c:if test="${empty login }">
							<li><a href="/member/joinForm.do"><span
									class="glyphicon glyphicon-user"></span> 회원가입</a></li>
							<li><a href="/member/loginForm.do"><span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:if>
						<!-- 로그인은 한 경우의 메뉴 -->
						<c:if test="${!empty login }">
							<li id="welcome"><a href ="#">${login.name}[${login.gradeName }]</a></li>
							<li><a href="/member/view.do"> 내 정보 보기</a></li>
							<li><a href="/member/logout.do"><span
									class="glyphicon glyphicon-log-in"></span> Logout</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<article>
		<decorator:body />
	</article>
	<footer class="container-fluid text-center">
	<h2>웹짱커뮤니티</h2>
		<p>이 홈페이지의 저작권은 이영환에게 있습니다.</p>
	</footer>
	</div>

</body>
</html>