$(document).ready(function() {
	registerValidation();
});

function registerValidation(){
	$("#register_user").validate({
	    rules: {
	    	firstname: "required"
	    },
	    messages: {
	    	firstname: "This field is required"
	    }
	});
}