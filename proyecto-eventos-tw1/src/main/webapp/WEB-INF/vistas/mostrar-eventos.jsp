<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Eventos</title>
</head>
<body>
<h1>Listado de Eventos</h1>
<table>
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Fecha</th>
        <th>Localidad</th>
        <!-- Agrega más columnas si es necesario -->
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${eventos}" var="evento">
        <tr>
            <td>${evento.nombre}</td>
            <td>${evento.fecha}</td>
            <td>${evento.localidad}</td>
            <!-- Agrega más columnas si es necesario -->
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>