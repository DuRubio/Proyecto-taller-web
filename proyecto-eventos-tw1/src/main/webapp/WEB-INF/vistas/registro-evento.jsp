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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>EventiX</title>
    <link rel="shortcut icon" href="../img/logo.png">
    
    <style>
        .error {
            color: red;
            font-size: 0.6rem;
            margin-top: 0.1rem;
        }
    </style>
</head>
<body class="flex items-center justify-center h-screen bg-gray-100">
<div class="w-96 p-6 bg-white rounded shadow-md">
    <h1 class="text-2xl font-semibold text-center">Crear evento</h1>
    <h2 class="text-2xl font-semibold text-center">Paso 1/2</h2>
    <form method="post" action="registrar-evento" class="mt-4" modelAttribute="datosEvento" onsubmit="return validateForm()">
        <div>
            <label for="nombre" class="block mb-1">Nombre:</label>
            <input type="text" id="nombre" name="nombre"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingresa el nombre del evento" required>
        	<div id="nombreError" class="error"></div>
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
            <select id="localidad" name="localidad" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
                <option value="">Selecciona una localidad</option>
                <option value="Buenos Aires">Buenos Aires</option>
                <!--
                <option value="Buenos Aires" data-cityId="3433955">Buenos Aires (AR)</option>
                <option value="Córdoba" data-cityId="3860259">Córdoba (AR)</option>
                <option value="Madrid" data-cityId="1704129">Madrid (ES)</option>
                <option value="Barcelona" data-cityId="3128760">Barcelona (ES)</option>
                <option value="Paris" data-cityId="2968815">Paris</option>
                -->
            </select>
            <div id="localidadError" class="error"></div>
        </div>
        <div class="mt-4">
            <label for="lugar" class="block mb-1">Sede:</label>
            <select id="lugar" name="lugar" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
            </select>
            <div id="lugarError" class="error"></div>
        </div>
        <div class="mt-4">
            <label for="disponibilidad" class="block mb-1">Disponibilidad:</label>
            <input id="disponibilidad" type="number" name="disponibilidad"
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingrese la disponibilidad">
            <p class="text-violet-500 text-italic text-sm">*Por defecto se cargará en 50</p>
        	<div id="disponibilidadError" class="error"></div>
        </div>
        <div class="mt-4">
            <label for="isGratuito" class="block mb-1">Gratuito:</label>
            <input id="isGratuito" type="checkbox" name="isGratuito" onclick="togglePrecioInput()">
        </div>
        <div class="mt-4">
            <label for="precio" class="block mb-1">Precio:</label>
            <input id="precio" type="number" name="precio" disabled
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
                   placeholder="Ingrese el precio">
        </div>
        <div class="mt-4">
           <label for="fecha" class="block mb-1">Fecha:</label>
           <input type="text" id="fecha" name="fecha" placeholder="AAAA-MM-DD"
                  class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" required>
       	   <div id="fechaError" class="error"></div>
       </div>

        <button type="submit"
                class="w-full px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Siguiente</button>
        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
        <p class="text-red-500 mx-2">${mensaje}</p>
    </form>
    <div class="flex justify-center px-6 pt-4 pb-2"><a class="bg-transparent hover:bg-violet-500 text-violet-700 font-semibold hover:text-white border border-violet-500 hover:border-transparent rounded py-2 px-4 rounded" href="home">Volver a home</a></div>

</div>
<script>
    const localidadSelect = document.getElementById('localidad');
    const lugarSelect = document.getElementById('lugar');
    const isGratuitoCheckbox = document.getElementById('isGratuito');
    const precioInput = document.getElementById('precio');

    const opcionesLugar = {
        'Buenos Aires': ['Vorterix', 'Movistar Arena', 'Teatro Gran Rex', 'Hipodromo de San Isidro', 'Hipodromo de Palermo', 'Teatro Opera', 'Luna Park', 'Estadio Mas Monumental', 'Estadio Alberto J. Armando', 'Estadio Ciudad de La Plata', 'Centro Cultural Kirchner'],
        'Córdoba': ['Estadio Mario Alberto Kempes', 'Club Paraguay'],
        'Madrid': ['Nuevo Espacio Mad Cool', 'Estadio Santiago Bernabéu'],
        'Barcelona': ['Estadio Camp Nou'],
        'Paris': ['Le Parc des Princes']
    };

    function generarOpcionesLugar() {
        console.log("generando lugares")
        const localidadSeleccionada = localidadSelect.value;
        lugarSelect.innerHTML = '';

        if (localidadSeleccionada && opcionesLugar.hasOwnProperty(localidadSeleccionada)) {
            const opciones = opcionesLugar[localidadSeleccionada];
            opciones.forEach(opcion => {
                const option = document.createElement('option');
                option.value = opcion;
                console.log(option.value)
                option.textContent = opcion;
                lugarSelect.appendChild(option);
            });
        }
    }

    function togglePrecioInput() {
        if (isGratuitoCheckbox.checked) {
            precioInput.disabled = true;
            precioInput.value = '';
        } else {
            precioInput.disabled = false;
        }
    }

    localidadSelect.addEventListener('change', generarOpcionesLugar);
</script>
<script>
  function validateForm() {
    const nombre = $('#nombre').val();
    const localidad = $('#localidad').val();
    const disponibilidad = $('#disponibilidad').val();
    const fecha = $('#fecha').val();

    let isValid = true;

    if (nombre.trim() === '') {
        $('#nombreError').text('Campo requerido');
        isValid = false;
      } else if (nombre.length < 2 || nombre.length > 50) {
        $('#nombreError').text('El nombre debe tener entre 2 y 50 caracteres');
        isValid = false;
      } else {
        $('#nombreError').text('');
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

    if (disponibilidad.trim() !== '' && !/^\d+$/.test(disponibilidad)) {
      $('#disponibilidadError').text('La disponibilidad debe ser un número');
      isValid = false;
    } else {
      $('#disponibilidadError').text('');
    }

    if (fecha.trim() === '') {
        $('#fechaError').text('Campo requerido');
        isValid = false;
      } else if (!/^(\d{4})-(\d{2})-(\d{2})$/.test(fecha)) {
        $('#fechaError').text('Formato de fecha inválido. Debe ser AAAA-MM-DD');
        isValid = false;
      } else {
        const fechaInicio = new Date('2023-01-01');
        const fechaFin = new Date('2030-12-31');
        const fechaIngresada = new Date(fecha);

        if (fechaIngresada < fechaInicio || fechaIngresada > fechaFin) {
          $('#fechaError').text('La fecha debe estar entre 2023-01-01 y 2030-12-31');
          isValid = false;
        } else {
          $('#fechaError').text('');
        }
      }

    return isValid;
  }

  $(document).ready(function () {
    $('input, select').blur(function () {
      validateForm()
      console.log(lugar);
    });
  });
</script>
<script src="../js/opcionesSede.js"></script>
</body>
</html>
