<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Created by Yamini Meka
			last 4 digits of id : 2765 -->

<meta charset="utf-8">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="addUserCourses.js"></script>
<link REL="StyleSheet" TYPE="text/css" HREF="/ClientSide/css/styles.css">


<title>Add Courses</title>
</head>
<body style="text-align: center;">
	<div id="overlay">
		<h1>Course Registration System</h1>
		<form action="addCoursesServlet" method="post">
			<div class=nav>
				<label>
					<ul>
						<li><a href="CourseList.html">Check For CRN</a></li>
						<li><a href="addCourses.jsp">Add Courses</a></li>
						<li><a href="LoginPage.html">Logout</a></li>
					</ul>
				</label>
			</div>

			<h1>Add Courses</h1>

			<b>Username:<label id="userName" name="userName"></label></b>
			<center>
				<table style="width: 80%; text-align: center">
					<tr>
						<td style="text-align: right">CRN 1</td>
						<td><div>
								<input type="text" id="crn1" name="crn1">
							</div></td>


					</tr>

					<tr>
						<td style="text-align: right">CRN 2</td>
						<td><div>
								<input type="text" id="crn2" name="crn2">
							</div></td>


					</tr>

					<tr>
						<td style="text-align: right">CRN 3</td>
						<td><div>
								<input type="text" id="crn3" name="crn3">
							</div></td>


					</tr>
				</table>


			</center>
			<input type="hidden" name="user" id="user"> <input
				class="button" type="button" name="Add" id="Add" value="Add" />


			<div id="jQShow" name="jQShow" style="display: none">
				<br /> <label id="course1"></label> <br /> <label id="course2"></label>
				<br /> <label id="course3"></label> <br /> <input type="button"
					class="button" name="confirm" id="confirm" value="confirm">
				<input type="button" class="button" name="cancel" id="cancel"
					value="cancel">
			</div>


		</form>
	</div>
</body>
</html>