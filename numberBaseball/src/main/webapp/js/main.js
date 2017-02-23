var main = {
	numberBtn : $(".numberBtn"),
	inputBtn : $("#inputBtn"),
	cancelBtn : $("#cancelBtn"),
	countNum : $("#countNum"),
	maxNum : $("#maxNum"),
	area : $("#area"),
	numberBtnClickEvent : function(event){
		var target = $(event.target);
		var value = parseInt(target.val());
		var num = parseInt(this.numCheck(this.countNum.val()));
		var answer = $("#answer"+num);
		
		if(num == 1 && value == 0){
			alert("첫 숫자는 0이 될 수 없습니다.");
			return;
		}
		if(num === parseInt(this.maxNum.val()) && answer.val() !== ""){
			this.enabledFunction(answer.val());
		}
		target.attr("class", "numberBtn checkBtn");
		target.attr("disabled", true);
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
	init : function(){
		var self = this;
		self.numberBtn.click(function(){self.numberBtnClickEvent(event);});
		self.cancelBtn.click(function(){self.cancelBtnClickEvent();});
	}
}

main.init();