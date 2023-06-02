<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Listado de Eventos</title>
</head>

<body class="bg-gray-100">
<h1 class="text-4xl text-center font-bold mt-8">Listado de Eventos</h1>

<div class="max-w-6xl mx-auto mt-8">
    <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
        <c:forEach items="${eventos}" var="evento">
            <div class="bg-white shadow-md rounded p-6">
                <img class="w-full" src="../img/${evento.URLImagen}" alt="Evento">
                <div class="mt-4">
                    <h2 class="text-xl font-semibold mb-2">${evento.nombre}</h2>
                    <p class="text-gray-700">Fecha: ${evento.fecha}</p>
                    <p class="text-gray-700">Localidad: ${evento.localidad}</p>
                    <p class="text-gray-700">Categoria: ${evento.tipo}</p>
                    <!-- Agrega más detalles del evento si es necesario -->
                </div>
                <div class="flex justify-center mt-6">
                    <button class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full">Comprar entradas</button>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<div class="flex justify-center px-6 pt-4 pb-2"><a class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full" href="home">Volver a home</a></div>

</body>

</html>