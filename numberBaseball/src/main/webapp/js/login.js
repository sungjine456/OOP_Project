var login = {
	form : $("#form"),
	id : $("#id"),
	password : $("#password"),
	btn : $("#btn"),
	formEvent : function(){
		var idVal = this.id.val();
		var passwordVal = this.password.val();
		if(!idVal || idVal.length < 4 || idVal.length > 10){
			alert("아이디를 입력해주세요");
			return;
		}
		if(!passwordVal || passwordVal.length < 4 || passwordVal.length > 10){
			alert("비밀번호를 입력해주세요.");
			return;
		}
		form.submit();
	},
	init : function(){
		var self = this;
		self.btn.click(function(){self.formEvent();});
	}
}

login.init();