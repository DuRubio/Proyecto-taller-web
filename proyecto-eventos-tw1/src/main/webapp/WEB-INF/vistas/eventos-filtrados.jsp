
<%@ page import="ar.edu.unlam.tallerweb1.domain.Evento" %>


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

    <form action="/home/filtrar" method="get" class="mt-4">
        <h1> Acá iría la lista de eventos filtrados</h1>
    </form>


</div>
</body>
</html>
