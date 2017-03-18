<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int playerNumber = (Integer)request.getAttribute("playerNumber") + 1;
	String message = (String)request.getAttribute("message");
	if(message != null){
%>
		<script>
			alert("<%=message%>");
		</script>
<%
	}
%>
<html>
	<head>
		<title>숫자 생성 페이지</title>
		<link rel="stylesheet" href="/css/common.css">
	</head>
	<body>
		<div>
			Player <%=playerNumber%> 님이 맞출 숫자를 정해주세요. (예 -> 123)
		</div>
		<div>
			<form id="form" action="makeNumber.do" method="post" onsubmit="return false;" style="float:left">
				<input type="hidden" id="num" name="num" value="<%=request.getAttribute("num")%>"/>
				<input type="hidden" name="playerNumber" value="<%=playerNumber%>"/>
				<input type="hidden" name="playerSize" value="<%=request.getAttribute("playerSize")%>"/>
				<input type="text" id="makeNum" name="makeNumber"/>
			</form>
			<button type="button" id="insertBtn">입력</button>
		</div>
	</body>
	<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/js/makeNumber.js"></script>
</html>