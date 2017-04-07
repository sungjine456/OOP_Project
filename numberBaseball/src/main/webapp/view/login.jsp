<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<title>로그인 페이지</title>
	</head>
	<body>
		<form:form id="form" name="playerDto" action="login.do" modelAttribute="playerDto" method="post">
			아이디 : <input type="text" id="id" name="id"/>
			<form:errors path="id" />
			<br>
			비밀번호 : <input type="password" id="password" name="password"/>
			<form:errors path="password" />
			<br>
			<input type="button" id="btn" value="로그인">
		</form:form>
	</body>
	<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/js/login.js"></script>
</html>