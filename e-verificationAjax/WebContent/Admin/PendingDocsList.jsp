<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	List<String> nameList = (List<String>) request.getAttribute("candiName");
	List<String> docList = (List<String>) request.getAttribute("docTypes");
	List<Integer> docId = (List<Integer>) request.getAttribute("docId");

	/* 	
	 out.println("**********"+userList.size());
	 out.println("**********"+docList.size()); */
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
					<a class="text-light" style="font-size: 30px; font-weight: bold; font-family: 'Times New Roman', Times, serif;" href="HomePage.jsp">Home</a>
				</div>
				<div>
					<a
						style="font-size: 30px; font-weight: bold; font-family: 'Times New Roman', Times, serif;"
						class="text-light" href="Logout.jsp">Logout</a>
				</div>
				</div>
		</div>
	</div>
	<h2 class="bg-secondary text-light"
		style="display: flex; justify-content: center;">Pending Documents
		List For Validation</h2>
	<div class="container-fluid">
		<div class="row bg-light" style="height: 430px;">
			<div class="col-12">
				<div class="row bg-info" style="">
					<div class="col-1 " style="border: solid 1px black;">Sr No.</div>
					<div class="col-2" style="border: solid 1px black;">Candidate
						Name</div>
					<div class="col-2" style="border: solid 1px black;">Document
						type</div>
					<div class="col-1" style="border: solid 1px black;">View
						Document</div>
					<div class="col-3" style="border: solid 1px black;">Status</div>
					<div class="col-3" style="border: solid 1px black;">Process
						Completed</div>
				</div>

				<%
					int j = 0;
					if (docList != null) {
						for (int i = 0; i < docList.size(); i++) {
				%>
				<div class="row" style="height: 28px">

					<div class="col-1 " style="border: solid 1px black;">
						<a class="ml-5"><%=docId.get(i)%> </a>
					</div>
					<div class="col-2" style="border: solid 1px black;"><%=nameList.get(i)%></div>
					<div class="col-2" style="border: solid 1px black;"><%=docList.get(i)%></div>
					<div class="col-1" style="border: solid 1px black;">
						<a class="ml-4" href="">View</a>
					</div>
					<div class="col-3" style="border: solid 1px black;">
						<form action="updateDocStatus.htm">
							<input type="hidden" name="docId" value="<%=docId.get(i)%>">

							<select name="docStatus" style="height: 19px; font-size: 12px"
								class="ml-5">
								<option value="Select Option">Select Option</option>
								<option value="Valid">Valid</option>
								<option value="Invalid">Invalid</option>
							</select> <input type="submit" value="Update Status" class="pt-1 ml-2"
								style="font-size: 10px;">
					</div>
					</form>
					<div class="col-3" style="border: solid 1px black;">
						<a href="">Process Comppleted</a>
					</div>
				</div>
				<%
					}
					}
				%>

			</div>
		</div>
		<!-- <footer class=" bg-secondary p-0"
			style="bottom: 0; height: 100px; width: 100%; background: #6cf;">
			<div class="row" style="height: 30px">
				<div class="col-4" style="color: white">
					<h6>
						Contact Us:
						<h6>
							<div style="font-size: 15px">Email :
								sanketchhalke@gmail.com</div>
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