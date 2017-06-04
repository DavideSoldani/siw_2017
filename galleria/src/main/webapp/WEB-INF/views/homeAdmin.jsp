<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<div>
			<h4>
				Welcome : ${pageContext.request.userPrincipal.name} |
				<c:url value="/logout" var="logoutUrl" />
				<a href="${logoutUrl}">Log Out</a>
			</h4>
		</div>
		<div>
			<form action="admin/formAutore" method="post">
				<input type="submit" value="Aggiungi autore"/>
			</form>
		</div>
		<div>
			<a href="">Inserisci una nuova Opera</a>
		</div>
	</c:if>
</body>
</html>