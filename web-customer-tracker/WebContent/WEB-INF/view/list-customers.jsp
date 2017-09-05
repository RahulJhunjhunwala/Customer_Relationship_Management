<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List Customers</title>
		
		<!-- reference our style sheet -->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<!-- put new button: Add Customer -->
				<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button" />
				
				<!-- add out html table here -->
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<!-- loop over and print our customers -->
					<core:forEach var="tempCustomer" items="${customers}">
						<!-- construct an "update" link with customer id -->
						<core:url var="updateLink" value="/customer/showFormForUpdate">
							<core:param name="customerId" value="${tempCustomer.id}" />
						</core:url>
						<tr>
							<td> ${tempCustomer.firstName} </td>
							<td> ${tempCustomer.lastName} </td>
							<td> ${tempCustomer.email} </td>
							<td>
								<!-- display the update link -->
								<a href="${updateLink}">Update</a>
							</td>
						</tr>
					</core:forEach>
				</table>
			</div>
		</div>
	</body>
</html>