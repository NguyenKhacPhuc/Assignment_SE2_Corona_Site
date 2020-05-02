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
			<h3 class="text-center">Each Day in VietNam Statistic</h3>
            <br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Date</th>
						<th>Cases</th>
						<th>Recovered Patient</th>
						<th>Deaths</th>
					</tr>
				</thead>
				<tbody>
				    <%-- c:forEach => basic iteration tag --%>
					<c:forEach var="EachDay" items="${listEachDay}">
						<tr>
						    <%-- c:out => for expressions --%>
							<td><c:out value="${EachDay.date}" /></td>
							<td><c:out value="${EachDay.cases}" /></td>
							<td><c:out value="${EachDay.recovered}" /></td>
							<td><c:out value="${EachDay.deaths}" /></td>
					</c:forEach>
				</tbody>
			</table>
		</div>
		