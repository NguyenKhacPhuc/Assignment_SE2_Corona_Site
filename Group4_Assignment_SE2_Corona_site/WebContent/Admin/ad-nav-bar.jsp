<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Navigation Bar</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  
  <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
	<style>
body {
  overflow-x: hidden;
}

#sidebar-wrapper {
  min-height: 100vh;
  margin-left: -15rem;
  -webkit-transition: margin .25s ease-out;
  -moz-transition: margin .25s ease-out;
  -o-transition: margin .25s ease-out;
  transition: margin .25s ease-out;
}

#sidebar-wrapper .sidebar-heading {
  padding: 0.875rem 1.25rem;
  font-size: 1.2rem;
}

#sidebar-wrapper .list-group {
  width: 15rem;
}

#page-content-wrapper {
  min-width: 100vw;
}

#wrapper.toggled #sidebar-wrapper {
  margin-left: 0;
}

@media (min-width: 768px) {
  #sidebar-wrapper {
    margin-left: 0;
  }

  #page-content-wrapper {
    min-width: 0;
    width: 100%;
  }

  #wrapper.toggled #sidebar-wrapper {
    margin-left: -15rem;
  }
}
</style>
</head>

<body>



  <div class="d-flex" id="wrapper">

    
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading">COVID-19 Analize</div>
      <div class="list-group list-group-flush">
        <a href="#" class="list-group-item list-group-item-action bg-light">Homepage</a>
        <a href="<%=request.getContextPath()%>/world" class="list-group-item list-group-item-action bg-light">World Statistic</a>
        <a href="<%=request.getContextPath()%>/vietnam" class="list-group-item list-group-item-action bg-light">Vietnam Statistic</a>
        <a href="<%=request.getContextPath()%>/vietnamprovince" class="list-group-item list-group-item-action bg-light">Vietnam's Provinces</a>
        
        <a href="<%=request.getContextPath()%>/manageaccount" class="list-group-item list-group-item-action bg-light">Manage account</a>
        <a href="#" class="list-group-item list-group-item-action bg-light">Log out</a>
      </div>
    </div>
   
</body>
</html>