<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>

<title>Het Sharingbox team heet u welkom :)</title>
</head>

<body style="margin-left:5%">
	<h1>Details van persoon</h1>
	<b>Id:</b>
	<c:out value="${persoon.id}" />
	<br />
	<b>Voornaam:</b>
	<c:out value="${persoon.voornaam}" />
	<br />
	<b>Familienaam:</b>
	<c:out value="${persoon.familienaam}" />
	<br />
	<b>E-mailadres:</b>
	<c:out value="${persoon.emailadres}" />
	<br />
	<b>Paswoord:</b>
	<c:out value="${persoon.paswoord}" />
	<br />
	<br />
	<c:url var="home" value="/admin/home.html" />
	<a href='<c:out value="${home}"/>'>Home</a>
</body>
</html>
