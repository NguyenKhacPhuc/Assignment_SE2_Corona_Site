<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Include the JSTL Core library in JSP --%>
<jsp:include page="user-nav-bar.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Covid-19</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
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
					</tr>
				</thead>
				<tbody>
				    <%-- c:forEach => basic iteration tag --%>
					<c:forEach var="VietNamProvince" items="${listProvinces}">
						<tr>
						    <%-- c:out => for expressions --%>
							<td><c:out value="${VietNamProvince.name}" /></td>
							<td><c:out value="${VietNamProvince.confirmed}" /></td>
							<td><c:out value="${VietNamProvince.undertreatment}" /></td>
							<td><c:out value="${VietNamProvince.recovered}" /></td>
							<td><c:out value="${VietNamProvince.deaths}" /></td>
							<td><c:out value="${VietNamProvince.date}" /></td>
					</c:forEach>
				</tbody>
			</table>
		</div>
		