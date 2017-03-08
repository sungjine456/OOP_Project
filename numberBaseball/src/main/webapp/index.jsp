<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>시작 페이지</title>
		<link rel="stylesheet" href="/css/common.css">
	</head>
	<body>
		<form action="chooseNumber.do" method="post" id="chooseNumberForm">
			<input type="hidden" id="nextUrl" name="nextUrl"/>
		</form>
		<form action="choosePlayerSize.do" method="post" id="choosePlayerSizeForm">
			<input type="hidden" id="nextUrl" name="nextUrl" value="manyStart"/>
		</form>
		<div style="width: 125; height: 30; margin: auto;">
			<label> 숫자 야구 게임!! </label><br/><br/>
			<button type="button" id="oneStart" class="btn" value="oneStart">1. 1인 용</button><br/><br/>
			<button type="button" id="twoStart" class="btn" value="twoStart">2. 2인 용</button><br/><br/>
			<button type="button" id="manyStart" class="btn">3. 다인 용</button><br/><br/>
		</div>
	</body>
	<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/js/index.js"></script>
</html>