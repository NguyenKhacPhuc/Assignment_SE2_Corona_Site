<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD NEW COUNTRY</title>
</head>
<body>
<jsp:include page="ad-nav-bar.jsp"></jsp:include>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="insert" method="post">
					<h3 class="text-center">ADD NEW COUNTRY</h3>
					<fieldset class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							name="country" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>New Confirmed</label> <input type="number" class="form-control"
							name="newComfirmed">
					</fieldset>

					<fieldset class="form-group">
						<label>Total Confirmed</label> <input type="number" class="form-control"
							name="totalComfirmed">
					</fieldset>
					
					<fieldset class="form-group">
						<label>New Deaths</label> <input type="number" class="form-control"
							name="newDeaths">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Total Deaths</label> <input type="number" class="form-control"
							name="totalDeaths">
					</fieldset>
					
					<fieldset class="form-group">
						<label>New Recovered</label> <input type="number" class="form-control"
							name="newRecovered">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Total Recovered</label> <input type="number" class="form-control"
							name="totalRecovered">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Date</label> <input type="text" class="form-control"
							name="date">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Country Code</label> <input type="text" class="form-control"
							name="countryCode">
					</fieldset>

					<div class="col text-center">
						<button type="submit" class="btn btn-success">ADD</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>