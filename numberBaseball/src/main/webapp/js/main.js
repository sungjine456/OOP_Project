var main = {
	numberBtn : $(".numberBtn"),
	inputBtn : $("#inputBtn"),
	cancelBtn : $("#cancelBtn"),
	area : $("#area"),
	numberBtnClickEvent : function(event){
		var target = $(event.target);
		var value = target.val();
		var areaVar = this.area.val();
		if(areaVar!=""){
			this.area.val(areaVar+ " "+value);
		} else {
			this.area.val(value);
		}
	},
	init : function(){
		var self = this;
		self.numberBtn.click(function(){self.numberBtnClickEvent(event);});
	}
}

main.init();