//created by Yamini Meka
//Last 4 digits of id:	2765

//variables

var table;
var xhr; // avriable for XMLHttpRequest at the global level.
var courseArray;

function courseAjax() {
	try {
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				table = document.getElementById("coursesTable");
				for (var i = 0; i < 10; i++) {

					//during each iteration, process one state.
					var course = xhr.responseXML
							.getElementsByTagName("courses").item(i);
					var name = course.getElementsByTagName("name").item(0).firstChild.nodeValue;// gets the state data into the var
					var instructor = course.getElementsByTagName("instructor")
							.item(0).firstChild.nodeValue; // gets the capital data into the var
					var timing = course.getElementsByTagName("timing").item(0).firstChild.nodeValue;// gets the state data into the var
					var day = course.getElementsByTagName("day").item(0).firstChild.nodeValue; // gets the capital data into the var
					var crn = course.getElementsByTagName("crn").item(0).firstChild.nodeValue; // gets the capital data into the var

					//create a tr element, 2 td elements, and data nodes for td using the variables above.

					var tableRow = document.createElement("tr");
					var nameCell = document.createElement("td");
					var instructorCell = document.createElement("td");
					var timingCell = document.createElement("td");
					var dayCell = document.createElement("td");
					var crnCell = document.createElement("td");

					//put the data inside the cells:
					nameCell.innerHTML = name;
					instructorCell.innerHTML = instructor;
					timingCell.innerHTML = timing;
					dayCell.innerHTML = day;
					crnCell.innerHTML = crn;

					//add the cells as children for TR (tableRow)
					tableRow.appendChild(nameCell);
					tableRow.appendChild(instructorCell);
					tableRow.appendChild(timingCell);
					tableRow.appendChild(dayCell);
					tableRow.appendChild(crnCell);

					//add the tableRow as a child for the html table 
					table.appendChild(tableRow);

				}

			}
		}
		xhr.open("GET", "coursesAvailable.xml", true);
		xhr.send(null);
	} catch (exception) {
		alert("XHR Failed");
	}
}

//Creating Event Listener with anonymous function:
window.addEventListener("load", courseAjax, false);
