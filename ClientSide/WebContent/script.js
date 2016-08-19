//created by Priyanka Singh
//Last 4 digits of id:	1386 

//variables

var xhr; // avriable for XMLHttpRequest at the global level.
var usersArray;

function validate() {

	// instantiate the XHR object
	xhr = new XMLHttpRequest();

	// load the xml file from the server using xhr
	xhr.open("get", "loginUsers.xml", false);
	xhr.send(null);

	// Once the xhr goes through the xml file data is in the xhr.response object
	// transfer the data into a variable (global)
	usersArray = xhr.responseXML.getElementsByTagName("users");
	displayData();

}// end function loadXML()

function displayData() {
	var finalresult = "Success";
	var message = "";
	for (var i = 0; i < usersArray.length; i++) {
		var user = usersArray.item(i);
		var userName = user.getElementsByTagName("username").item(0).firstChild.nodeValue;
		var password = user.getElementsByTagName("password").item(0).firstChild.nodeValue;
		if (document.getElementById("userName").value != "") {
			if (document.getElementById("userName").value == userName) {
				if (document.getElementById("password").value != "") {
					if (document.getElementById("password").value == password) {
						var date = new Date();
						date.setTime(date.getTime() + (24 * 60 * 60 * 1000));
						var expires = "; expires=" + date.toGMTString();
						document.cookie = "username="
								+ document.getElementById("userName").value
								+ expires + "; path=/";
						finalresult = "Success";
						openUrl();
						break;
					} else {
						finalresult = "Fail";
						message = "Password and User Doesnt match";
					}

				} else {
					finalresult = "Fail";
					message = "Password and User Doesnt match";
				}
			} else {
				finalresult = "Fail";
				message = "Provide a valid password";
			}
		} else {
			finalresult = "Fail";
			message = "Please Provide an user name";
		}
	}
	if (finalresult == "Fail") {
		alert(message);
		return false;
	} 

}// end function displayData()
function openUrl() {
	window.close();
	window.open("Welcome.html");
}

function removeCookie() {
	var date = new Date();
	date.setTime(date.getTime() + (24 * 60 * 60 * 1000));
	var expires = "; expires=" + date.toGMTString();
	document.cookie = "username=" + "" + expires + "; path=/";

}
