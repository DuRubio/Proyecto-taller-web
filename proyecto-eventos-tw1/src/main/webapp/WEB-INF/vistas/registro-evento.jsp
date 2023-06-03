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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Registra un evento</title>
</head>
<body class="flex items-center justify-center h-screen bg-gray-100">
<div class="w-96 p-6 bg-white rounded shadow-md">
    <h1 class="text-2xl font-semibold text-center">Crear evento</h1>
    <form method="post" action="/registro-evento" class="mt-4">
        <div>
            <label for="nombre" class="block mb-1">Nombre:</label>
            <input type="text" id="nombre" name="nombre"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa el nombre del evento" required>
        </div>
        <div class="mt-4">
            <label for="tipo" class="block mb-1">Tipo de evento:</label>
            <select id="tipo" name="tipo"
                    class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" required>
                <option value="Deportivo">Deportivo</option>
                <option value="Musical">Musical</option>
                <option value="Bailable">Bailable</option>
                <option value="Teatro">Teatro</option>
                <option value="Recital">Recital</option>
                <option value="Cine">Cine</option>
            </select>
        </div>
        <div class="mt-4">
            <label for="fecha" class="block mb-1">Fecha:</label>
            <input type="date" id="fecha" name="fecha"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" required>
        </div>
        <br>
        <label for="imagen" class="block mb-1">Subir una Imagen:</label>
        <div class="relative flex items-start">
            <input type="file" id="imagen" name="imagen" class="hidden">
            <label for="imagen" class="px-4 py-2 bg-violet-500 text-white rounded-md cursor-pointer hover:bg-violet-600">
                Seleccionar Archivo
            </label>
        </div>
        <br><br>
        <button type="submit"
                class="w-full px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Crear evento</button>
        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
        ${mensaje}
    </form>
    <div class="flex justify-center px-6 pt-4 pb-2"><a class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full" href="home">Volver a home</a></div>

</div>
</body>
</html>
