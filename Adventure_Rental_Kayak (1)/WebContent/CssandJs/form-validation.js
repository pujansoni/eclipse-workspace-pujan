$(document).ready(function() {
	validations();
});

function validations() {
    loginValidation();
    registerValidation();
    productRegistrationValidation();
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
				required: true,
				normalizer: function(value) {
                    return $.trim(value);
                }
			},
			lastname: {
				required: true,
				normalizer: function(value) {
                    return $.trim(value);
                }
			},
			email: {
				email: true,
				required: true,
				normalizer: function(value) {
                    return $.trim(value);
                }
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

function productRegistrationValidation(){
	console.log('hello');
	$("#product_registration").validate({
		rules: {
			Kayak_name: {
				required: true
			}
		}
	});
}