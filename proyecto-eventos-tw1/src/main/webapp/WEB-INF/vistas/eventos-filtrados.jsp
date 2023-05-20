


<%-- NO USAR ESTA VISTA POR AHORA




  Created by IntelliJ IDEA.
  User: Duilio
  Date: 19/5/2023
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Eventos filtrados</title>
</head>
<body class="flex items-center justify-center h-screen bg-gray-100">
<div class="w-96 p-6 bg-white rounded shadow-md">
    <h1 class="text-2xl font-semibold text-center">Eventos Filtrados</h1>

    <form action="/events/filter" method="get" class="mt-4">
        <div>
            <label for="fecha" class="block mb-1">Fecha:</label>
            <input id="fecha" type="text" name="date"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa la fecha">
        </div>

        <div class="mt-4">
            <label for="categoria" class="block mb-1">Categoria:</label>
            <select id="categoria" name="categoria"
                    class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
                <option value="deportivo">Deportivo</option>
                <option value="msuical">Musical</option>
                <option value="teatro">Teatro</option>
            </select>
        </div>

        <div class="mt-4">
            <label for="localidad" class="block mb-1">Localidad:</label>
            <input id="localidad" type="text" name="localidad"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa la localidad">
        </div>

        <button type="submit"
                class="w-full px-4 py-2 mt-6 text-white bg-violet-500 rounded-md hover:bg-violet-600">
            Filtrar
        </button>
    </form>

    <div id="events-container" class="mt-6">
        <!-- Contenedor donde se mostrarán los eventos filtrados -->
    </div>
</div>
</body>
</html>
