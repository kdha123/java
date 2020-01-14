<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ attribute name="page" required="true" type="java.lang.Integer"%>
<%@ attribute name="startPage" required="true" type="java.lang.Integer"%>
<%@ attribute name="endPage" required="true" type="java.lang.Integer"%>
<%@ attribute name="totalPage" required="true" type="java.lang.Integer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="pagination">
	<li data-page=1>
	<a href="#">&lt;&lt;</a>
	</li>
	<c:if test="${startPage > 1 }">
		<li data-page=${startPage -1 }>
		<a href="#">&lt;</a></li>
	</c:if>
	<c:forEach begin="${startPage }"
		end="${endPage }" var="cnt">
		<li ${(page == cnt)?"class=\"active\"":"" }
			data-page=${cnt }>
			<a href="#">${cnt}</a>
			</li>
	</c:forEach>
	<c:if test="${endPage < totalPage }">
		<li data-page=${endPage + 1 }>
		<a href="#">&gt;</a>
		</li>
	</c:if>
	<li data-page=${totalPage }>
	<a href="#">&gt;&gt;</a>
	</li>
</ul>

