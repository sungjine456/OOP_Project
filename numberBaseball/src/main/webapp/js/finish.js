var finish = {
	firstPage : $("#firstPage"),
	changeNumber : $("#changeNumber"),
	reStart : $("#reStart"),
	form : $("#form"),
	num : $("input[name=num]"),
	firstPageEvent : function(){
		$(location).attr("href", "index.jsp");
	},
	changeNumberEvent : function(){
		this.form.attr("action", this.changeNumber.val());
		this.form.submit();
	},
	reStartEvent : function(){
		this.form.attr("action", this.reStart.val());
		this.form.submit();
	},
	init : function(){
		var self = this;
		self.firstPage.click(function(){self.firstPageEvent();});
		self.changeNumber.click(function(){self.changeNumberEvent();});
		self.reStart.click(function(){self.reStartEvent();});
	}
}

finish.init();