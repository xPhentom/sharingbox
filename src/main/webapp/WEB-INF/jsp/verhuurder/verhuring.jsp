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
	<div style="margin-left: 20px;">
		<h1>Details van verhuring</h1>
		<br>
		<h4>
			<b>Id: </b>
			<c:out value="${verhuring.id}" />
		</h4>
		<h4>
			<b>Datum:</b>
			<c:out value="${aanvraag.datum}" />
		</h4>

		<h4>
			<b>Leveringsadres:</b>
			<c:out value="${aanvraag.adres}" />
		</h4>
		<h4>
			<b>Sharingbox_ID:</b>
			<c:out value="${verhuring.sharingbox_id}" />
		</h4>
		<h4>
			<b>Status:</b>
			<c:out value="${verhuring.status}" />
		</h4>
		<h4>
			<b>Tevredenheidsscore:</b>
			<c:out value="${verhuring.tevredenheidsscore}" />
		</h4>
		<br /> <br />

	</div>
	<ul>


<%-- 		<li><c:url var="deleteVerhuringUrl" value="/Verhuring/delete.html" /> <a --%>
<%-- 			href='<c:out value="${deleteVerhuringUrl}?id=${verhuring.id}"/>'>Verhuring --%>
<!-- 				verwijderen</a></li> -->
<%-- 		<li><c:url var="updateVerhuringUrl" value="/Verhuring/updateVerhuring.html" /> --%>
<%-- 			<a href='<c:out value="${updateVerhuringUrl}?id=${verhuring.id}"/>'>Verhuring --%>
<!-- 				wijzigen</a></li> -->
<!-- 		<br /> -->
		<li style="list-style-type: none;"><c:url var="home"
				value="/verhuurder/home.html" /> <a href='<c:out value="${home}"/>'
			class="btn btn-info btn-lg"> <span
				class="glyphicon glyphicon-home"></span> Home
		</a></li>


	</ul>

</body>
</html>
