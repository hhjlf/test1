var i = 0;
function idCheck(id){
	if(id==""){
		alert("아이디를 입력");
		document.regForm.id.focus();
	}else{
		url="member.mdo?cmd=idCheck&id="+id;
		window.open(url,"post","width=300,height=150");
		i= 1;
	}
}
function idchange(){
	i=0;
}
function zipCheck(){
	url="member.mdo?cmd=zipCheck&check=y";
	window.open(url,"post","toolbar=no,width=500,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
}
function inputCheck(){
	var theForm = document.regForm;
	
	if(!theForm.id.value){
		alert("아이디입력해");
		theForm.id.focus();
		return;
	}
	if(!theForm.pass.value){
		alert("비번입력");
		theForm.pass.focus();
		return;
	}
	if(!theForm.repass.value){
		alert("비번홛인");
		theForm.repass.focus();
		return;
	}
	if(theForm.repass.value!= theForm.pass.value){
		alert("비번같게해여");
		theForm.repass.focus();
		return;
	}
	if(i==1){
	alert("dz");
	theForm.submit();
}else{
	alert("id 중복확인");
}
}