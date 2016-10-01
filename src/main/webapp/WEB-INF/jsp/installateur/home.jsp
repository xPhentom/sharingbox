<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Homepage</title>
</head>
<body>

<h1><c:out value="${boodschap}" /></h1> 
	<p>
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}" />
	</p>
	
	<c:url var="gaNaarLijstUrl" value="/installateur/index.html" />
    <a href='<c:out value="${gaNaarLijstUrl}"/>'>Ga naar lijst</a>
	
</body>
</html>