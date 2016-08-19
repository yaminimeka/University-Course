//created by Sai Kireety Kokkiligadda
//Last 4 digits of id:	7714

//variables

var username = "";
var xhr;
var crn1;
var crn2;
var crn3;
var courseArray;
var xhr1;

$(function() {

	jQuery(window).load(function() {

		var nameEQ = "username=";
		var ca = document.cookie.split(';');
		for (var i = 0; i < ca.length; i++) {
			var c = ca[i];
			while (c.charAt(0) == ' ')
				c = c.substring(1, c.length);
			if (c.indexOf(nameEQ) == 0) {
				username = c.substring(nameEQ.length, c.length)
				$("#userName").text(username);
				document.getElementById("user").value = username;
			}
		}

	}); // event listener for page load event

	jQuery("#Add")
			.click(
					function() {

						crn1 = document.getElementById("crn1").value;
						crn2 = document.getElementById("crn2").value;
						crn3 = document.getElementById("crn3").value;

						if (crn1 == "") {
							alert("please add CRN1");
							return false;
						} else if (crn2 == "") {
							alert("please add CRN2");
							return false;
						} else if (crn3 == "") {
							alert("please add CRN3");
							return false;
						}

						xhr = new XMLHttpRequest();

						xhr.open("get", "coursesAvailable.xml", false);
						xhr.send(null);

						courseArray = xhr.responseXML
								.getElementsByTagName("courses");
						var count1 = 0;
						if (crn1) {
							for (var i = 0; i < courseArray.length; i++) {

								var course = courseArray.item(i);
								var crn = course.getElementsByTagName("crn")
										.item(0).firstChild.nodeValue;
								if (crn == crn1) {
									crn1 = crn;
									crn1 = crn1
											+ "	"
											+ course.getElementsByTagName(
													"name").item(0).firstChild.nodeValue
											+ "	"
											+ course.getElementsByTagName(
													"instructor").item(0).firstChild.nodeValue
											+ "	"
											+ course.getElementsByTagName(
													"timing").item(0).firstChild.nodeValue
											+ "	"
											+ course
													.getElementsByTagName("day")
													.item(0).firstChild.nodeValue;
								} else {
									count1 += 1;
								}
							}
						}
						var count2 = 0;
						if (crn2) {

							for (var i = 0; i < courseArray.length; i++) {

								var course = courseArray.item(i);
								var crn = course.getElementsByTagName("crn")
										.item(0).firstChild.nodeValue;
								if (crn == crn2) {
									crn2 = crn;
									crn2 = crn2
											+ "	"
											+ course.getElementsByTagName(
													"name").item(0).firstChild.nodeValue
											+ "	"
											+ course.getElementsByTagName(
													"instructor").item(0).firstChild.nodeValue
											+ "	"
											+ course.getElementsByTagName(
													"timing").item(0).firstChild.nodeValue
											+ "	"
											+ course
													.getElementsByTagName("day")
													.item(0).firstChild.nodeValue;
								} else {
									count2 += 1;
								}
							}

						}
						var count3 = 0;
						if (crn3) {

							for (var i = 0; i < courseArray.length; i++) {

								var course = courseArray.item(i);
								var crn = course.getElementsByTagName("crn")
										.item(0).firstChild.nodeValue;

								if (crn == crn3) {
									crn3 = crn;
									crn3 = crn3
											+ "	"
											+ course.getElementsByTagName(
													"name").item(0).firstChild.nodeValue
											+ "	"
											+ course.getElementsByTagName(
													"instructor").item(0).firstChild.nodeValue
											+ "	"
											+ course.getElementsByTagName(
													"timing").item(0).firstChild.nodeValue
											+ "	"
											+ course
													.getElementsByTagName("day")
													.item(0).firstChild.nodeValue;
								} else {
									count3 += 1;
								}

							}

						}

						if (count1 == 10 || count2 == 10 || count3 == 10) {
							alert("Please provide proper CRN's");
							return false;
						}
						if (crn1 == crn2 || crn2 == crn3 || crn1 == crn3) {
							alert("Cannot choose two similar CRN's");
							return false;
						}

						var htmlUser = document.getElementById("user").value;

						$("#course1").text("Course 1 selected :		" + crn1);
						$("#course2").text("Course 2 selected :		" + crn2);
						$("#course3").text("Course 3 selected :		" + crn3);

						$("#jQShow").fadeIn(1500);

					}); // event listener for simple math button

	jQuery("#confirm").click(function() {
		document.forms[0].submit();
	});

	jQuery("#cancel").click(function() {
		window.open("addCourses.jsp", "_self");
	});
});
