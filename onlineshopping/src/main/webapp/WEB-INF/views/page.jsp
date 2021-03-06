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
  <meta name="_csrf" content="${_csrf.token}">
  <meta name="_csrf_header" content="${_csrf.headerName}">
  <link href="${css}/bootstrap.min.css" rel="stylesheet" >
  <link href="${css}/dataTables.bootstrap.css" rel="stylesheet" >
  <link href="${css}/myapp.css" rel="stylesheet">
  </head>
<body>
<!-- Side Navbar-->
<div id="mySidenav" class="sidenav">
<%@include file="./shared/sidenav.jsp" %>
</div>
<!--Navbar  -->
<div class="wrapper">
<%@include file="./shared/navbar.jsp"%>
</div>
<!--Page Content-->
<div class="content">
			<!--Loading the home content  -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>
			<!--Load only when user clicks contact  -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			<!--Load only when user clicks about  -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>
			
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			<!-- Load only when user click show product -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			<!-- Load only when user click manage products -->
			<c:if test="${userClickManageProducts == true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			<!-- Load only when user clicks cart -->
			<c:if test="${userClickShowCart == true}">
				<%@include file="cart.jsp"%>
			</c:if>
		</div>
		<script src="${js}/jquery.js"></script>
		<script type="text/javascript" src="${js}/jquery.validate.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<script type="text/javascript" src="${js}/jquery.dataTables.js"></script>
<script type="text/javascript" src="${js}/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="${js}/bootbox.min.js"></script>

<script src="${js }/myapp.js"></script>
</body>
</html>