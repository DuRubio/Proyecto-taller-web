<%--
  Created by IntelliJ IDEA.
  User: ailuv
  Date: 11/5/2023
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Registrarse</title>
</head>

<body class="flex items-center justify-center h-screen bg-gray-100">
<div class="w-96 p-6 bg-white rounded shadow-md">

    <h1 class="text-2xl font-semibold text-center">Nuevo Usuario</h1>
    <hr class="my-4">
    <form action="registrarme" method="POST" class="mt-4"  modelAttribute="datosRegistracion" >

        <div>
            <label for="correo" class="block mb-1">Correo:</label>
            <input id="correo" type="email" name="correo"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa tu correo">
        </div>
        <div class="mt-4">
            <label for="clave" class="block mb-1">Clave:</label>
            <input id="clave" type="password" name="clave"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa tu clave">
        </div>
        <div class="mt-4">
            <label for="nombre" class="block mb-1">Nombre:</label>
            <input id="nombre" type="text" name="nombre"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa tu nombre">
        </div>
        <div class="mt-4">
            <label for="apellido" class="block mb-1">Apellido:</label>
            <input id="apellido" type="text" name="apellido"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa tu apellido">
        </div>
        <div class="mt-4">
            <label for="localidad" class="block mb-1">Localidad:</label>
            <input id="localidad" type="text" name="localidad"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa tu localidad">
        </div>
        <div class="mt-6">
            <button type="submit"
                    class="w-full px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Registrarme</button>
            <c:if test="${not empty mensaje}">
                <h4><span>${mensaje}</span></h4>
                <br>
            </c:if>
        </div>
    </form>
</div>
</body>

</html>
