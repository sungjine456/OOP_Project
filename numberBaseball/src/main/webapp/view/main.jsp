<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>메인 페이지</title>
		<link rel="stylesheet" href="/css/common.css">
	</head>
	<body>
		<textarea rows="12" cols="50" id="area" style="margin-right:10px; float:left"></textarea>
		<div>
			<div>
				<button type="button" class="numberBtn" value="1">1</button>
				<button type="button" class="numberBtn" value="2">2</button>
				<button type="button" class="numberBtn" value="3">3</button>
			</div>
			<div>
				<button type="button" class="numberBtn" value="4">4</button>
				<button type="button" class="numberBtn" value="5">5</button>
				<button type="button" class="numberBtn" value="6">6</button>
			</div>
			<div>
				<button type="button" class="numberBtn" value="7">7</button>
				<button type="button" class="numberBtn" value="8">8</button>
				<button type="button" class="numberBtn" value="9">9</button>
			</div>
			<div>
				<button type="button" id="cancelBtn" value="cancel">취소</button>
				<button type="button" class="numberBtn" value="0">0</button>
				<button type="button" id="inputBtn" value="input">입력</button>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/js/main.js"></script>
</html>