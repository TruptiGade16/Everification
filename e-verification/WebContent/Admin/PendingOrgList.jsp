<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body class="bg-secondary">

	
		 <div class="row bg-primary" style="position:sticky;top:0; z-index:100;height:70px">
     	    <div class="col-12 text-light d-flex justify-content-between align-items-center">
                <div class="pl-md-5" style="font-size: 30px;font-weight: bold;font-family: cursive;">E-Verification </div>
            </div>
     	</div>
	<h2 class="bg-secondary text-light" style="display: flex;justify-content: center;">Pending Organzations List For Validation</h2>
	<div class="container-fluid">
     	<div class="row bg-light" style="height:430px; ">
			<div class="col-12">
				<div class="row bg-info" style="">
					<div class="col-1 "style="border: solid 1px black;">Sr No.</div>
					<div class="col-3"style="border: solid 1px black;">Candidate Name</div>
					<div class="col-2"style="border: solid 1px black;">Document type</div>
					<div class="col-3"style="border: solid 1px black;">Status</div>
					<div class="col-3"style="border: solid 1px black;" >Process Completed</div>
				</div>
		
	 <% for (int i=0;i<5;i++) 
	{
		%>
		<div class="row" style="height: 25px">
			<div class="col-1 "style="border: solid 1px black;"></div>
			<div class="col-3"style="border: solid 1px black;"></div>
			<div class="col-2"style="border: solid 1px black;"></div>
			<div class="col-3"style="border: solid 1px black;"></div>
			<div class="col-3"style="border: solid 1px black;" ></div>
		</div>
	<% } %>	 
			</div>
		</div>
	<footer class=" bg-secondary p-0" style="bottom:0;height:100px;width:100%;background:#6cf;">
 			<div class="row" style="height: 30px">	
 				<div class="col-4" style="color:white" >
 					<h6>Contact Us:<h6>
					<div style="font-size: 15px">Email : sanketchhalke@gmail.com</div>
					<div style="font-size: 15px">Phone : 98745612310</div>
 					<div style="font-size: 15px; margin-bottom:2px">Address : Kharghar</div>
 				</div>
 			</div>
 			<div class="col-4 "></div>
 			<div class="col-4"></div>
 		</footer>
	</div>
</body>
</html>