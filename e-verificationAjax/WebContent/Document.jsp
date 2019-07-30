<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%
	String docPath=(String)request.getAttribute("docPath");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Document</title>
</head>
<body>
	<div style="display: flex;justify-content: center;align-items: center; height: 70%" >
		<img src="assets/<%= docPath%>"style="height: 85%"></div>
	
	
</body>
</html>