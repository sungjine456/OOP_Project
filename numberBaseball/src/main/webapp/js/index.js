var index = {
	chooseNumberForm : $("#chooseNumberForm"),
	choosePlayerSizeForm : $("#choosePlayerSizeForm"),
	playerSize : $("#playerSize"),
	btn : $(".btn"),
	chooseNumberEvent : function(event){
		var target = $(event.target);
		if(target.val()===""){
			this.choosePlayerSizeForm.submit();
			return;
		}
		this.playerSize.val(target.val());
		this.chooseNumberForm.submit();
	},
	init : function(){
		var self = this;
		self.btn.click(function(){self.chooseNumberEvent(event);});
	}
}

index.init();