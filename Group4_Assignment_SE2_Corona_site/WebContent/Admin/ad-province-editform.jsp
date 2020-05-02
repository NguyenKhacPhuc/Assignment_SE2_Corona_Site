<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Vietnam Provinces Statistic</title>
</head>
<body>
	<jsp:include page="ad-nav-bar.jsp"></jsp:include>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="update" method="post">
					<h3 class="text-center">UPDATE VIETNAM PROVINCE STATISTIC</h3>
					<input type="hidden" name="id" value="<c:out value='${province.id}' />" >

					<fieldset class="form-group">
						<label>Name</label> <input type="text"
							value="<c:out value='${province.name}' />" class="form-control"
							name="name" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Undertreatment</label> <input type="text"
							value="<c:out value='${province.undertreatment}' />" class="form-control"
							name="address">
					</fieldset>

					<fieldset class="form-group">
						<label>Recovered</label> <input type="text"
							value="<c:out value='${province.recovered}' />" class="form-control"
							name="mobile">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Deaths</label> <input type="text"
							value="<c:out value='${province.deaths}' />" class="form-control"
							name="mobile">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Date</label> <input type="text"
							value="<c:out value='${province.date}' />" class="form-control"
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