var finish = {
	firstPage : $("#firstPage"),
	changeNumber : $("#changeNumber"),
	reStart : $("#reStart"),
	reStartAndMakeNumber : $("#reStartAndMakeNumber"),
	form : $("#form"),
	firstPageEvent : function(){
		$(location).attr("href", "index.jsp");
	},
	formEvent : function(event){
		this.form.attr("action", $(event.target).val());
		this.form.submit();
	},
	init : function(){
		var self = this;
		self.firstPage.click(function(){self.firstPageEvent();});
		self.changeNumber.click(function(){self.formEvent(event);});
		self.reStart.click(function(){self.formEvent(event);});
		self.reStartAndMakeNumber.click(function(){self.formEvent(event);});
	}
}

finish.init();