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
<%@include file="flows-navbar.jsp"%>
<!--Page Content-->