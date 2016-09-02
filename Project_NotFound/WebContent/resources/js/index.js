/**
 * 
 */
function submit() {
	var form = document.login;
	form.submit();
}

function f_join(){
	var loginform = document.login;
	var joinform = document.join;
	if(loginform.style.display == "none"){
		loginform.style.display = 'block';
		joinform.style.display = 'none';	
	}else{
		loginform.style.display = 'none';
		joinform.style.display = 'block';	
	}

	
}

function f_jsubmit(){
	var form = document.join;
	form.submit();
	
}

function f_idcheck(){
	// how? 
}