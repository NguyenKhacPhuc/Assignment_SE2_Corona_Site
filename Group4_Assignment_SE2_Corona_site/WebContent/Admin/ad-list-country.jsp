<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Include the JSTL Core library in JSP --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COVID-19 Analize</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
<jsp:include page="ad-nav-bar.jsp"></jsp:include>
<div class="container">
		    <br>
			<h3 class="text-center">The Countries Statistic</h3>
            <br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Country</th>
						<th>New Confirmed Patient</th>
						<th>Total Confirmed Patient</th>
						<th>New Deaths</th>
						<th>Total Deaths</th>
						<th>New Recovered Patient</th>
						<th>Total Recovered Patient</th>
						<th>Date</th>
						<th>Country Code</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				    <%-- c:forEach => basic iteration tag --%>
					<c:forEach var="Country" items="${listCountry}">
						<tr>
						    <%-- c:out => for expressions --%>
							<td><c:out value="${Country.country}" /></td>
							<td><c:out value="${Country.newConfirmed}" /></td>
							<td><c:out value="${Country.totalConfirmed}" /></td>
							<td><c:out value="${Country.newDeaths}" /></td>
							<td><c:out value="${Country.totalDeaths}" /></td>
							<td><c:out value="${Country.newRecovered}" /></td>
							<td><c:out value="${Country.totalRecovered}" /></td>
							<td><c:out value="${Country.date}" /></td>
							<td><c:out value="${Country.countryCode}" /></td>	
							<td><a href="#" >Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="#">Delete</a></td>
					</c:forEach>
				</tbody>
			</table>
		</div>	
</body>
</html>
