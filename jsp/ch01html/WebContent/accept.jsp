<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글번호: ${param.no }<br/>
관련글번호: ${param.refNo }<br/>
<!-- pre tag인 경우 입력된 데이터 그대로 보여주려고 할 때 사용  -->
답변 내용:<pre>${param.content }</pre><br/>
</body>
</html>