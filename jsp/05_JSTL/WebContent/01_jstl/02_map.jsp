<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--02_map.jsp --%>
<h1>Map 사용 이전 방식</h1>
<%
Map<String, String> map1 = new HashMap<String,String>();
map1.put("name","이효리");
map1.put("addr","제주도 제주시");
map1.put("tel","010-1111-1111");

%>
이름:<%=map1.get("name") %><br>
주소:<%=map1.get("addr") %><br>
전화:<%=map1.get("tel") %><br>

<h1>EL,JSTL,Map,HashMap 사용</h1>
<c:set var="map" value="<%= new HashMap<String,String>() %>" scope="page"/>

<c:set target="${map }" property="name" value="아이린"/>
<c:set target="${map }" property="addr" value="경기도 부천시"/>
<c:set target="${map }" property="tel" value="010-1111-1111"/>
<br>

<%-- 출력 --%>
이름 :${map.name}<br>
주소 :${map.addr}<br>
전화 :${map.tel}<br>
<%--
dto 모델빈과 map은 같은 방법으로 사용
 --%>
