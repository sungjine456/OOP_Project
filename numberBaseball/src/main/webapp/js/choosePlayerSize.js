var choosePlayerSize = {
	form : $("#form"),
	playerSize : $("#playerSize"),
	numberBtn : $(".numberBtn"),
	selectNumberEvent : function(event){
		var target = $(event.target);
		this.playerSize.val(target.val());
		this.form.submit();
	},
	init : function(){
		var self = this;
		self.numberBtn.click(function(){self.selectNumberEvent(event);});
	}
}

choosePlayerSize.init();