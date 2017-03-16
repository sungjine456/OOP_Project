<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>성공!!!</title>
		<link rel="stylesheet" href="/css/common.css">
	</head>
	<body>
		<form id="startForm" action="start.do" method="post">
			<input type="hidden" name="num" value="<%=request.getAttribute("num")%>">
			<input type="hidden" name="playerSize" value="<%=request.getAttribute("playerSize")%>">
		</form>
		<form id="chooseNumberForm" action="chooseNumber.do" method="post">
			<input type="hidden" name="num" value="<%=request.getAttribute("num")%>">
		</form>
		<div style="width: 125; height: 30; margin: auto;">
			<label> 숫자 야구 게임!! </label><br/><br/>
			<button type="button" class="btn" id="firstPage">처음으로</button><br/><br/>
			<button type="button" class="btn" id="changeNumber">숫자 크기 바꿔서 해보기</button><br/><br/>
<%
	if((boolean)request.getAttribute("isNotMadeNum")){
%>
			<button type="button" class="btn" id="reStart">다시하기</button><br/><br/>
<%
	}
%>
		</div>
	</body>
	<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/js/finish.js"></script>
</html>