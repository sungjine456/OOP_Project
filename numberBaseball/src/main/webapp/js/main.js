var main = {
	numberBtn : $(".numberBtn"),
	inputBtn : $("#inputBtn"),
	cancelBtn : $("#cancelBtn"),
	area : $("#area"),
	numberBtnClickEvent : function(event){
		var target = $(event.target);
		var value = target.val();
		alert(value);
	},
	init : function(){
		var self = this;
		self.numberBtn.click(function(){self.numberBtnClickEvent(event);});
	}
}

main.init();