function setCookie(){
	if(window.document.fields.persist.checked){
		//Get the date and set it to next year
		var expDate = new Date();
		expDate.setFullYear(expDate.getFullYear() + 1);
		var user = window.document.fields.username.value;
		document.cookie="username=" + user + "," + "expires=" + expDate.toGMTString();
	} else {
		deleteCookie();
	}
	return true;
}
function deleteCookie(){
	if (document.cookie){
		//Get a date and set it to last year
		var expDate = new Date();
		expDate.setFullYear(expDate.getFullYear() - 1);
		document.cookie="username=" + "" + "," + "expires=" + expDate.toGMTString();
	}
}

function readCookie(){
	if(document.cookie){
		var theCookie = document.cookie;
		var pos = theCookie.indexof("username=");
		if(pos!=-1){
			var cookie_array = theCookie.split("=");
			var value = cookie_array[i];
			// load the stored username into the form
			window.document.cookieForm.username.value = value;
			window.document.cookieForm.persist.checked = true;
		}
	}
}