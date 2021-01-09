<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/estilos.css " />
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de cliente</h1>
	<table border="1">
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Email</th>
			<th>Modificar</th>
		</tr>

		<c:forEach var="clienteTemp" items="${clientes}">
			<c:url var="linkActualizar"
				value="/cliente/muestraFormularioActualizar">
				<c:param name="clienteId" value="${clienteTemp.id }" />
			</c:url>

			<tr>
				<td>${clienteTemp.nombre }</td>
				<td>${clienteTemp.apellido }</td>
				<td>${clienteTemp.email }</td>
				<td><a href="${linkActualizar}"><input type="button"
						value="Modificar"></a></td>
			</tr>


		</c:forEach>
	</table>

	<br />

	<input type="button" value="Agregar Cliente"
		onclick="window.location.href='muestraFormularioAgregar'; return false;">

</body>
</html>