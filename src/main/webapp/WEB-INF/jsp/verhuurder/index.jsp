<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	<h1 style="color: grey; text-align: center;">Overzicht van
		verhuringen</h1>
	<br>

	<table border="1" class="table table-hover" name="tableVerhuringen"
		style="margin-right: 20px; margin-left: 20px;">

		<th>
		<tr>
			<td>ID</td>
			<td>Datum</td>
			<td>Leveringsadres</td>
			<td>Sharingbox ID</td>
			<td>Status</td>
			<td>Tevredenheidsscore</td>
		</tr>

		</th>


		<c:forEach items="${verhuringen}" var="verhuring">

			<c:url var="verhuringUrl" value="/verhuurder/verhuring.html">
				<c:param name="id" value="${verhuring.id}" />
			</c:url>



			<tr>

				<td><a href='<c:out value="${verhuringUrl}"/>'> <c:out
							value="${verhuring.id}" />
				</a></td>

				<td><c:out value="${aanvraag.datum}" /></td>
				<td><c:out value="${aanvraag.adres}" /></td>
				<td><c:out value="${verhuring.sharingbox_id}" /></td>
				<td><c:out value="${verhuring.status}" /></td>
				<td><c:out value="${verhuring.tevredenheidsscore}" /></td>

			</tr>

		</c:forEach>
	</table>

	<c:url var="nieuweVerhuringUrl"
		value="/verhuurder/nieuweVerhuring.html" />
	<a href='<c:out value="${nieuweVerhuringUrl}"/>'
		style="margin-left: 20px">Verhuring Toevoegen</a>
	<c:url var="deleteAanvraagUrl" value="/verhuurder/deleteAanvraag.html" />
	<a href='<c:out value="${deleteAanvraagUrl}"/>'
		style="margin-left: 20px">Aanvraag Weigeren</a>
		
		<br><br>
	<c:url var="logoutUrl" value="/logout" />
	<form class="form-inline" action="${logoutUrl}" method="post">
		<input type="submit" value="Log out" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<br>
	<br>
	<br>
	<br>
</body>
</html>
