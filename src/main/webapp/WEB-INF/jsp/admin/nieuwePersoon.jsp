<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

<body style="margin-left: 5%">
	<h1>Persoon toevoegen</h1>
	<c:url var="url" value="/admin/nieuwePersoon.html" />
	<div class="form-group">
		<form:form action="${url}" commandName="depersoon">
			<%-- Spring form tags --%>
			<fieldset>
				<div>
					<label>Voornaam:</label>
					<form:input path="voornaam" />
					<font color="red"><form:errors path="voornaam" /></font>
				</div>
				<div>
					<label>Familienaam:</label>
					<form:input path="familienaam" />
					<font color="red"><form:errors path="familienaam" /></font>
				</div>
				<div>
					<label>E-mailadres:</label>
					<form:input path="emailadres" />
					<font color="red"><form:errors path="emailadres" /></font>
				</div>
				<div>
					<label>Paswoord:</label>
					<form:input path="paswoord" />
					<font color="red"><form:errors path="paswoord" /></font>
				</div>
				<br>
				<div>
					<input name="submit" type="submit" value="Save" />
				</div>
			</fieldset>
		</form:form>

		<c:url var="home" value="/admin/home.html" />
		<a href='<c:out value="${home}"/>'>Home</a>

	</div>
</body>
</html>
