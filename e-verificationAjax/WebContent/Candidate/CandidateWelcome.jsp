<%@page import="com.cdac.everification.model.DocumentMaster"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x"%>

<%@ page import="com.cdac.everification.model.Candidate"%>
<%@ page import="com.cdac.everification.model.CandiDocs"%>
<%
	Candidate candi = (Candidate) session.getAttribute("candi");
	List<DocumentMaster> ul = (List<DocumentMaster>) request.getAttribute("list");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home-everification</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="beautify.css">
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

		<div class="row" style="height: 498px;">
			<div class="col-2"></div>
			<div class="col-8"
				 style="border: solid 2px black; border-radius: 10px;display: flex;justify-content: center;align-items: center;">
				 
				 <c:form action="upload_doc.htm"  enctype="multipart/form-data" >
				 <div class="center" style="height: 200px;display: flex;justify-content: center;align-items: center;">
					<img id="imgId" src="assets/profilePic/<%=candi.getCandiDocPath() %>" alt="Candidate image" width="200"
						height="150" style="border-radius: 75px">
				</div>
				 <div class="center" style="height: 100px;">
						<h1>
							Welcome
							<%=candi.getCandiFname()%>
						</h1>
						<b>Upload Document</b>
						<br /> <input type="hidden" name="id"
							value=" <%=candi.getCandiId()%>" />
							<input type="hidden" name="name"
							value=" <%=candi.getCandiFname()%>" />
					</div>
					<div class="center" style="height: 50px;">
						<select name="docId">
							<x:forEach items="${list}" var="doc">
								<option value="${doc.docId}"><x:out
										value="${doc.docType}" /></option>
							</x:forEach>
						<select>


					</div>
					<div class="center" style="height: 50px;">
						<input type="file"
							style="border: solid 0.5px rgb(216, 213, 213)" name="file" />
						<input type="submit" value="Upload"
							style="border: solid 0.5px red; color: whitesmoke; border-radius: 7px; background-color: red; height: 35px; width: 100px;">
					</div>
					 
			
					<div class="center" style="height: 50px;">
						<input formaction="candi_doc_list.htm" type="submit" value="Document List"
							style="border: solid 0.5px red; color: whitesmoke; border-radius: 7px; padding-left: 10px; background-color: red; height: 35px; width: 200px;">
					</div>
				</c:form>
				
			<div class="col-2"></div>

		</div>
	</div>
</body>
</html>