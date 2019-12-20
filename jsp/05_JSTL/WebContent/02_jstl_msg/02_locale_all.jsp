<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page
import="java.text.DateFormat"
import="java.util.ArrayList"
import="java.util.Collections"
import="java.util.Locale"
 %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
Locale[] list = DateFormat.getAvailableLocales();
ArrayList<String> aryLocale = new ArrayList<String>();

for (int i = 0; i < list.length; i++) {			
	aryLocale.add(list[i].toString());		
}//for

Collections.sort(aryLocale);
Locale locale = null;	
String[] arrData = null; 

for (String data : aryLocale) {
	if (data.indexOf("_") > -1) {//index 값이 존재 하면 				
		arrData = data.split("_");//_ 문자로 구분하는 파싱을 합니다
		locale = new Locale(arrData[0], arrData[1]);//생성		
	} else {	
		locale = new Locale(data);//생성
	}//else	
	//출력
	out.println(locale.toString() + ","	
	+ locale.getDisplayLanguage() + ","	
	+ locale.getDisplayCountry()+"<br>");//+", "					
	//+ locale.getISO3Language()+"<br>"); //+ ","					
	//+ locale.getISO3Country());		
}//for 		
Locale localeTest = new Locale("en", "US");//생성	.. 미국
out.println(">>>" + localeTest.getDisplayName());//확인,영어,미국

%>