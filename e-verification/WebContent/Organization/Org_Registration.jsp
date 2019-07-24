<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>   
    
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
     
     <div class="row" style="height: 498px; padding-top: 5px; padding-bottom: 5px">
            <div class="col-2">

            </div>
            <div class="col-8" style="border: solid 2px black; border-radius: 10px; ">
                    <h3 style="text-align: center">Organization Registration</h3>
                   
                    <spr:form action="orgReg.htm" commandName="org" style="font-weight: bold; margin-left: 230px;">
                        <table>
                        <tr> 
                            <td>Name</td>
                            <td style="padding-bottom: 10px;">
                            	<spr:input path="orgName" placeholder="Enter Name" style="padding-right: 100px;,l" ></spr:input>
                            </td> 
                        </tr>

                        
                        <tr >
                            <td>Email</td>
                            <td style="padding-bottom: 10px;">
                            	<spr:input path="email" placeholder="Enter Email" style="padding-right: 100px; "/>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>Phone</td>
                            <td style="padding-bottom: 10px;">
                            	<spr:input path="phone" placeholder="Enter phone" style="padding-right: 100px;"/>
                            </td>
                        </tr>

                        <tr>
                            <td>City</td>
                            <td style="padding-bottom: 10px;">
                            	<spr:input path="city" placeholder="Enter City" style="padding-right: 100px;"/>
                            </td>
                        </tr>

                        <tr>
                            <td>State</td>
                            <td style="padding-bottom: 10px;">
                            	<spr:input path="state" placeholder="Enter State" style="padding-right: 100px;"/>
                            </td>
                        </tr>

                        <tr>
                            <td>Username</td>
                            <td style="padding-bottom: 10px;">
                            	<spr:input path="userName" placeholder="Enter Username" style="padding-right: 100px;"/>
                            </td>
                        </tr>

                        <tr>
                            <td>Password</td>
                            <td style="padding-bottom: 10px;">
                            	<spr:password path="password" placeholder="Enter Password" style="padding-right: 100px;"/>
                            </td>
                        </tr>

                        <tr>
                            <td>Document</td>
                            <td style="border: solid 0.5px rgb(216,213,213)">
                            	<spr:input path="docPath" type="file" name="picture" style="border-radius: 5px;" accept="image/*"/>
                            </td>
                        </tr>

                        <tr>
                            <td></td>
                            <td style="padding-bottom: 10px; padding-left: 55px;  "><input type="submit" value="Register" style="border: solid 0.5px red; color: whitesmoke; border-radius: 7px; background-color: red; height: 35px; width: 100px;"></td>

                        </tr>
                        </table>   
                    </spr:form>
            </div>
            <div class="col-2">
                
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
         </footer>
      </div>
</body>
</html>