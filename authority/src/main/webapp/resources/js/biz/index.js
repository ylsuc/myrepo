/**
 * index.js
 */

$(document).ready(function(){
	// 登录
	$("#btnSubmit").click(function(){
		var loginName = $("#loginName").val();
		var password = $("#password").val();
		
		$.ajax({
			url: ctx + "/operator/signIn",
			data: "loginName=" + loginName + "&password=" + password,
			success: function(data){
				if(data != null) {
					window.location.href= ctx + "/operator/operatorView";
				}
			},
			error: function(err) {
				console.log(err);
			}
		});
	});
	
	$("#btnReset").click(function(){
		$("#loginName").val("");
		$("#password").val("");
	});
});