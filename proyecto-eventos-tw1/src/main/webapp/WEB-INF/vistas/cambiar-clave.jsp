<%--
  Created by IntelliJ IDEA.
  User: ailuv
  Date: 13/6/2023
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="ar.edu.unlam.tallerweb1.domain.Entrada" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Cambiar clave</title>
</head>

<body class="bg-gray-100">
<div class="max-w-xl mx-auto px-4 py-8">

    <!-- Imagen de perfil -->
    <div class="flex justify-center items-center mb-4">

        <img src="../img/perfil.jpg" alt="Imagen de perfil" class="w-16 h-16 rounded-full">
    </div>

    <!-- Nombre y Apellido -->
    <h1 class="text-2xl font-bold text-center mb-4">${usuario.nombre} ${usuario.apellido}</h1>




        <div class="bg-white p-4 rounded shadow-md">
            <h2 class="text-lg font-bold mb-2">Cambiar contraseña</h2>
            <form method="post" action="cambiarclave" class="mt-4" >
                <div class="mb-4">
                    <label for="claveVieja" class="block font-semibold mb-1">Anterior contraseña</label>
                    <input placeholder="escriba su contraseña anterior..." type="password" id="claveVieja" name="claveVieja" class="w-full bg-gray-100 border border-gray-300 rounded py-2 px-4 focus:outline-none focus:ring-2 focus:ring-purple-500">
                </div>
                <c:if test="${not empty error}">
                    <h4><span>${error}</span></h4>
                    <br>
                </c:if>
                ${errorClave1}
                <div class="mb-4">
                    <label for="claveNueva1" class="block font-semibold mb-1">Nueva contraseña</label>
                    <input placeholder="escriba su contraseña nueva..." type="password" id="claveNueva1" name="claveNueva1" class="w-full bg-gray-100 border border-gray-300 rounded py-2 px-4 focus:outline-none focus:ring-2 focus:ring-purple-500">
                </div>
                <c:if test="${not empty error}">
                    <h4><span>${error}</span></h4>
                    <br>
                </c:if>
                ${errorClave2}
                <div class="mb-4">
                    <label for="claveNueva" class="block font-semibold mb-1">Repetir contraseña</label>
                    <input  placeholder="repita su contraseña nueva..." type="password" id="claveNueva" name="claveNueva" class="w-full bg-gray-100 border border-gray-300 rounded py-2 px-4 focus:outline-none focus:ring-2 focus:ring-purple-500">
                </div>
                <c:if test="${not empty error}">
                    <h4><span>${error}</span></h4>
                    <br>
                </c:if>
                ${errorClave2}
                <button type="submit" class="bg-purple-500 hover:bg-purple-600 text-white font-semibold py-2 px-4 rounded">Actualizar</button>
                <div class="flex justify-center px-6 pt-4 pb-2"><a class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full" href="/my-profile">Volver a mi perfil</a>
                </div>
            </form>
        </div>
    </div>


</body>

</html>