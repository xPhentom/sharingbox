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
	<c:url var="url" value="/installateur/installatie.html" />
	<!-- Installaties -->

	<form:form name="installaties" action="${url}" role="form"
		commandName="deinstallatie">

		<h1 style="color: grey; text-align: center;">Overzicht van
			installaties</h1>
		<br>


		<table border="1" class="table table-hover" name="tableInstallaties"
			style="margin-right: 20px; margin-left: 20px;">

			<tr>
				<td><b>ID</b></td>
				<td><b>Status</b></td>
				<td><b>Datum</b></td>
				<td><b>Adres</b></td>
			</tr>


			<c:forEach items="${installaties}" var="installatie">
				<tr>
					<td><form:label value="${installatie.id}" path="id" /></td>
					<td><c:out value="${installatie.status}" /></td>
					<td><c:out value="${installatie.datum}" /></td>
					<td><c:out value="${installatie.adres}" /></td>
					<td><button type="submit" class="btn btn-default" name="id"
							value="${installatie.id}">Afronden</button></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
	<c:url var="urlAfbraak" value="/installateur/afbraak.html" />
	<form:form name="afbraken" action="${urlAfbraak}" role="form"
		commandName="deafbraak">
		<h1 style="color: grey; text-align: center;">Overzicht van
			afbraken</h1>
		<br>


		<table border="1" class="table table-hover" name="tableAfbraken"
			style="margin-right: 20px; margin-left: 20px;">
			<tr>
				<td><b>ID</b></td>
				<td><b>Status</b></td>
				<td><b>Datum</b></td>
				<td><b>Adres</b></td>
			</tr>

			<c:forEach items="${afbraken}" var="afbraak">
				<tr>

					<td><form:label value="${afbraak.id}" path="id" /></td>
					<td><c:out value="${afbraak.status}" /></td>
					<td><c:out value="${afbraak.datum}" /></td>
					<td><c:out value="${afbraak.adres}" /></td>
					<td><button type="submit" class="btn btn-default" name="id"
							value="${afbraak.id}">Afronden</button></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
	
	<c:url var="logoutUrl" value="/logout" />
	<form class="form-inline" action="${logoutUrl}" method="post">
		<input type="submit" value="Log out" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
</body>
</html>
