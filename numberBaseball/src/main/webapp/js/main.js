var main = {
	body : $("body"),
	labelCurrentPlayer : $("#labelCurrentPlayer"),
	numberBtn : $(".numberBtn"),
	inputBtn : $("#inputBtn"),
	cancelBtn : $("#cancelBtn"),
	giveUpBtn : $("#giveUpBtn"),
	countNum : $("#countNum"),
	maxNum : $("#maxNum"),
	playerNumber : $("#playerNumber"),
	playerSize : $("#playerSize"),
	turn : $("#turn"),
	finishForm : $("#finishForm"),
	inputData : $("input[name='inputData']"),
	count : $("#count"),
	numberBtnClickEvent : function(event){
		var target = $(event.target);
		var value = parseInt(target.val());
		
		this.numberClickEvent(value);
	},
	numberClickEvent : function(value){
		var numberButton = $("#numberBtn"+value);
		if(numberButton.attr("disabled")){
			return;
		}
		var num = parseInt(this.numCheck(this.countNum.val()));
		var answer = $("#answer"+num);
		
		if(num == 1 && value == 0){
			alert("첫 숫자는 0이 될 수 없습니다.");
			return;
		}
		if(num === parseInt(this.maxNum.val()) && answer.val() !== ""){
			this.enabledFunction(answer.val());
		}
		numberButton.attr("class", "numberBtn checkBtn");
		numberButton.attr("disabled", true);
		answer.val(value);
		this.countNum.val(parseInt(num)+1);
	},
	cancelBtnClickEvent : function(){
		var num = this.countNum.val();
		var answer = $("#answer"+(this.numCheck((parseInt(num)-1))));
		this.enabledFunction(answer.val());
		answer.val("");
		this.countNum.val(parseInt(num)-1);
	},
	enabledFunction : function(value){
		if(parseInt(value) === 0){
			value = 11;
		}
		var numberClass = $("button:eq("+(value-1)+")");
		numberClass.attr("class", "numberBtn");
		numberClass.removeAttr("disabled");
	},
	inputEvent : function(){
		var self = this;
		var playerNumberVal = this.playerNumber.val();
		var countValue = this.count.val();
		var max = this.maxNum.val();
		var myTurn = this.turn.val();
		var area = $("#area"+myTurn);
		var arr = "";
		var inputNubmerCount = 0;
		this.inputData.each(function(idx){
			var value = $(this).val();
			if(value){
				inputNubmerCount = parseInt(inputNubmerCount) + 1;
			}
			arr += value + " ";
		});
		if(inputNubmerCount !== parseInt(max)){
			alert("숫자를 모두 입력해 주세요.");
			return;
		}
		if(parseInt(myTurn) === parseInt(this.playerSize.val())){
			this.count.val(parseInt(countValue)+1);
		}
		$.ajax({
			url : "/inputNum.do",
			type : "post",
			data : {"input" : arr, "playerNumber" : playerNumberVal},
			success : function(data){
				if(data.isGiveUpPlayer!=="true"){
					if(data.confirm == "성공!!!"){
						if(parseInt(self.playerSize.val()) === 1){
							alert("정답입니다 !!");
						} else {
							alert("Player " + myTurn + "님이 맞추셨습니다!!");
						}
						finishForm.submit();
					} else {
						area.val(area.val() + "\n" + countValue + "번 : " + arr + " -> " + data.confirm);
						self.clearEvent();
						self.turn.val(data.nextPlayer);
						self.playerNumber.val(parseInt(data.nextPlayer)-1);
						if(parseInt(self.playerSize.val()) !== 1){
							self.labelCurrentPlayerEvent();
						}
					}
				} else {
					alert("항복한 Player 입니다. 다시입력해주세요.");
					self.clearEvent();
					self.turn.val(data.nextPlayer);
					self.playerNumber.val(parseInt(data.nextPlayer)-1);
					if(parseInt(self.playerSize.val()) !== 1){
						self.labelCurrentPlayerEvent();
					}
				}
			}
		});
	},
	labelCurrentPlayerEvent : function(){
		this.labelCurrentPlayer.html("Player " + this.turn.val() + " 님의 순서입니다 : ");
	},
	nextTurn : function(myTurn){
		myTurn = parseInt(myTurn) + 1;
		if(myTurn > parseInt(this.playerSize.val())){
			myTurn = 1;
		}
		this.turn.val(myTurn);
		this.playerNumber.val(parseInt(myTurn)-1);
	},
	clearEvent : function(){
		var self = this;
		self.inputData.each(function(idx){
			var value = $(this).val();
			$(this).val("");
			self.enabledFunction(value);
		});
		this.countNum.val(1);
	},
	giveUpEvent : function(){
		var self = this;
		var playerNumberVal = this.playerNumber.val();
		var myTurn = this.turn.val();
		var area = $("#area"+myTurn);
		var result = confirm("Player " + this.turn.val()  + " 님 항복하시겠습니까?");
		if(result){
			$.ajax({
				url : "/giveUp.do",
				data : {"playerNumber" : playerNumberVal},
				type : "post",
				success : function(data){
					alert("Player " + self.turn.val()  + "님이 맞췄어야 했던 정답은 "+data.answer+" 이었습니다.");
					if(data.gameOver==="true"){
						finishForm.submit();
					}
					area.val(area.val() + "\n항복");
					self.clearEvent();
					self.nextTurn(myTurn);
					if(parseInt(self.playerSize.val()) !== 1){
						self.labelCurrentPlayerEvent();
					}
				}
			});
		}
	},
	numCheck : function(num){
		var max = this.maxNum.val();
		if(num < 1){
			return 1;
		}
		if(num >= max){
			return max;
		}
		return num;
	},
	keyupEvent : function(event){
		event.preventDefault();
		var keyCode = event.keyCode;
		if((keyCode > 47 && keyCode < 58) || (keyCode > 95 && keyCode < 106)){
			var num;
			if(keyCode > 47 && keyCode < 58){
				num = keyCode-48;
			} else if(keyCode > 95 && keyCode < 106){
				num = keyCode-96;
			}
			this.numberClickEvent(num);
		} else if(keyCode == 8){
			this.cancelBtnClickEvent();
		} else if(keyCode == 13){
			this.inputEvent();
		}
	},
	init : function(){
		var self = this;
		self.numberBtn.click(function(){self.numberBtnClickEvent(event);});
		self.cancelBtn.click(function(){self.cancelBtnClickEvent();});
		self.inputBtn.click(function(){self.inputEvent();});
		self.giveUpBtn.click(function(){self.giveUpEvent();});
		self.body.keyup(function(){self.keyupEvent(event);});
	}
}

main.init();