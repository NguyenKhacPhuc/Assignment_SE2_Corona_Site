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
			<h3 class="text-center">VietNam Provinces Statistic</h3>
            <br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Province</th>
						<th>Confirmed Patient</th>
						<th>Under Treatment Patient</th>
						<th>Recovered Patient</th>
						<th>Deaths</th>
						<th>Date</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				    <%-- c:forEach => basic iteration tag --%>
					<c:forEach var="VietNamProvince" items="${listVietNamProvinces}">
						<tr>
						    <%-- c:out => for expressions --%>
							<td><c:out value="${VietNamProvince.name}" /></td>
							<td><c:out value="${VietNamProvince.confirmed}" /></td>
							<td><c:out value="${VietNamProvince.underTreatment}" /></td>
							<td><c:out value="${VietNamProvince.recovered}" /></td>
							<td><c:out value="${VietNamProvince.deaths}" /></td>
							<td><c:out value="${VietNamProvince.date}" /></td>
							<td><a href="#">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="#">Delete</a></td>
					</c:forEach>
				</tbody>
			</table>
		</div>
		