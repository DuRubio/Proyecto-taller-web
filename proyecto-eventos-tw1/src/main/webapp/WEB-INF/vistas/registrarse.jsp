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
    <h1 class="text-2xl font-semibold text-center">Registrate</h1>
    <form class="mt-4">
        <div class="grid grid-cols-2 gap-4">
            <div>
                <label for="firstName" class="block mb-1">Nombre</label>
                <input id="firstName" type="text" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" placeholder="Tu nombre">
            </div>
            <div>
                <label for="lastName" class="block mb-1">Apellido</label>
                <input id="lastName" type="text" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" placeholder="Tu apellido">
            </div>
        </div>
        <div class="mt-4">
            <label for="username" class="block mb-1">Usuario</label>
            <input id="username" type="text" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" placeholder="Tu usuario">
        </div>
        <div class="mt-4">
            <label for="email" class="block mb-1">Email</label>
            <input id="email" type="email" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" placeholder="Tu email">
        </div>
        <div class="mt-4">
            <label for="birthdate" class="block mb-1">Fecga de Nacimiento</label>
            <input id="birthdate" type="date" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
        </div>
        <div class="mt-4">
            <label for="residence" class="block mb-1">¿Dónde vivis?</label>
            <input id="residence" type="text" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" placeholder="Tu ciudad">
        </div>
        <div class="mt-6">
            <button type="submit" class="w-full px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Registrate</button>
        </div>
    </form>
</div>
</body>

</html>
