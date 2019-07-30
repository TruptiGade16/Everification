<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="c"%>

<%@page import="com.cdac.everification.model.Organization"%>
<%

 	Organization org  = (Organization)session.getAttribute("org");
 	
 	List<Organization> ul = (List<Organization>)request.getAttribute("ul");
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

<script>
	function loadXMLDoc() {
		candidateId
		var id = document.getElementById("candidateId").value;
		var xmlhttp =new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200) {
				console.log(this.responseText);
				document.getElementById("myDIV").innerHTML = this.responseText; 
			}
		};
		xmlhttp.open("GET", "loginList.htm?id=" + id, true);
		xmlhttp.send();
	}

</script>
</head>
<body>
	<div class="container-fluid">

		<div class="row bg-primary" style="position:sticky;top:0; z-index:100;height:70px">
     
            <div class="col-12 text-light d-flex justify-content-between align-items-center">
                <div class="pl-md-5" style="font-size: 30px;font-weight: bold;font-family: 'Times New Roman', Times, serif;">E-Verification </div>
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
		<div style="height: 100%; padding-top: 5px; padding-bottom: 5px">
			<form >
				 <h1>
					Welcome
					<%=ul.get(0).getOrgName()%>
				</h1> 
				<br /> Enter Candidate Id : <input type="text" name="candidateId" id="candidateId">

				<input type="button" value="View Document" onclick="loadXMLDoc();"/>
			</form>

				 <div class="container-fluid">
					<div class="row " style="height: 430px;">
						<div class="col-12">
						
							<div id="myDIV">
								
							</div>
							
						</div>
					</div>
				</div> 
			</div>


		
</body>
</html>
