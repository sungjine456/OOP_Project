<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>성공!!!</title>
		<link rel="stylesheet" href="/css/common.css">
	</head>
	<body>
		<form action="chooseNumber.do" method="get" id="form">
			<input type="hidden" id="nextUrl" name="nextUrl"/>
			<div style="width: 125; height: 30; margin: auto;">
				<label> 숫자 야구 게임!! </label><br/><br/>
				<button type="button" class="indexBtn" value="oneStart">처음으로</button><br/><br/>
				<button type="button" class="indexBtn" value="twoStart">숫자 크기 바꿔서 해보기</button><br/><br/>
				<button type="button" class="indexBtn" value="manyStart">다시하기</button><br/><br/>
			</div>
		</form>
	</body>
	<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/js/main.js"></script>
</html>