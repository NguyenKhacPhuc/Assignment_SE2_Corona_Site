<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Countries Statistic</title>
</head>
<body>
	<jsp:include page="ad-nav-bar.jsp"></jsp:include>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="update" method="post">
					<h3 class="text-center">UPDATE COUNTRIES STATISTIC</h3>
					<input>

					<fieldset class="form-group">
						<label>Name</label> <input type="text"
							value="<c:out value='${country.country}' />" class="form-control"
							name="name" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>New Confirmed</label> <input type="text"
							value="<c:out value='${country.newConfirmed}' />" class="form-control"
							name="address">
					</fieldset>

					<fieldset class="form-group">
						<label>Total Confirmed</label> <input type="text"
							value="<c:out value='${country.totalConfirmed}' />" class="form-control"
							name="mobile">
					</fieldset>
					
					<fieldset class="form-group">
						<label>New Deaths</label> <input type="text"
							value="<c:out value='${country.newDeaths}' />" class="form-control"
							name="mobile">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Total Deaths</label> <input type="text"
							value="<c:out value='${country.totalDeaths}' />" class="form-control"
							name="mobile">
					</fieldset>
					
					
					<fieldset class="form-group">
						<label>New Recovered</label> <input type="text"
							value="<c:out value='${country.newRecovered}' />" class="form-control"
							name="mobile">
					</fieldset>
					
										
					<fieldset class="form-group">
						<label>Total Recovered</label> <input type="text"
							value="<c:out value='${country.totalRecovered}' />" class="form-control"
							name="mobile">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Date</label> <input type="text"
							value="<c:out value='${country.date}' />" class="form-control"
							name="mobile">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Country Code</label> <input type="text"
							value="<c:out value='${country.countryCode}' />" class="form-control"
							name="mobile">
					</fieldset>
					<div class="col text-center">
						<button type="submit" class="btn btn-success">UPDATE</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>