<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home-everification</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body class="bg-secondary">

	<div class="container-fluid">
		<div class="row bg-primary" style="position:sticky;top:0; z-index:100;height:70px">
     
            <div class="col-12 text-light d-flex justify-content-between align-items-center">
                <div class="pl-md-5" style="font-size: 30px;font-weight: bold;font-family: 'Times New Roman', Times, serif;">E-Verification </div><div><a class="text-light" href="HomePage.jsp">Home</a></div>
            </div>
     </div>
     	<div class="row" style="height:490px; background-image:url(\homebackground.jpg);background-repeat:no-repeat;background-size:100% ;">
   			<div class="col-1"></div>
   			<div class="col-11">
   			<div class="row pt-5 pr-2"><button class="bg-primary text-light" style="height: 50px;width: 300px;border-radius: 25px;" onclick="window.location.href = 'PendingDocsList.jsp';">Documents Pending List</button></div>
    		<div class="row pt-5"><button class="bg-primary text-light" style="height: 50px;width: 300px;border-radius: 25px;" onclick="window.location.href = 'PendingOrgList.jsp';">Organizations Pending List</button></div>
     		
   			</div>
   
		</div>
	
		<footer class="bg-secondary p-0" style="bottom:0;height:100px;width:100%;background:#6cf;">
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