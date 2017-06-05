<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<title>Inserimento Autore</title>
	
	<!-- Bootstrap core CSS -->
	<spring:url value="/resources/css/bootstrap-min.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet" />
</head>


<body>

	<div class="container">
		<h2>Inserisci Autore</h2>
		<c:url var="url" value="/newAutore" />
		<form:form action="${url}" method="post" modelAttribute="autore"
			class="form-horizontal">

			<div class="form-group">
				<label class="control-label col-sm-2" for="nome">Nome:</label>
				<div class="col-sm-10">
					<form:input path="nome" class="form-control" id="nome"
						placeholder="Inserisci Nome" name="nome" />
					<font color="red"><form:errors path="nome" /></font>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="cognome">Cognome:</label>
				<div class="col-sm-10">
					<form:input path="cognome" class="form-control" id="cognome"
						placeholder="Inserisci Cognome" name="cognome" />
					<font color="red"><form:errors path="cognome" /></font>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="nazionalita">Nazionalità:</label>
				<div class="col-sm-10">
					<form:input path="nazionalita" class="form-control"
						id="nazionalita" placeholder="Inserisci Nazionalita"
						name="nazionalita" />
					<font color="red"><form:errors path="nazionalita" /></font>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="dataDiNascita">Data
					di Nascita:</label>
				<div class="col-sm-10">
					<form:input path="dataDiNascita" class="form-control"
						id="dataDiNascita" placeholder="Inserisci Data di Nascita"
						name="dataDiNascita" />
					<font color="red"><form:errors path="dataDiNascita" /></font>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="dataDiMorte">Data
					di Morte:</label>
				<div class="col-sm-10">
					<form:input path="dataDiMorte" class="form-control"
						id="dataDiMorte" placeholder="Inserisci Data di Morte"
						name="dataDiMorte" />
					<font color="red"><form:errors path="dataDiMorte" /></font>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form:form>
	</div>


</body>
</html>