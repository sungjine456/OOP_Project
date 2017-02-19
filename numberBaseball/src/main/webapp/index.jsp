<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>시작 페이지</title>
		<link rel="stylesheet" href="/css/common.css">
	</head>
	<body>
		<form method="get" id="form">
			<div style="width: 125; height: 30; margin: auto;">
				<label> 숫자 야구 게임!! </label></br></br>
				<button type="button" class="indexBtn" id="oneStart">1. 1인 용</button></br></br>
				<button type="button" class="indexBtn" id="twoStart">2. 2인 용</button></br></br>
				<button type="button" class="indexBtn" id="manyStart">3. 다인 용</button></br></br>
				<button type="button" class="indexBtn" id="finish">4. 게임 종료</button>
			</div>
		</form>
	</body>
	<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/js/index.js"></script>
</html>