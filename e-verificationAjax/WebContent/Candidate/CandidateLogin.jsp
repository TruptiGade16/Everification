<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="c" %>  
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "x" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-everification</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
</head>
<body class="">

    <div class="container-fluid">
     <div class="row bg-primary" style="position:sticky;top:0; z-index:100;height:70px">
     
            <div class="col-12 text-light d-flex justify-content-between align-items-center">
                <div class="pl-md-5" style="font-size: 30px;font-weight: bold;font-family: 'Times New Roman', Times, serif;">E-Verification </div>
                <div><a class="text-light" href="HomePage.jsp">Home</a></div>
            </div>
     </div>
     <div class="row " style=""><div class="col-12">
     <div class="row" style="height: 200px; padding-top: 70px; padding-bottom: 5px">
            <div class="col-3">
				 
				 <%-- <c:input path="error" />   --%>
            </div>
            <div class="col-5" style="border: solid 2px black; border-radius: 10px; ">
                    <h3 style="text-align: center">Login</h3>
                   
                    <c:form action="candiLogin.htm" commandName="candi" style="font-weight: bold; margin-left: 80px;">
                        <table>
                        <tr> 
                            <td>User Name</td>
                            <td style="padding-bottom: 10px;"><c:input path="candiUserName" class="beauti" placeholder="Enter User Name" style="padding-right: 100px;" /></td>
                        </tr>

                       
                        <tr>
                            <td>Password</td>
                            <td style="padding-bottom: 10px;"><c:input path = "password" type="password" class="beauti"  placeholder="Enter Password" style="padding-right: 100px;"/></td>
                        </tr>
                        <tr>
                            <td ></td>
                            <td style="padding-bottom: 10px;padding-left: 30px">
                                <input class="beauti"  type="submit" value="Login" style="color: whitesmoke; border-radius: 7px; background-color: red; height: 35px; width: 100px;">
                                <input class="beauti" type="submit" value="SignUp" formaction="prep_candiReg_form.htm"style="color: whitesmoke; border-radius: 7px; background-color: red; height: 35px; width: 100px;">
                            </td>
                        </tr>
                        <tr>
                        
                         </c:form>
            <div class="text-danger ml-5"><x:out value="${error}"/></div>
            </div>
                        </tr>
                  </table>   
                   
            <div class="col-4">
               
            </div>            
        
     </div>
    </div></div>
<!--         <footer class="w3-container bg-secondary" style="bottom:0;width:100%;height:80px;background:#6cf;">

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
        </footer> -->
    </div>
</body>
</html>