<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD NEW PROVINCE</title>
</head>
<body>
<jsp:include page="ad-nav-bar.jsp"></jsp:include>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="insert" method="post">
					<h3 class="text-center">ADD NEW PROVINCE</h3>
					<fieldset class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							name="name" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Comfirmed</label> <input type="number" class="form-control"
							name="confirmed">
					</fieldset>

					<fieldset class="form-group">
						<label>Undertreatment</label> <input type="number" class="form-control"
							name="undertreatment">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Recovered</label> <input type="number" class="form-control"
							name="recovered">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Deaths</label> <input type="number" class="form-control"
							name="deaths">
					</fieldset>
					
								
					<fieldset class="form-group">
						<label>Date</label> <input type="text" class="form-control"
							name="date">
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