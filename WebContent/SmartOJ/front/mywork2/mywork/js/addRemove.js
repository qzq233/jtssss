//_element是节点
function removeElement(_element){
         var _parentElement = _element.parentNode;
         if(_parentElement){
                _parentElement.removeChild(_element);  
         }
}
function addElement(_parentELe, _element){
	_parentEle.appendChild(_element);
}

function changelogin(username){
	var login = document.getElementById("h_login");
	removeElement(login);
	var dropdown = document.createElement("li");
	dropdown.setAttribute("class","dropdown");
	var span =  document.createElement("span");
	var a_account = document.createElement("a");
	a_account.setAttribute("class","dropdown-menu");
	a_account.setAttribute("href","#");
	a_account.setAttribute("data-toggle","dropdown");
	a_account.innerHTML = username;
	a_account.appendChild(span);
	var ul = document.createElement("ul");
	ul.setAttribute("class","dropdown-menu");
	var li = document.createElement("li");
	var a_logout = document.createElement("a");
	
}
