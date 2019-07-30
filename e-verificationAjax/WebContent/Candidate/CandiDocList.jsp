<%@page import="com.cdac.everification.model.DocumentMaster"%>
<%@page import="com.cdac.everification.model.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="c"%>

<%@page import="com.cdac.everification.model.CandiDocs"%>
<%
	CandiDocs can = (CandiDocs) session.getAttribute("org");
	List<CandiDocs> userList = (List<CandiDocs>) request.getAttribute("ul");
	List<String> ul1 = (List<String>) request.getAttribute("cName");
	List<String> ul2 = (List<String>) request.getAttribute("dName");

	/* Candidate candiName=(Candidate)session.getAttribute("cName");
	DocumentMaster docName=(DocumentMaster)session.getAttribute("dName"); */
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
<style>
#myDIV {
	width: 100%;
	padding: 50px 0;
	text-align: center;
	background-color: lightblue;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="container-fluid">

		<div class="row bg-primary"
			style="position: sticky; top: 0; z-index: 100; height: 70px">

			<div
				class="col-12 text-light d-flex justify-content-between align-items-center">
				<div class="pl-md-5"
					style="font-size: 30px; font-weight: bold; font-family: 'Times New Roman', Times, serif;">E-Verification
				</div>
				<div class="d-flex">
				<div class="mr-5">
					<a class="text-light" style="font-size: 30px; font-weight: bold; font-family: 'Times New Roman', Times, serif;" href="CandidateWelcome.jsp">Back</a>
				</div>
				<div>
					<a
						style="font-size: 30px; font-weight: bold; font-family: 'Times New Roman', Times, serif;"
						class="text-light" href="Logout.jsp">Logout</a>
				</div>
				</div>
			</div>
		</div>
		<h1 style="display: flex;justify-content: center;align-items: center;">
			Document List
			
		</h1>
		<br />
		<div id="myDIV">
			<div class="container-fluid">
				<div class="row " style="">
					<div class="col-12">
						<div class="row " style="">
							<div class="col-2"></div>
							<div class="col-1 " style="border: solid 1px black;">Sr No.</div>
							<div class="col-2" style="border: solid 1px black;">Document
								type</div>
							<div class="col-2" style="border: solid 1px black;">Status</div>
							<div class="col-1" style="border: solid 1px black;">View
								Document</div>
							<div class="col-2" style="border: solid 1px black;">Apply
								for Verification</div>
							<div class="col-2"></div>
						</div>

						<%
							int i = 1;
							int j = 0;
							for (CandiDocs u : userList) {
						%>
						<div class="row" style="height: 25px">
							<div class="col-2"></div>
							<div class="col-1 " style="border: solid 1px black;"><%=i++%></div>
							<div class="col-2" style="border: solid 1px black;"><%=ul2.get(j++)%></div>
							<div class="col-2" style="border: solid 1px black;"><%=u.getDocStatus()%></div>
							<div class="col-1" style="border: solid 1px black;">
								<form action="viewDoc.htm">
									<input type="hidden" name="docPath" value=<%=u.getDocPath()%>>
									<input type="submit" value="View"
										class="pt-1 ml-2" style="font-size: 10px;">
								</form>
							</div>
							<div class="col-2" style="border: solid 1px black;">
								<form action="updateDocStatusofCandidate.htm">
									<input type="hidden" name="candiId" value=<%=userList.get(0).getCandiId()%>>

									<input type="hidden" name="docId" value=<%=u.getId()%>>
									<input type="submit" value="Apply for Validation"
										class="pt-1 ml-2" style="font-size: 10px;">
								</form>
							</div>
							
							<div class="col-2"></div>
						</div>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- <script>
function myFunction() {
  var x = document.getElementById("myDIV");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
</script> -->
	<!-- <footer class="w3-container bg-secondary mt-5"
		style="bottom: 0; width: 100%; height: 80px; background: #6cf;">

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

</body>
</html>
