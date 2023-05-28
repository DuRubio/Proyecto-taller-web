<%--
  Created by IntelliJ IDEA.
  User: Duilio
  Date: 27/5/2023
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Eventos</title>
</head>
<body>
<h1>Lista de Eventos</h1>
<table>
    <tr>
        <th>Nombre</th>
        <th>Fecha</th>
        <th>Lugar</th>
    </tr>
    <c:forEach var="evento" items="${eventos}">
        <tr>
            <td>${evento.nombre}</td>
            <td>${evento.fecha}</td>
            <td>${evento.lugar}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>