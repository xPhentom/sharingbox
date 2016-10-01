<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Sharingbox WebApp</title>
</head>

<body>
	<h1 style="color:grey;text-align:center;">Verhuring aanpassen</h1>
	<div>
	<c:url var="url" value="/verhuurder/updateVerhuring.html" />
	<form:form action="${url}" commandName="verhuring" style="margin-left:20px; margin-right:20px; ">
		<%-- Spring form tags --%>
		<fieldset>

			<label>ID:</label>
			<form:input path="id" readonly="true" class="form-control" />
			<br> <label>Datum:</label>
			<form:input path="datum" class="form-control" />
			<br> <label>Leveringsadres:</label>
			<form:input path="leveringsadres" class="form-control" />
			<br> <label>Sharingbox_id:</label>
			<form:input path="sharingbox_id" class="form-control" />
			<br> <label>Status:</label>
			<form:input path="status" class="form-control" />
			<br> <label>Tevredenheisscore:</label>
			<form:input path="tevredenheidsscore" class="form-control" />
			<br> <input name="submit" type="submit" value="save"
				class="btn btn-default" />

		</fieldset>
	</form:form>
</body>
</html>
