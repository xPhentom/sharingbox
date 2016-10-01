<html>
<head>
<title>test !!</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
</head>
<body>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<script>
		$.ajax({
			type : "POST",
			url : "addPerson",
			data : JSON.stringify({
				name : "Gerry",
				age : 20,
				city : "Sydney"
			}),
			contentType : 'application/json',
			success : function(data) {
				if (data.status == 'OK')
					alert('Person has been added');
				else
					alert('Failed adding person: ' + data.status + ', '
							+ data.errorMessage);
			}
		});
	</script>
</body>
</html>