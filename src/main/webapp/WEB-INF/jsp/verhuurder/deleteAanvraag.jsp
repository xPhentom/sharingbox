<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>Sharingbox WebApp</title>
</head>

<body>
	<h1 style="color: grey; text-align: center;">Aanvraag weigeren</h1>
	<br>
	<br>
	
	<div id="menuBar" style="text-align: center;">
		<c:url var="url" value="/verhuurder/deleteAanvraag.html" />
		<button id="btnAanvraag" type="button" class="btn btn-primary"
			data-toggle="collapse" data-target="#verwijderen">Aanvraag</button>
		<button id="btnBevestig" type="button" class="btn btn-default"
			data-toggle="collapse" data-target="#bevestig">Bevestig</button>
	</div>

	<form:form name="aanvraagForm" action="${url}" role="form" commandName="deaanvraag" style="margin-left:20%;">

		<fieldset id="verwijderen" class="collapse">
			<br> <br>
			<h4>Kies een aanvraag om te verwijderen :</h4>
			<br>
			<form:label id="lblAanvraagID" path="id" hidden="true">test</form:label>

			<c:forEach var="aanvraag" items="${aanvragen}">
				<input type="radio" class="radio" name="id"
					value="${aanvraag.id}" />
				<label>ID: ${aanvraag.id}</label>
				<br>
				<label style="font-weight: normal">Datum: ${aanvraag.datum}</label>
				<br>
				<label style="font-weight: normal">Adres: ${aanvraag.adres}</label>
				<br>
				<label style="font-weight: normal">Klant voornaam:
					${aanvraag.m_Klant.persoon.voornaam}</label>
				<br>
				<label style="font-weight: normal">Klant
					familienaam:${aanvraag.m_Klant.persoon.familienaam}</label>
				<br>
				<br>
			</c:forEach>
		</fieldset>

		<fieldset id="bevestig" class="collapse">
			<br> <br>
			
			<h4>Bent u zeker dat u de aanvraag wilt weigeren ?</h4>
			<button id="btnNext" type="submit" class="btn btn-default">Ja weiger hem !</button>
		</fieldset>
	</form:form>
	<script>
		var chosenAanvraagId;

		document
				.addEventListener(
						"DOMContentLoaded",
						function(event) {
							$("#verwijderen").collapse('show');
						});

		$("input[name=id]")
				.change(
						function() {
							chosenAanvraagId = this.value;
							document.getElementById('lblAanvraagID').innerHTML = chosenAanvraagId;
							$("#verwijderen").collapse('hide');
							document.getElementById("btnAanvraag").className = "btn btn-default";
							document.getElementById("btnBevestig").className = "btn btn-primary";
							$("#bevestig").collapse('show');

						});

		$("#btnAanvraag")
				.click(
						function() {
							$("#bevestig").collapse('hide');
							document.getElementById("btnAanvraag").className = "btn btn-primary";
							document.getElementById("btnBevestig").className = "btn btn-default";
						});

		$("#btnBevestig")
				.click(
						function() {
							$("#verwijderen").collapse('hide');
							document.getElementById("btnAanvraag").className = "btn btn-default";
							document.getElementById("btnBevestig").className = "btn btn-primary";
						});
	</script>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</body>

</html>
