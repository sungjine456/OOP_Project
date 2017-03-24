<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>게임 끝</title>
		<link rel="stylesheet" href="/css/common.css">
	</head>
	<body>
		<form id="form" method="post">
			<input type="hidden" name="num" value="<%=request.getAttribute("num")%>">
			<input type="hidden" name="playerSize" value="<%=request.getAttribute("playerSize")%>">
			<input type="hidden" name="playerNumber" value="0">
		</form>
		<div style="width: 125; height: 30; margin: auto;">
			<label> 숫자 야구 게임!! </label><br/><br/>
			<button type="button" class="btn" id="firstPage">처음으로</button><br/><br/>
			<button type="button" class="btn" id="changeNumber" value="chooseNumber.do">숫자 크기 바꿔서 해보기</button><br/><br/>
<%
	if((boolean)request.getAttribute("isNotMadeNum")){
%>
			<button type="button" class="btn" id="reStart" value="start.do">다시하기</button><br/><br/>
<%
	} else {
%>
			<button type="button" class="btn" id="reStartAndMakeNumber" value="makeNumber.do">숫자 다시정하기</button><br/><br/>
<%
	}
%>
		</div>
	</body>
	<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/js/finish.js"></script>
</html>