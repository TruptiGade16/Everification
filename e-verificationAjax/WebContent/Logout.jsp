<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="obj" class="com.cdac.everification.model.Candidate" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>

</head>
<body>
	<%
	/* response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
 */
	 response.sendRedirect("HomePage.jsp");
	%>

	<h1>
		<font color="Red">You are Sucessfully logged out...</font>
	</h1>

	<a href="HomePage.jsp">Go-Back To Home Page</a>
</body>
</html>