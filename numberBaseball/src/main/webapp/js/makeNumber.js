var makeNumberPage = {
	insertBtn : $("#insertBtn"),
	makeNum : $("#makeNum"),
	num : $("#num"),
	form : $("#form"),
	insertEvent : function(){
		var makeNum = this.makeNum.val().trim();
		if(!makeNum){
			alert("숫자를 입력해주세요.");
			this.makeNum.val("");
			this.makeNum.focus();
			return;
		}
		if(isNaN(parseInt(makeNum))){
			alert("숫자를 입력해주세요.");
			this.makeNum.val("");
			this.makeNum.focus();
			return;
		}
		if(this.num.val() != makeNum.length){
			alert("숫자크기에 맞는 숫자를 입력해주세요.");
			this.makeNum.val("");
			this.makeNum.focus();
			return;
		}
		this.form.attr("onsubmit", "return true");
		this.form.submit();
	},
	init : function(){
		var self = this;
		self.insertBtn.click(function(){self.insertEvent();});
	}
}

makeNumberPage.init();