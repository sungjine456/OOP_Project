var chooseNumber = {
	startForm : $("#startForm"),
	makeNumberForm : $("#makeNumberForm"),
	num : $("input[name=num]"),
	playerSize : $("#playerSize"),
	numberBtn : $(".numberBtn"),
	selectNumberEvent : function(event){
		var target = $(event.target);
		this.num.val(target.val());
		if(this.playerSize.val() >= 2 && confirm("직접 숫자를 지정하시겠습니까?") ==true){
			this.makeNumberForm.submit();
		} else {
			this.startForm.submit();
		}
	},
	init : function(){
		var self = this;
		self.numberBtn.click(function(){self.selectNumberEvent(event);});
	}
}

chooseNumber.init();