<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--	
			Created by Sai Kireety Kokkiligadda
			last 4 digits of id : 2765
		-->

<title>Course List</title>

<meta charset="utf-8">

<script type="text/javascript" src="course.js"></script>
<link REL="StyleSheet" TYPE="text/css" HREF="/ClientSide/css/styles.css">

</head>

<%
	ArrayList userCourses = (ArrayList) request
			.getAttribute("userCourses");
%>
<body style="text-align: center">
<h1>Course Registration System</h1>
<div id="overlay">
	
	<div class = nav>
			<label>
				<ul>
					<li><a href="CourseList.html">Check For CRN</a></li>
					<li><a href="addCourses.jsp">Add Courses</a></li>
					<li><a href="LoginPage.html">Logout</a></li>
				</ul>
			</label>
		</div>
	
	<h1><%=(String) session.getAttribute("userName")%>
		Classes are
	</h1>
	<table width="100%" style="text-align: center">
		<tr>
			<td><%=userCourses.get(1)%></td></tr>
			<tr><td><%=userCourses.get(2)%></td></tr>
			<tr><td><%=userCourses.get(3)%></td>
		</tr>
	</table>
	</div>
</body>
</html>