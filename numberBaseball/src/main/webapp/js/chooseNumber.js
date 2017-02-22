var chooseNumber = {
	form : $("#form"),
	num : $("#num"),
	numberBtn : $(".numberBtn"),
	selectNumberEvent : function(event){
		var target = $(event.target);
		this.num.val(target.val());
		this.form.submit();
	},
	init : function(){
		var self = this;
		self.numberBtn.click(function(){self.selectNumberEvent(event);});
	}
}

chooseNumber.init();