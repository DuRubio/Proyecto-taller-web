<%--
  Created by IntelliJ IDEA.
  User: Duilio
  Date: 5/5/2023
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="ar.edu.unlam.tallerweb1.domain.Evento" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h2 class="text-2xl font-semibold text-center">Paso 1/2</h2>
    <form method="post" action="registrar-evento" class="mt-4" modelAttribute="datosEvento" >
        <div>
            <label for="nombre" class="block mb-1">Nombre:</label>
            <input type="text" id="nombre" name="nombre"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa el nombre del evento" required>
        </div>
        <div class="mt-4">
            <label for="categoria" class="block mb-1">Tipo de evento:</label>
            <select id="categoria" name="categoria"
                    class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" required>
                <option value="DEPORTIVO">Deportivo</option>
                <option value="MUSICAL">Musical</option>
                <option value="BAILABLE">Bailable</option>
                <option value="TEATRO">Teatro</option>
                <option value="RECITAL">Recital</option>
                <option value="CINE">Cine</option>
                <option value="CULTURAL">Cultural</option>
                <option value="GASTRONOMICO">Gastronómico</option>
                <option value="MARCHA">Marcha</option>
            </select>
        </div>
        <div class="mt-4">
            <label for="localidad" class="block mb-1">Localidad:</label>
            <input id="localidad" type="text" name="localidad"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa la localidad">
        </div>


        <div class="mt-4">
            <label for="disponibilidad" class="block mb-1">Disponibilidad:</label>
            <input id="disponibilidad" type="number" name="disponibilidad"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingrese la disponibilidad">
            <p class="text-violet-500 text-italic text-sm">*Por defecto se cargará en 50</p>
        </div>



       <div class="mt-4">
           <label for="fecha" class="block mb-1">Fecha:</label>
           <input type="text" id="fecha" name="fecha" placeholder="AAAA-MM-DD"
                  class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" required>
       </div>


        <button type="submit"
                class="w-full px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Siguiente</button>
        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
        <p class="text-red-500 mx-2">${mensaje}</p>
    </form>
    <div class="flex justify-center px-6 pt-4 pb-2"><a class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full" href="home">Volver a home</a></div>

</div>
</body>
</html>