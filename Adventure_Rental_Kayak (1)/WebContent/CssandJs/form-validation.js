$(document).ready(function() {
	validations();
});

function validations() {
    loginValidation();
    registerValidation();
}

function loginValidation(){
	$("#login-form").validate({
		rules: {
			email: {
				email: true,
				required: true
			},
			password: {
				required: true
			}
		}
	});
}

function registerValidation(){
	$("#register-form").validate({
		rules: {
			firstname: {
				required: true
			},
			lastname: {
				required: true
			},
			email: {
				email: true,
				required: true
			},
			password: {
				required: true
			},
			confirmpassword: {
				required: true,
				equalTo: "#password"
			}
		}
	});
}