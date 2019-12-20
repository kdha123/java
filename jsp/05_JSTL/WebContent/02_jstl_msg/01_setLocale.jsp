<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--01_setLocale.jsp --%>

<%--
국제화 태그들이 사용할 로케일을 지정한다 
로케일이란 : 각 나라의 언어 표기를 설정 

로케일 지정 태그는 2가지가 있다

setLocale  : 국제화 태그들이 사용할 로케일을 지정한다 
requestEncoding : 요청 파라미터의 캐릭터 인코딩을 지정한다
request.setCharacterEncoding("utf-8");
--%>
<h2>setLocale</h2>
<h2>언어_나라</h2>
<h2>ko_kr</h2>
<h2>ko_KR.eucKR</h2>

default locale:<%=request.getLocale() %>

<pre>
디폴트 : 현재 컴퓨터에 국가별 설정에 되어있는 언어_나라가 된다.
제어판 >> 국가 및 언어가서 확인할 수 있다.
</pre>

<%--영문 로케일 --%>
<fmt:setLocale value="en"/>
<li>영문로케일:<%=response.getLocale() %>

<%--일어 로케일 --%>
<fmt:setLocale value="ja"/>
<li>일어 로케일:<%=response.getLocale()%>

<%--한국어 로케일 --%>
<fmt:setLocale value="ko"/>
<li>한국어 로케일:<%=response.getLocale()%>