

function validate(frm){
	//empty the validation error messages
	alert("client side form data validation");
	document.getElementById("pnameErr").innerHTML = "";
	document.getElementById("paddrErr").innerHTML = "";
	document.getElementById("pageErr").innerHTML = "";
	//read the data
	let name = frm.pname.value;
	let addrs = frm.paddr.value;
	let age = frm.page.value;
	//client side form validation 
	let flag = true;
	if(name == ""){
		document.getElementById("pnameErr").innerHTML = "Person name is required...";
		frm.pname.focus();
		flag = false;
	}
	if(addrs == ""){
		document.getElementById("paddrErr").innerHTML = "Person addrs is required...";
		frm.paddr.focus();
		flag = false;
	}
	else if(addrs.length<10){
		document.getElementById("paddrErr").innerHTML = "Person addrs must have min of 10 characters...";
		frm.paddr.focus();
		flag = false;
	}
	if(age == ""){
		document.getElementById("pageErr").innerHTML = "Person age is required...";
		frm.page.focus();
		flag = false;
	}
	else if(isNan(age)){
		document.getElementById("pageErr").innerHTML ="Person age must be numeric value...";
		frm.page.focus();
		flag = false;
	}
	else if(age<= 0 || age>125){
		document.getElementById("pageErr").innerHTML = "Person age must be in the range of 1 to 125...";
		frm.page.focus();
		flag = false;
	}
	//chnage the vflag as yes
	frm.vflag.value="yes";
	return flag;
}
