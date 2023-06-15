<%--
  Created by IntelliJ IDEA.
  User: ailuv
  Date: 13/6/2023
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Mi perfil</title>
</head>

<body class="bg-gray-100">
<div class="max-w-xl mx-auto px-4 py-8">

    <!-- Imagen de perfil -->
    <div class="flex justify-center items-center mb-4">
        <img src="../img/avatar.jpg" alt="Imagen de perfil" class="w-16 h-16 rounded-full">
    </div>

    <!-- Nombre y Apellido -->
    <h1 class="text-2xl font-bold text-center mb-4">${usuario.nombre} ${usuario.apellido}</h1>

    <!-- Email -->
    <p class="text-gray-700 mb-4"><strong>Email:</strong> ${usuario.correo}</p>

    <!-- Contraseña -->
    <div class="flex items-center mb-4">
        <input type="password" value="${usuario.clave}" readonly class="w-full bg-white border border-gray-300 rounded py-2 px-4 focus:outline-none focus:ring-2 focus:ring-purple-500">
<%--        <button type="button" class="ml-2 p-2 bg-gray-200 rounded" onclick="mostrarPopUp()">--%>
<%--            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-5 h-5">--%>
<%--                <path d="M15.586 4.414c.78.78.78 2.048 0 2.828l-1.414 1.414c-.78.78-2.048.78-2.828 0l-1.172-1.172c-.42-.42-.586-1.008-.42-1.562l.828-3.906c.105-.5.523-.92 1.047-1.047l3.906-.828c.555-.166 1.14 0 1.562.42l1.172 1.172zm-3.414 6.172l-5.5 5.5c-1.172-1.172-1.172-3.07 0-4.242l3.172-3.172c1.172-1.172 3.07-1.172 4.242 0l1.414 1.414c1.172 1.172 1.172 3.07 0 4.242l-5.5 5.5-2.828-2.828zm6.242-1.242l-1.414-1.414 2.828-2.828 1.414 1.414-2.828 2.828z" />--%>
<%--            </svg>--%>
<%--        </button>--%>
    </div>

    <div id="pop-up" class="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 hidden">
        <div class="bg-white p-4 rounded shadow-md">
            <h2 class="text-lg font-bold mb-2">Cambiar contraseña</h2>
            <form onsubmit="actualizarContraseña(event)">
                <div class="mb-4">
                    <label for="claveNueva" class="block font-semibold mb-1">Nueva contraseña</label>
                    <input type="text" id="claveNueva" name="claveNueva" class="w-full bg-gray-100 border border-gray-300 rounded py-2 px-4 focus:outline-none focus:ring-2 focus:ring-purple-500">
                </div>
                <button type="submit" class="bg-purple-500 hover:bg-purple-600 text-white font-semibold py-2 px-4 rounded">Actualizar</button>
            </form>
        </div>
    </div>

    <!-- Localidad -->
    <p class="text-gray-700 mb-4"><strong>Localidad:</strong> ${usuario.localidad}</p>

    <!-- Próximos eventos -->
    <h2 class="text-xl font-bold mb-2">Próximos eventos:</h2>
    <table class="w-full mb-4">
        <thead>
        <tr>
            <th class="py-2 text-left">Evento</th>
            <th class="py-2 text-left">Fecha</th>
            <th class="py-2 text-left">Localidad</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="py-2">Coldplay</td>
            <td class="py-2">10-10-2023</td>
            <td class="py-2">Nuñez</td>
        </tr>
        <tr>
            <td class="py-2">Tan Bióncia</td>
            <td class="py-2">04-11-2023</td>
            <td class="py-2">La Plata</td>
        </tr>
        </tbody>
    </table>

    <div class="flex items-center mb-4">
        <label for="clave" class="mr-2">Quiero crear mis propios eventos:</label>
        <input type="text" id="clave" placeholder="Ingresá tu token" class="w-full bg-white border border-gray-300 rounded py-2 px-4 focus:outline-none focus:ring-2 focus:ring-purple-500" onkeyup="validarClave()">
        <button type="submit" id="setAdmin" class="block bg-violet-500 hover:bg-purple-600 text-white font-bold py-2 px-4 rounded mx-2 disabled:opacity-50">Enviar</button>
    </div>

    <a href="#" class="block bg-violet-500 hover:bg-purple-600 text-white font-bold py-2 px-4 rounded">Actualizar preferencias</a>
</div>
<div class="flex justify-center px-6 pt-4 pb-2"><a class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full" href="home">Volver a home</a></div>
</body>
<script>
    function mostrarPopUp() {
        var popUp = document.getElementById("pop-up");
        popUp.classList.remove("hidden");
    }

    function ocultarPopUp() {
        var popUp = document.getElementById("pop-up");
        popUp.classList.add("hidden");
    }

    function actualizarContraseña(event) {
        event.preventDefault();

        var claveNuevaInput = document.getElementById("claveNueva");
        var claveNueva = claveNuevaInput.value;

        usuario.clave = claveNueva;

        ocultarPopUp();
    }
        function validarClave() {
        var claveInput = document.getElementById("clave");
        var botonEnviar = document.getElementById("setAdmin");

        if (claveInput.value === "eventos1234") {
        botonEnviar.disabled = false;
    } else {
        botonEnviar.disabled = true;
    }
    }

    var username = "${usuario.nombre}";
    localStorage.setItem("username", username);

    function validarClave() {
        var claveInput = document.getElementById("clave");
        var botonEnviar = document.getElementById("setAdmin");

        if (claveInput.value === "eventos1234") {
            botonEnviar.disabled = false;
        } else {
            botonEnviar.disabled = true;
        }
    }
</script>

</html>
