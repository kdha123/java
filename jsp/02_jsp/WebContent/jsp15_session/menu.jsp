<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--menu.jsp --%>

<h2>구매CD를 고르세요</h2>

<form method="post">
 <select name="item">
  <option value="백아연CD" selected>백아연CD</option>
  <option value="백예린CD">백예린CD</option>
  <option value="정승환CD">정승환CD</option>
  <option value="레드벨벳CD">레드벨벳CD</option>
  <option value="양다일CD">양다일CD</option>
  <option value="크러쉬CD">크러쉬CD</option>
 
 </select>
 
 <input type="hidden" name="step" value="add">
 <input type="submit" value="선택">
</form>
    