<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.gradle.common.NumberSize" %>
<html>
	<head>
		<title>숫자 선택</title>
		<link rel="stylesheet" href="/css/common.css">
	</head>
	<body>
		<form id="startForm" action="start.do" method="post">
			<input type="hidden" name="num"/>
			<input type="hidden" name="playerSize" value="<%=request.getAttribute("playerSize")%>"/>
		</form>
		<form id="makeNumberForm" action="makeNumber.do" method="post">
			<input type="hidden" name="num"/>
			<input type="hidden" name="playerNumber" value="0"/>
			<input type="hidden" id="playerSize" name="playerSize" value="<%=request.getAttribute("playerSize")%>"/>
		</form>
		<div style="width: 1250; height: 30; margin: auto; text-align: center">
			<h1>수의 크기를 정해주세요</h1>
			<c:forEach var="i" begin="<%=NumberSize.MIN_NUMBER_SIZE.getSize()%>" end="<%=NumberSize.MAX_NUMBER_SIZE.getSize()%>" step="1">
				<button type="button" class="numberBtn" value="${i}"> ${i} </button>
			</c:forEach>
		</div>
	</body>
	<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/js/chooseNumber.js"></script>
</html>