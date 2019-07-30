<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.cdac.everification.model.Organization"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x"%>

<%
	List<Organization> org = (List<Organization>) request.getAttribute("org");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body class="">


	<div class="row bg-primary"
		style="position: sticky; top: 0; z-index: 100; height: 70px">

		<div
			class="col-12 text-light d-flex justify-content-between align-items-center">
			<div class="pl-md-5"
				style="font-size: 30px; font-weight: bold; font-family: 'Times New Roman', Times, serif;">E-Verification
			</div>
			<div class="d-flex">
				<div class="mr-5">
					<a class="text-light"
						style="font-size: 30px; font-weight: bold; font-family: 'Times New Roman', Times, serif;"
						href="HomePage.jsp">Home</a>
				</div>
				<div>
					<a
						style="font-size: 30px; font-weight: bold; font-family: 'Times New Roman', Times, serif;"
						class="text-light" href="Logout.jsp">Logout</a>
				</div>
			</div>
		</div>
	</div>
	<h2 class="text-Dark" style="display: flex; justify-content: center;">Pending
		Organzations List For Validation</h2>
	<div class="container-fluid">
		<div class="row bg-light" style="">
			<div class="col-12">
				<div class="row bg-info" style="">
					<div class="col-1 " style="border: solid 1px black;">Sr No.</div>
					<div class="col-3" style="border: solid 1px black;">Organization
						Name</div>
					<div class="col-2" style="border: solid 1px black;">Organization
						Status</div>
					<div class="col-3" style="border: solid 1px black;">Status</div>
					<div class="col-3" style="border: solid 1px black;">Process
						Completed</div>
				</div>

				<%
					if (org != null) {
						int i = 0;
						for (Organization ul : org) {
				%>
				<div class="row" style="height: 28px">
					<div class="col-1 " style="border: solid 1px black;"><%=++i%></div>
					<div class="col-3" style="border: solid 1px black;"><%=ul.getOrgName()%></div>
					<div class="col-2" style="border: solid 1px black;"><%=ul.getOrgStatus()%></div>
					<div class="col-3" style="border: solid 1px black;">
						<form action="updateOrgStatus.htm">
							<input type="hidden" name="orgId" value="<%=ul.getId()%>">

							<select name="orgStatus" style="height: 19px; font-size: 12px"
								class="ml-5">
								<option value="Select Option">Select Option</option>
								<option value="Valid">Valid</option>
								<option value="Invalid">Invalid</option>
							</select> <input type="submit" value="Update Status" class="pt-1 ml-2"
								style="font-size: 10px;">
					</div>
					</form>

					<div class="col-3" style="border: solid 1px black;">
						<a href="">Process Complete</a>
					</div>
				</div>
				<%
					}
					} else {
				%>
				<h1 class="text-danger">No Pending Organization</h1>
				<%
					}
				%>
			</div>
		</div>
		<!-- 	<footer class=" bg-secondary p-0"
			style="bottom: 0; height: 100px; width: 100%; background: #6cf;">
			<div class="row" style="height: 30px">
				<div class="col-4" style="color: white">
					<h6>
						Contact Us:
						<h6>
							<div style="font-size: 15px">Email : sanketchhalke@gmail.com</div>
							<div style="font-size: 15px">Phone : 98745612310</div>
							<div style="font-size: 15px; margin-bottom: 2px">Address :
								Kharghar</div>
				</div>
			</div>
			<div class="col-4 "></div>
			<div class="col-4"></div>
		</footer> -->
	</div>
</body>
</html>