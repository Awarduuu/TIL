// 여기는 js 영역입니다.

alert("자바스크립트입니다!")
function btn1Check(e){
	alert(e.target);
	//e.target.style.backgroundColor = "red";
	//e.target.style.color = "white";
	
	document.querySelector("#btn").style.fontSize = "30px";
}

function btnFun(){
	console.log("배고프");
}