<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Het Sharingbox team heet u welkom :)</title>
</head>

<body>

	<c:forEach items="${persoon.rollen}" var="rol">
		<c:url var="rolUrl" value="/rol.html">
			<c:param name="id" value="${rol.id}" />
		</c:url>
		<a href='<c:out value="${rolUrl}"/>' hidden="true"> <c:out
				value="${rol.type}" />
		</a>
	</c:forEach>

	</form>
</body>
<script>
	window.location.replace('${rolUrl}');
</script>
</html>
