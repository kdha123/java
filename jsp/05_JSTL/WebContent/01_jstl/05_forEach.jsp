<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--05_forEach.jsp --%>
<%--
forEach 태그는 배열이나 collection, Map에 저장된 값들을 순차적으로 처리할 때 사용한다.

java의 for문, while, do~while문과 유사하다

forEach 태그 형식

<c:forEach var="변수" items="아이템">
 	처리내용
 	변수 내용 출력
</c:forEach>

설명
items 속성에 올 수 있는 것들 : Map, 배열, Collection 등등 이 있다.
배열일 경우 기본 데이터는 wrapper클래스(Integer,Double,...)를 사용하여 처리하게 됩니다.

 --%>
    