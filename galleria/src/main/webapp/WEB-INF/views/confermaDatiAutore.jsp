<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<div>
		<h3>Hai inserito:</h3>
	</div>
	<div>
		Nome: <c:out value="${autore.nome}" />
	</div>
	<div>
		Cognome: <c:out value="${autore.cognome}" />
	</div>
	<div>
		Nazionalità: <c:out value="${autore.nazionalita}"/>
	</div>
	<div>
		Data di Nascita: <c:out value="${autore.dataDiNascita}"/>
	</div>
	<div>
		Data di Morte: <c:out value="${autore.dataDiMorte}"/>
	</div>
	<div>
		<input type="button" value="conferma">
	</div>
</body>
</html>