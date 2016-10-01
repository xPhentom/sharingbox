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

<body>
	<div style="text-align: center;">
		<h1>Aanvraag toevoegen</h1>
	</div>
	<br>
	<br>
	<br>
	<br>
	<c:url var="url" value="/klant/index.html" />
	<form:form action="${url}" commandName="deaanvraag"
		style="margin-left:20%; width: 20%;">
		<%-- Spring form tags --%>
		<fieldset>

			<label style="display: inline-block; width:"> Datum</label>
			<div class='input-group date' id='datetimepicker1'>

				<form:input type='text' class="form-control" path="datum" />
				<font color="red"><form:errors path="datum" /></font> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>

			</div>



			<div>
				<label>Adres:</label><br>
				<form:input class="form-control" path="adres" />
				<font color="red"><form:errors path="adres" /></font>
			</div>
			<br>
			<div>
				<input name="submit" type="submit" value="save"
					class="btn btn-default" />
			</div>
		</fieldset>


	</form:form>
	<c:url var="logoutUrl" value="/logout" />
	<form class="form-inline" action="${logoutUrl}" method="post">
		<input type="submit" value="Log out" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<script type="text/javascript">
		$(function() {

			$('#datetimepicker1').datetimepicker();
		});
	</script>
</body>
</html>
