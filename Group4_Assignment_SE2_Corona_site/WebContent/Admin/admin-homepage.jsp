<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Include the JSTL Core library in JSP --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COVID-19</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<jsp:include page="ad-nav-bar.jsp"></jsp:include>
<div class="container">
		    <br>
			<h3 class="text-center">COVID-19 Statistic</h3>
            <br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Country</th>
						<th>New Confirmed</th>
						<th>Total Confirmed</th>
						<th>New Death</th>
						<th>Total Deaths</th>
						<th>New Recovered</th>
						<th>Total Recovered</th>
						<th>Date</th>
						<th>Country Code</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				    <%-- c:forEach => basic iteration tag --%>
					<c:forEach var="Country" items="${listCountries}">
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
							<td><a href="#">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="#">Delete</a></td>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
</body>
</html>