var main = {
	numberBtn : $(".numberBtn"),
	inputBtn : $("#inputBtn"),
	cancelBtn : $("#cancelBtn"),
	countNum : $("#countNum"),
	maxNum : $("#maxNum"),
	area : $("#area"),
	inputData : $("input[name='inputData']"),
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
	inputEvent : function(){
		var self = this;
		var num = this.numCheck(this.countNum.val());
		var max = this.maxNum.val();
		if(parseInt(num) !== parseInt(max)){
			alert("숫자를 모두 입력해주세요.");
			return;
		}
		var arr = "";
		this.inputData.each(function(idx){
			var value = $(this).val();
			arr += value + " ";
		});
		$.ajax({
			url : "/inputNum.do",
			type : "post",
			data : {"input" : arr},
			success : function(data){
				self.area.val(self.area.val() + "\n" + arr + " -> " + data.confirm);
				self.clearEvent();
			}
		});
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
	init : function(){
		var self = this;
		self.numberBtn.click(function(){self.numberBtnClickEvent(event);});
		self.cancelBtn.click(function(){self.cancelBtnClickEvent();});
		self.inputBtn.click(function(){self.inputEvent();});
	}
}

main.init();