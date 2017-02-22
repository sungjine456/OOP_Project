var main = {
	numberBtn : $(".numberBtn"),
	inputBtn : $("#inputBtn"),
	cancelBtn : $("#cancelBtn"),
	countNum : $("#countNum"),
	maxNum : $("#maxNum"),
	area : $("#area"),
	numberBtnClickEvent : function(event){
		var target = $(event.target);
		var value = target.val();
		var num = this.numCheck(this.countNum.val());
		var answer = $("#answer"+num);
		console.log(num);
		console.log(value);
		if(parseInt(num) == 1 && parseInt(value) == 0){
			alert("첫 숫자는 0이 될 수 없습니다.");
			return;
		}
		answer.val(value);
		this.countNum.val(parseInt(num)+1);
	},
	cancelBtnClickEvent : function(){
		var num = this.numCheck(this.countNum.val());
		var answer = $("#answer"+(parseInt(num)));
		answer.val("");
		this.countNum.val(parseInt(num)-1);
	},
	numCheck : function(num){
		var max = this.maxNum.val();
		if(num < 1){
			return 1;
		}
		if(num > max){
			return max;
		}
		return num;
	},
	init : function(){
		var self = this;
		self.numberBtn.click(function(){self.numberBtnClickEvent(event);});
		self.cancelBtn.click(function(){self.cancelBtnClickEvent();});
	}
}

main.init();