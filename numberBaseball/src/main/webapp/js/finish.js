var finish = {
	firstPage : $("#firstPage"),
	changeNumber : $("#changeNumber"),
	reStart : $("#reStart"),
	nextUrl : $("#nextUrl"),
	form : $("#form"),
	firstPageEvent : function(){
		$(location).attr("href", "index.jsp");
	},
	changeNumberEvent : function(){
		$(location).attr("href", "/chooseNumber.do?nextUrl="+this.nextUrl.val());
	},
	reStartEvent : function(){
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