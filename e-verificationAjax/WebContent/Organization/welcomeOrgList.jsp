<%@page import="com.cdac.everification.model.Candidate"%>
<%@page import="com.cdac.everification.model.CandiDocs"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="c"%>

<%@page import="com.cdac.everification.model.Organization"%>
<%
	Organization org = (Organization) session.getAttribute("org");
	List<Candidate> userList = (List<Candidate>) request.getAttribute("ul");
	List<CandiDocs> docList = (List<CandiDocs>) request.getAttribute("docList");
	List<String> docType = (List<String>) request.getAttribute("docType");
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

		<div class="row bg-primary" style="position:sticky;top:0; z-index:100;height:70px">
     
            <div class="col-12 text-light d-flex justify-content-between align-items-center">
                <div class="pl-md-5" style="font-size: 30px;font-weight: bold;font-family: 'Times New Roman', Times, serif;">E-Verification </div><div><a class="text-light" href="HomePage.jsp">Home</a></div>
            </div>
     </div>
		<h1>
			Documents of
			<%=userList.get(0).getCandiFname()%>
		</h1>
		<br />
		<div id="myDIV">
			<div class="container-fluid">
				<div class="row " style="height: 430px;">
					<div class="col-12">
						<div class="row " style="">
							<div class="col-2"></div>
							<div class="col-1 " style="border: solid 1px black;">Sr No.</div>
							<div class="col-2" style="border: solid 1px black;">Document
								type</div>
							<div class="col-2" style="border: solid 1px black;">Status</div>
							<div class="col-1" style="border: solid 1px black;">View
								Document</div>
							<div class="col-2" style="border: solid 1px black;">Process
								Completed</div>
							<div class="col-2"></div>
						</div>

						<%
							int i = 1;
							int j = 0;
							for (CandiDocs u : docList) {
						%>
						<div class="row" style="height: 25px">
							<div class="col-2"></div>
							<div class="col-1 " style="border: solid 1px black;"><%=i++%></div>
							<div class="col-2" style="border: solid 1px black;"><%=docType.get(j++)%></div>
							<div class="col-2" style="border: solid 1px black;"><%=u.getDocStatus()%></div>
							<div class="col-1" style="border: solid 1px black;">
								<a href="">View</a>
							</div>
							<div class="col-2" style="border: solid 1px black;">
								<a href="">Procee Complete</a>
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
	<footer class="w3-container bg-secondary mt-5"
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
	</footer>

</body>
</html>
