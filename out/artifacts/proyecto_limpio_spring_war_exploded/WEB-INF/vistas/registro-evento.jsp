<%--
  Created by IntelliJ IDEA.
  User: Duilio
  Date: 5/5/2023
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registra un evento</title>
    <link rel="stylesheet" href="/css/formulario.css">
</head>
<body>
<h1>Crear evento</h1>

<form method="post" action="/registro-evento">
    <div class="form-group">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
    </div>
    <div class="form-group">
        <label for="tipo">Tipo de evento:</label>
        <select id="tipo" name="tipo" required>
            <option value="Deportivo">Deportivo</option>
            <option value="Musical">Musical</option>
            <option value="Bailable">Bailable</option>
            <option value="Teatro">Teatro</option>
            <option value="Recital">Recital</option>
            <option value="Cine">Cine</option>

        </select>
    </div>
    <div class="form-group">
        <label for="fecha">Fecha:</label>
        <input type="date" id="fecha" name="fecha" required>
    </div>
    <button type="submit">Crear evento</button>
</form>

</body>
</html>
