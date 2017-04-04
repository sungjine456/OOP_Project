<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>로그인 페이지</title>
	</head>
	<body>
		<form id="form" action="login.do" method="post">
			아이디 : <input type="text" id="id" name="id">
			비밀번호 : <input type="password" id="password" name="password">
		</form>
		<input type="button" id="btn" value="로그인">
	</body>
	<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/js/login.js"></script>
</html>