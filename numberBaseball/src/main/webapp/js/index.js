var index = {
	chooseNumberForm : $("#chooseNumberForm"),
	choosePlayerSizeForm : $("#choosePlayerSizeForm"),
	nextUrl : $("#nextUrl"),
	oneStartBtn : $("#oneStart"),
	twoStartBtn : $("#twoStart"),
	manyStartBtn : $("#manyStart"),
	chooseNumberEvent : function(event){
		var target = $(event.target);
		this.nextUrl.val(target.val());
		this.chooseNumberForm.submit();
	},
	choosePlayerSizeEvent : function(){
		this.nextUrl.val(this.manyStartBtn.val());
		this.choosePlayerSizeForm.submit();
	},
	init : function(){
		var self = this;
		self.oneStartBtn.click(function(){self.chooseNumberEvent(event);});
		self.twoStartBtn.click(function(){self.chooseNumberEvent(event);});
		self.manyStartBtn.click(function(){self.choosePlayerSizeEvent();});
		self.finishBtn.click(function(){self.finishBtnEvent();});
	}
}

index.init();