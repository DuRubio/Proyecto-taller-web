
<%@ page import="ar.edu.unlam.tallerweb1.domain.Evento" %>


<%-- NO USAR ESTA VISTA POR AHORA




  Created by IntelliJ IDEA.
  User: Duilio
  Date: 19/5/2023
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Lista de Eventos</title>

</head>

<body class="flex items-center justify-center h-screen bg-gray-100">
<div class="w-96 p-6 bg-white rounded shadow-md">
    <h1 class="text-2xl font-semibold text-center">¡Bienvenido!</h1>
    <jsp:useBean id="eventosFiltrados" type="java.util.ArrayList" scope="session" />
    <table class="mt-4 w-full">
        <thead>
        <tr>
            <th class="px-4 py-2">Nombre del Evento</th>
            <th class="px-4 py-2">Ubicación</th>
            <th class="px-4 py-2">Lugar</th>
            <th class="px-4 py-2">Fecha</th>
            <th class="px-4 py-2">Categoria</th>

        </tr>
        </thead>
        <tbody>
        <% for(int i = 0; i < eventosFiltrados.size(); i++) { %>
        <tr>
            <td class="px-4 py-2">${eventosFiltrados.get(i).getNombre()}</td>
            <td class="px-4 py-2">${eventosFiltrados.get(i).getLocalidad()}</td>
            <td class="px-4 py-2">${eventosFiltrados.get(i).getLugar()}</td>
            <td class="px-4 py-2">${eventosFiltrados.get(i).getFecha()}</td>
            <td class="px-4 py-2">${eventosFiltrados.get(i).getTipo()}</td>

        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>

</html>