<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online Shopping-${title}</title>
  <script>
	window.menu = '${title}';
	window.contextRoot='${contextRoot}';
</script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="${css}/bootstrap.min.css" rel="stylesheet" >
  <link href="${css}/dataTables.bootstrap.css" rel="stylesheet" >
  <link href="${css}/myapp.css" rel="stylesheet">
  </head>
<body>

<!--Navbar  -->
<nav class="navbar navbar-inverse" role="navigation">
<div class="container">
<div class="navbar-header">
<a class="navbar-brand text-center" href="${contextRoot}/home">TechAtHome</a>
</div>
</div>
</nav>
<!--Page Content-->
<div class="content">
<div class="container">
<!-- this will be displayed if the credentials are wrong -->
<c:if test="${not empty message }">
<div class="row">
<div class="col-md-offset-3 col-md-6">
<div class="alert alert-danger">${message}</div>
</div>
</div>
</c:if>
<!-- this will be displayed when user logout -->
<c:if test="${not empty logout }">
<div class="row">
<div class="col-md-offset-3 col-md-6">
<div class="alert alert-success">${logout}</div>
</div>
</div>
</c:if>
<div class="row">
<div class="col-md-offset-3 col-md-6">
<div class="panel panel-primary">
<div class="panel-heading">
<h4>Login</h4>
</div>
<div class="panel-body">
<form action="" method="POST" class="form-horizontal" id="loginForm">
<div class="form-group">
<label class="control-label col-md-4" for="username">Email:</label>
<div class="col-md-8">
<input type="text" name="username" id="name" class="form-control" />
<!-- <errors path="name" cssClass="help" element="em" /> -->
</div>
</div>
<div class="form-group">
<label class="control-label col-md-4" for="password">Password:</label>
<div class="col-md-8">
<input type="password" name="password" id="password" class="form-control" />
<!-- <errors path="name" cssClass="help" element="em" /> -->
</div>
</div>
<div class="form-group">
<div class="col-md-offset-4 col-md-8">
<input type="submit" value="Login" class="btn btn-primary" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</div>
</div>
</form>
</div>
<div class="panel-footer">
<div class="text-right">New User-<a href="${contextRoot}/register">Register Here</a></div>
</div>
</div>
</div>
</div>
</div>
		</div>
		<script src="${js}/jquery.js"></script>
		<script type="text/javascript" src="${js}/jquery.validate.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<script src="${js }/myapp.js"></script>
</body>
</html>
