<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="c"%>


<!DOCTYPE html>

<html>
<head>

<title>Home-everification</title>

<script>
function isEmpty(value) {
    if (!value == "" && !value == "null" && !value == undefined) {
        return true;
    }
    else {
        return false;
    }
}

function emailIdValidation(){
	
	console.log("here...");
    var email = document.getElementById('emailId');
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if(!isEmpty() && !filter.test(email.value)) {

    document.getElementById("emailSpan").innerHTML="\n Invalid email address";
    document.getElementById("emailSpan").style.color="red";
    
    return false;
    }
    else{
        document.getElementById("emailSpan").innerHTML=" ";
       return true;
    }
}

function passwordFun(){
    var regName = /^[a-zA-Z]+$/;
    var passid = document.getElementById('pass').value;
    var passid_len = passid.length;
    if (passid_len == 0 || passid_len < 4 || passid_len > 10) {
        document.getElementById("SpanPass").innerHTML = "Password invalid 4-10";
        document.getElementById("SpanPass").style.color = "red";

        return false;
    } else {
        document.getElementById("SpanPass").innerHTML = ""
            
        return true;
    }
}

function mobNumberFun() {

    var mNo = document.getElementById('MbNum').value;
    var mNo_len = mNo.length;
    var mbnum=/^[0][1-9]\d{9}$|^[1-9]\d{9}$/
    if(!isEmpty() && !mbnum.test(mNo))
    {
       	document.getElementById("mSpan").innerHTML="Invalid Contact Number";
        document.getElementById("mSpan").style.color = "red";
        return false;
    }
    else{
        document.getElementById("mSpan").innerHTML=" ";
            return true;
    }
}

function showAlert(){
	if(document.getElementById("id1") == isEmpty())
	{
		alert("Please fill all fields..");
		
	}
	alert("Sucessfully Registered...");	
}

</script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

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
			</div>
		</div>

		<div class="row" style="padding-top: 5px; padding-bottom: 5px">
			<div class="col-3"></div>
			<div class="col-6"
				style="border: solid 2px black; border-radius: 10px;">
				<h3 style="text-align: center">Candidate Registration</h3>

				<c:form action="candiReg.htm" commandName="candi" enctype="multipart/form-data"
					style="font-weight: bold; margin-left: 80px;">
					<table id="id1">
						<tr>
							<td>First Name</td>
							<td style="padding-bottom: 10px;"><c:input path="candiFname"
									required="true" class="beauti" placeholder="Enter FirstName"
									style="padding-right: 100px;" /></td>
						</tr>


						<tr>
							<td>Last Name</td>
							<td style="padding-bottom: 10px;"><c:input path="candiLname"
									required="true" class="beauti" placeholder="Enter LastName"
									style="padding-right: 100px; " /></td>
						</tr>

						<tr>
							<td>City</td>
							<td style="padding-bottom: 10px;"><c:input path="candiCity"
									required="true" class="beauti" placeholder="Enter City"
									style="padding-right: 100px;" /></td>
						</tr>

						<tr>
							<td>State</td>
							<td style="padding-bottom: 10px;"><c:input path="candiState"
									required="true" class="beauti" placeholder="Enter State"
									style="padding-right: 100px;" /></td>
						</tr>

						<tr>
							<td>Email</td>
							<td style="padding-bottom: 10px;"><c:input path="candiEmail"
									required="true" class="beauti" id="emailId"
									onblur="emailIdValidation();" placeholder="Enter Email"
									style="padding-right: 100px;" /><span class="Span"
								id="emailSpan"></span></td>
						</tr>

						<tr>
							<td>Phone</td>
							<td style="padding-bottom: 10px;"><c:input path="candiPhone"
									required="true" class="beauti" id="MbNum"
									onblur="mobNumberFun()" placeholder="Enter phone"
									style="padding-right: 100px;" /><Span class="Span" id="mSpan"></Span></td>
						</tr>


						<tr>
							<td>User Name</td>
							<td style="padding-bottom: 10px;"><c:input
									path="candiUserName" required="true" class="beauti"
									placeholder="Enter UserName" style="padding-right: 100px;" /></td>
						</tr>
						<tr>
							<td>Password</td>
							<td style="padding-bottom: 10px;"><c:input path="password"
									required="true" id="pass" class="beauti" onblur="passwordFun()"
									placeholder="Enter Password" type="password"
									style="padding-right: 100px;" /><span class="Span1"
								id="SpanPass"></span></td>
						</tr>

						<tr>
							<td>Photo</td>
							<td><input type="file" style="" name="file" /><td>
						</tr>

						<tr>
							<td></td>
							<td style="padding-left: 50px; padding-top: 10px; padding-bottom: 10px">
							<input class="beauti" type="submit" onclick="showAlert()" value="Register"
								style="border-color: whitesmoke; border-radius: 7px; background-color: red; height: 35px; width: 100px;"></td>
						</tr>
					</table>
				</c:form>
			</div>
			<div class="col-3"></div>

		</div>
	</div>
</body>
</html>