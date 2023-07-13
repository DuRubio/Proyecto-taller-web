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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <title>Registrarse</title>
    <link rel="shortcut icon" href="../img/logo.png">
    <style>
        .error {
            color: red;
            font-size: 0.675rem;
            margin-top: 0.15rem;
        }
    </style>
</head>

<body class="flex items-center justify-center h-screen bg-gray-100">

    <div class="w-96 p-6 bg-white rounded shadow-md">
        <h1 class="text-2xl font-semibold text-center">Nuevo Usuario</h1>
        <hr class="my-4">
        <form action="registrarme" method="POST" class="mt-4" modelAttribute="datosRegistracion"
            onsubmit="return validateForm()">

            <div>
                <label for="correo" class="block mb-1">Correo:</label>
                <input id="correo" type="email" name="correo"
                    class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                    placeholder="Ingresa tu correo">
                <div id="correoError" class="error"></div>
            </div>
            <div class="mt-4">
                <label for="clave" class="block mb-1">Clave:</label>
                <input id="clave" type="password" name="clave"
                    class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                    placeholder="Ingresa tu clave">
                <div id="claveError" class="error"></div>
            </div>
            <div class="mt-4">
                <label for="nombre" class="block mb-1">Nombre:</label>
                <input id="nombre" type="text" name="nombre"
                    class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                    placeholder="Ingresa tu nombre">
                <div id="nombreError" class="error"></div>
            </div>
            <div class="mt-4">
                <label for="apellido" class="block mb-1">Apellido:</label>
                <input id="apellido" type="text" name="apellido"
                    class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                    placeholder="Ingresa tu apellido">
                <div id="apellidoError" class="error"></div>
            </div>
            <div class="mt-4">
                <label for="localidad" class="block mb-1">Localidad:</label>
                <input id="localidad" type="text" name="localidad"
                    class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                    placeholder="Ingresa tu localidad">
                <div id="localidadError" class="error"></div>
            </div>
            <div class="mt-6">
                <button id="submitButton" type="submit" disabled
                    class="w-full px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Registrarme</button>
                <c:if test="${not empty mensaje}">
                    <h4><span>${mensaje}</span></h4>
                    <br>
                </c:if>
            </div>
        </form>
    </div>

    <script>
  function validateForm() {
    const correo = $('#correo').val();
    const clave = $('#clave').val();
    const nombre = $('#nombre').val();
    const apellido = $('#apellido').val();
    const localidad = $('#localidad').val();

    let isValid = true;

    if (correo.trim() === '') {
      $('#correoError').text('Campo requerido');
      isValid = false;
    } else if (!isValidEmail(correo)) {
      $('#correoError').text('El correo electrónico no tiene un formato válido');
      isValid = false;
    } else {
      $('#correoError').text('');
    }

    if (clave.trim() === '') {
      $('#claveError').text('Campo requerido');
      isValid = false;
    } else if (clave.length < 8 || clave.length > 20) {
      $('#claveError').text('La clave debe tener entre 8 y 20 caracteres');
      isValid = false;
    } else if (!/[!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?]+/.test(clave)) {
      $('#claveError').text('La clave debe contener al menos un símbolo');
      isValid = false;
    } else if (!/[a-z]+/.test(clave)) {
      $('#claveError').text('La clave debe contener al menos una minúscula');
      isValid = false;
    } else if (!/[A-Z]+/.test(clave)) {
      $('#claveError').text('La clave debe contener al menos una mayúscula');
      isValid = false;
    } else if (!/[0-9]+/.test(clave)) {
      $('#claveError').text('La clave debe contener al menos un número');
      isValid = false;
    } else {
      $('#claveError').text('');
    }

    if (nombre.trim() === '') {
      $('#nombreError').text('Campo requerido');
      isValid = false;
    } else if (nombre.length < 2 || nombre.length > 50) {
      $('#nombreError').text('El nombre debe tener entre 2 y 50 caracteres');
      isValid = false;
    } else if (!/^[a-zA-Z]+$/.test(nombre)) {
      $('#nombreError').text('El nombre no debe contener números');
      isValid = false;
    } else {
      $('#nombreError').text('');
    }

    if (apellido.trim() === '') {
      $('#apellidoError').text('Campo requerido');
      isValid = false;
    } else if (apellido.length < 2 || apellido.length > 50){
      $('#apellidoError').text('El apellido debe tener entre 2 y 50 caracteres');
      isValid = false;
    } else if (!/^[a-zA-Z]+$/.test(apellido)) {
      $('#apellidoError').text('El apellido no debe contener números');
      isValid = false;
    } else {
      $('#apellidoError').text('');
    }

    if (localidad.trim() === '') {
      $('#localidadError').text('Campo requerido');
      isValid = false;
    } else if (localidad.length < 2 || localidad.length > 50) {
      $('#localidadError').text('La localidad debe tener entre 2 y 50 caracteres');
      isValid = false;
    } else {
      $('#localidadError').text('');
    }

    if (isValid) {
      $('#submitButton').prop('disabled', false);
    } else {
      $('#submitButton').prop('disabled', true);
    }

    return isValid;
  }

  function isValidEmail(email) {
    // Expresión regular para validar el formato de correo electrónico
    const emailRegex = /^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/;
    return emailRegex.test(email);
  }

  $(document).ready(function () {
    $('input').keyup(function () {
      validateForm();
    });
  });
</script>

</body>

</html>