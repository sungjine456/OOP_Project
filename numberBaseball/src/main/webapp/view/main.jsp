<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int num = (Integer)request.getAttribute("num");
	int playerSize = 1;
	try {
		playerSize = (Integer)request.getAttribute("playerSize");
	} catch(NullPointerException e) {}
%>
<html>
	<head>
		<title>메인 페이지</title>
		<link rel="stylesheet" href="/css/common.css">
	</head>
	<body>
		<input type="hidden" id="countNum" value="1"/>
		<input type="hidden" id="maxNum" value="<%=num%>"/>
		<input type="hidden" id="count" value="1"/>
		<input type="hidden" id="playerNumber" value="0"/>
		<input type="hidden" id="playerSize" value=<%=playerSize%>/>
		<input type="hidden" id="turn" value="1"/>
		<div style="margin-right:10px; float:left">
			<div>
				<c:set var="playerSize" value="<%=playerSize%>"/>
				<c:if test="${playerSize ne 1}">
					<label id="labelCurrentPlayer">Player 1 님의 순서입니다 : </label>
				</c:if>
				<c:forEach var="i" begin="1" end="<%=num%>" step="1">
					<input type="text" class="answerInput" id="answer${i}" name="inputData" readonly="readonly"/>
				</c:forEach>
			</div>
		<c:forEach var="i" begin="1" end="<%=playerSize%>" step="1">
			<textarea rows="12" cols="50" id="area${i}" class="area" readonly="readonly">Player ${i} </textarea>
		</c:forEach>
		</div>
		<div>
			<div>
				<button type="button" id="numberBtn1" class="numberBtn" value="1">1</button>
				<button type="button" id="numberBtn2" class="numberBtn" value="2">2</button>
				<button type="button" id="numberBtn3" class="numberBtn" value="3">3</button>
			</div>
			<div>
				<button type="button" id="numberBtn4" class="numberBtn" value="4">4</button>
				<button type="button" id="numberBtn5" class="numberBtn" value="5">5</button>
				<button type="button" id="numberBtn6" class="numberBtn" value="6">6</button>
			</div>
			<div>
				<button type="button" id="numberBtn7" class="numberBtn" value="7">7</button>
				<button type="button" id="numberBtn8" class="numberBtn" value="8">8</button>
				<button type="button" id="numberBtn9" class="numberBtn" value="9">9</button>
			</div>
			<div>
				<button type="button" id="cancelBtn" value="cancel">취소</button>
				<button type="button" id="numberBtn0" class="numberBtn" value="0">0</button>
				<button type="button" id="inputBtn" value="input">입력</button>
			</div>
			<div>
				<button type="button" id="giveUpBtn">항복</button>	
			</div>
		</div>
		<form action="/finish.do" method="post" id="finishForm">
			<input type="hidden" name="num" value="<%=num%>"/>
		</form>
	</body>
	<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/js/main.js"></script>
</html>