<%--
  Created by IntelliJ IDEA.
  User: ailuv
  Date: 11/5/2023
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Login</title>
</head>

<body class="flex items-center justify-center h-screen bg-gray-100">
<div class="w-96 p-6 bg-white rounded shadow-md">
    <h1 class="text-2xl font-semibold text-center">¡Bienvenido!</h1>
    <form action="login" method="POST" class="mt-4"  modelAttribute="datosLogin" >
        <div>
            <label for="usuario" class="block mb-1">Usuario</label>
            <input id="usuario" type="text" name="usuario"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa tu usuario">
        </div>
        <div class="mt-4">
            <label for="clave" class="block mb-1">Cotraseña</label>
            <input id="clave" type="password" name="clave"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa tu contraseña">
        </div>
        <div class="mt-6">
            <button type="submit"
                    class="w-full px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Ingresar</button>
            <c:if test="${not empty error}">
                <h4><span>${error}</span></h4>
                <br>
            </c:if>
            ${mensaje}

        </div>


    </form>
    <br>
    <p>   No estás registrado?  <a href="registrarme">hacé click acá</a></p>

</div>
</body>

</html>
