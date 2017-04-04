var login = {
	form : $("#form"),
	id : $("#id"),
	password : $("#password"),
	btn : $("#btn"),
	formEvent : function(){
		if(!this.password.val()){
			alert("비밀번호를 입력해주세요.");
		}
		if(!this.id.val()){
			alert("아이디를 입력해주세요");
		}
		form.submit();
	},
	init : function(){
		var self = this;
		self.btn.click(function(){self.formEvent();});
	}
}

login.init();