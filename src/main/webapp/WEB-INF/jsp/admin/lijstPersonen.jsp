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

<body>
	<h1>Lijst van de personen</h1>
	<ul>
		<c:forEach items="${personen}" var="persoon">
			<c:url var="persoonUrl" value="persoon.html">
				<c:param name="id" value="${persoon.id}" />
			</c:url>
			<li><a href='<c:out value="${persoonUrl}"/>'> <c:out
						value="${persoon.voornaam}" /> <c:out
						value="${persoon.familienaam}" />
			</a></li>
		</c:forEach>
	</ul>
	<c:url var="nieuwePersoonUrl" value="nieuwePersoon.html" />
	<a href='<c:out value="${nieuwePersoonUrl}"/>'>Persoon Toevoegen</a>
	<br />
	<br />
	<c:url var="logoutUrl" value="/logout" />
	<form class="form-inline" action="${logoutUrl}" method="post">
		<input type="submit" value="Log out" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>
