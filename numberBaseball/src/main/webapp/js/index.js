var index = {
	form : $("#form"),
	btn : $(".indexBtn"),
	btnClickEvent : function(event){
		var target = $(event.target);
		var id = target.attr("id")+".do";
		this.form.attr("action", id);
		this.form.submit();
		return false;
	},
	init : function(){
		var self = this;
		self.btn.click(function(){self.btnClickEvent(event);});
	}
}

index.init();