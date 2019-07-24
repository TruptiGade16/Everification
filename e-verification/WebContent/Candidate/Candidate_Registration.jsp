<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home-everification</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
</head>
<body>

    <div class="container-fluid">
     <div class="row bg-primary" style="position:sticky;top:0; z-index:100;height:70px">
     
            <div class="col-12 text-light d-flex justify-content-between align-items-center">
                <div class="pl-md-5" style="font-size: 30px;font-weight: bold;font-family: 'Times New Roman', Times, serif;">E-Verification </div>
            </div>
     </div>
     
     <div class="row" style="padding-top: 5px; padding-bottom: 5px">
            <div class="col-3">

            </div>
            <div class="col-6" style="border: solid 2px black; border-radius: 10px; ">
                    <h3 style="text-align: center">Candidate Registration</h3>
                   
                    <c:form action = "candiReg.htm" commandName="candi" style="font-weight: bold; margin-left: 80px;">
                        <table>
                        <tr> 
                            <td>First Name</td>
                            <td style="padding-bottom: 10px;"><c:input path = "candiFname" class="beauti" placeholder="Enter FirstName" style="padding-right: 100px;" /></td> 
                        </tr>

                        
                        <tr >
                            <td>Last Name</td>
                            <td style="padding-bottom: 10px;"><c:input path = "candiLname" class="beauti" placeholder="Enter LastName" style="padding-right: 100px; "/></td>
                        </tr>
                        
                        <tr>
                            <td>City</td>
                            <td style="padding-bottom: 10px;"><c:input path = "candiCity" class="beauti" placeholder="Enter City" style="padding-right: 100px;"/></td>
                        </tr>

                        <tr>
                            <td>State</td>
                            <td style="padding-bottom: 10px;"><c:input path = "candiState" class="beauti" placeholder="Enter State" style="padding-right: 100px;"/></td>
                        </tr>

                        <tr>
                            <td>Email</td>
                            <td style="padding-bottom: 10px;"><c:input path = "candiEmail" class="beauti" placeholder="Enter Email" style="padding-right: 100px;"/></td>
                        </tr>

                        <tr>
                            <td>Phone</td>
                            <td style="padding-bottom: 10px;"><c:input path = "candiPhone" class="beauti" placeholder="Enter phone" style="padding-right: 100px;"/></td>
                        </tr>

                      
                        <tr> 
                            <td>User Name</td>
                            <td style="padding-bottom: 10px;"><c:input path = "candiUserName" class="beauti" placeholder="Enter UserName" style="padding-right: 100px;" /></td> 
                        </tr>
                        <tr> 
                            <td>Password</td>
                            <td style="padding-bottom: 10px;"><c:input path = "password" class="beauti" placeholder="Enter Password" type="password" style="padding-right: 100px;" /></td> 
                        </tr>

                        <tr>
                            <td>Photo</td>
                            <td style="border: solid 0.5px rgb(216, 213, 213); border-radius: 7px;"><c:input path = "candiDocPath" type="file"/></td>
                            
                        </tr>

                        <tr>
                            <td></td>
                            <td style="padding-left: 50px;padding-top: 10px;padding-bottom: 10px"><input class="beauti" type="submit" value="Register" style="color: whitesmoke; border-radius: 7px; background-color: red; height: 35px; width: 100px;"></td>
                        </tr>
                    </table>   
                    </c:form>
            </div>
            <div class="col-3">
                
            </div>            
        
     </div>
    
        <footer class="w3-container bg-secondary" style="position:sticky;bottom:0;width:100%;height:80px;background:#6cf;">

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
            </div>
        </footer>
    </div>
</body>
</html>