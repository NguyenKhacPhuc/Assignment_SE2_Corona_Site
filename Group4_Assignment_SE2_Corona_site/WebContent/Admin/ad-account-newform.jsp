<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD NEW ADMIN</title>
</head>
<body>
<body>
<jsp:include page="ad-nav-bar.jsp"></jsp:include>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="insert" method="post">
					<h3 class="text-center">ADD NEW ADMIN</h3>
					<fieldset class="form-group">
						<label>Username</label> <input type="text" class="form-control"
							name="username" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Password</label> <input type="text" class="form-control"
							name="password">
					</fieldset>

					<fieldset class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							name="email">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Age</label> <input type="number" class="form-control"
							name="age">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Date of birth</label> <input type="text" class="form-control"
							name="dob">
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