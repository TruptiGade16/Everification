<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-everification</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body class="bg-secondary">

	<div class="container-fluid">
		<div class="row bg-primary"
			style="position: sticky; top: 0; z-index: 100; height: 70px">

			<div
				class="col-12 text-light d-flex justify-content-between align-items-center">
				<div class="pl-md-5"
					style="font-size: 30px; font-weight: bold; font-family: 'Times New Roman', Times, serif;">E-Verification
				</div>
			</div>
		</div>
		<div class="row bg-light" style="height: 500px">
			<div class="col-12">
				<div class="row"
					style="height: 200px; padding-top: 70px; padding-bottom: 5px">
					<div class="col-3"></div>
					<div class="col-5"
						style="border: solid 2px black; border-radius: 10px;">
						<h3 style="text-align: center">Admin Login</h3>

						<spr:form action="login1.htm" commandName="adm"
							style="font-weight: bold; margin-left: 80px;">
							<table>
								<tr>
									<td>UserName</td>
									<td style="padding-bottom: 10px;"><spr:input
											path="adminId" class="beauti" id="Fname"
											placeholder="Enter Name" style="padding-right: 100px;" /></td>
								</tr>

								<tr>
									<td>Password</td>
									<td style="padding-bottom: 10px;"><spr:input
											path="adminPassword" type="password" class="beauti"
											id="Fname" placeholder="Enter Password"
											style="padding-right: 100px;" /></td>
								</tr>
								<tr>
									<td></td>
									<td style="padding-bottom: 10px; padding-left: 30px"><input
										class="beauti" type="submit" value="Login"
										style="color: whitesmoke; border-radius: 7px; background-color: red; height: 35px; width: 100px;">
										<input class="beauti" type="submit" value="SignUp"
										formaction="prep_OrgReg_form1.htm"
										style="color: whitesmoke; border-radius: 7px; background-color: red; height: 35px; width: 100px;">
									</td>
								</tr>
							</table>
						</spr:form>
					</div>
					<div class="col-4"></div>

				</div>
			</div>
		</div>
		<footer class="w3-container bg-secondary"
			style="bottom: 0; width: 100%; height: 80px; background: #6cf;">

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
	</div>
	</footer>
	</div>
</body>
</html>