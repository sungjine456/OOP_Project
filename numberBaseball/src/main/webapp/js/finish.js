var finish = {
	firstPage : $("#firstPage"),
	changeNumber : $("#changeNumber"),
	reStart : $("#reStart"),
	chooseNumberForm : $("#chooseNumberForm"),
	startForm : $("#startForm"),
	num : $("input[name=num]"),
	firstPageEvent : function(){
		$(location).attr("href", "index.jsp");
	},
	changeNumberEvent : function(){
		this.chooseNumberForm.submit();
	},
	reStartEvent : function(){
		this.startForm.submit();
	},
	init : function(){
		var self = this;
		self.firstPage.click(function(){self.firstPageEvent();});
		self.changeNumber.click(function(){self.changeNumberEvent();});
		self.reStart.click(function(){self.reStartEvent();});
	}
}

finish.init();