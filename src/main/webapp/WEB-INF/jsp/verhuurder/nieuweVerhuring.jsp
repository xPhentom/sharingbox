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
	<h1 style="color: grey; text-align: center;">Verhuring toevoegen</h1>
	<br>
	<br>
	<div id="menuBar" style="text-align: center;">
		<c:url var="url" value="/verhuurder/nieuweVerhuring.html" />
		<button id="btnAanvraag" type="button" class="btn btn-primary"
			data-toggle="collapse" data-target="#aanvraag">Aanvraag</button>
		<button id="btnSharingbox" type="button" class="btn btn-default"
			data-toggle="collapse" data-target="#sharingbox">Sharingbox</button>
	</div>

	<form:form name="aanvraagForm" action="${url}" role="form"
		commandName="aanvraagToVerhuring" style="margin-left:20%;">

		<fieldset id="aanvraag" class="collapse">
			<br> <br>
			<h4>Kies een aanvraag :</h4>
			<br>
			<form:label id="lblSharingboxID" path="sharingbox_id" hidden="true">test</form:label>
			<form:label id="lblAanvraagID" path="aanvraag_id" hidden="true">test</form:label>

			<c:forEach var="aanvraag" items="${aanvragen}">
				<input type="radio" class="radio" name="aanvraag_id"
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

		<fieldset id="sharingbox" class="collapse">
			<br> <br>
			<h4>Kies een Sharingbox :</h4>

			<br> <select id="CB_Sharingboxen" name="sharingbox_id">
				<c:forEach var="sharingbox" items="${sharingboxen}">
					<option value="${sharingbox.id}">${sharingbox.id}</option>
				</c:forEach>
			</select>
			<h4>Bevestig uw verhuring</h4>
			<button id="btnNext" type="submit" class="btn btn-default">Submit</button>
		</fieldset>
	</form:form>
	
	<script>
		var chosenAanvraagId;
		var chosenSharingboxId;

		document
				.addEventListener(
						"DOMContentLoaded",
						function(event) {
							$("#aanvraag").collapse('show');
							var e = document.getElementById("CB_Sharingboxen");
							chosenSharingboxId = e.options[e.selectedIndex].value;
							document.getElementById('lblSharingboxID').innerHTML = chosenSharingboxId;
						});

		$("input[name=aanvraag_id]")
				.change(
						function() {
							chosenAanvraagId = this.value;
							document.getElementById('lblAanvraagID').innerHTML = chosenAanvraagId;
							$("#aanvraag").collapse('hide');
							document.getElementById("btnAanvraag").className = "btn btn-default";
							document.getElementById("btnSharingbox").className = "btn btn-primary";
							$("#sharingbox").collapse('show');

						});

		$("select[name=CB_Sharingboxen]")
				.change(
						function() {
							chosenSharingboxId = this.value;
							document.getElementById('lblSharingboxID').innerHTML = chosenSharingboxId;
						});

		$("#btnAanvraag")
				.click(
						function() {
							$("#sharingbox").collapse('hide');
							document.getElementById("btnAanvraag").className = "btn btn-primary";
							document.getElementById("btnSharingbox").className = "btn btn-default";
						});

		$("#btnSharingbox")
				.click(
						function() {
							$("#aanvraag").collapse('hide');
							document.getElementById("btnAanvraag").className = "btn btn-default";
							document.getElementById("btnSharingbox").className = "btn btn-primary";
						});
	</script>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</body>

</html>
