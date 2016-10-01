<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Het Sharingbox team heet u welkom :)</title>
</head>

<body>
	<h1>Bedankt voor uw aanvraag !</h1>
	<div>
		Wij hebben uw aanvraag voor <b><c:out value="${deaanvraag.datum}" />
		</b> op volgend adres : <b><c:out value="${deaanvraag.adres}" /></b> goed
		ontvangen.<br> Uw aanvraag is in behandeling en wij zullen u
		spoedig contacteren.
	</div>
	<br>
	<c:url var="home" value="/klant/home.html" />
	<a href='<c:out value="${home}"/>'>Go to Home</a>
</body>
</html>
