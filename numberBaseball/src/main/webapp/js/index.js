var index = {
	form : $("#form"),
	nextUrl : $("#nextUrl"),
	btn : $(".indexBtn"),
	btnClickEvent : function(event){
		var target = $(event.target);
		this.nextUrl.val(target.val());
		this.form.submit();
		return false;
	},
	init : function(){
		var self = this;
		self.btn.click(function(){self.btnClickEvent(event);});
	}
}

index.init();