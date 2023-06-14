<%--
  Created by IntelliJ IDEA.
  User: ailuv
  Date: 11/5/2023
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://cdn.tailwindcss.com"></script>
  <title>Registrarse</title>
</head>

<body class="flex items-center justify-center h-screen bg-gray-100">
  <div class="bg-white rounded shadow-md">

    <h1 class="text-2xl font-semibold text-center">Nuevo Usuario</h1>
    <hr class="my-4">

    <form action="registrarme" method="POST" class="mt-4" modelAttribute="datosRegistracion">
      <div class="flex row align-items-center">
        <div class="col-6 p-2 bg-white rounded shadow-md">
          <div>
            <label for="correo" class="block mb-1">Correo:</label>
            <input id="correo" type="email" name="correo" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" placeholder="Ingresa tu correo">
          </div>
          <div class="mt-4">
            <label for="clave" class="block mb-1">Clave:</label>
            <input id="clave" type="password" name="clave" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" placeholder="Ingresa tu clave">
          </div>
          <div class="mt-4">
            <label for="nombre" class="block mb-1">Nombre:</label>
            <input id="nombre" type="text" name="nombre" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" placeholder="Ingresa tu nombre">
          </div>
          <div class="mt-4">
            <label for="apellido" class="block mb-1">Apellido:</label>
            <input id="apellido" type="text" name="apellido" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" placeholder="Ingresa tu apellido">
          </div>
          <div class="mt-4">
            <label for="localidad" class="block mb-1">Localidad:</label>
            <input id="localidad" type="text" name="localidad" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" placeholder="Ingresa tu localidad">
          </div>
        </div>
        <div class="col-6 p-2 bg-white rounded shadow-md ml-2">
          <h1 class="form-signin-heading">Mis Preferencias</h1>
          <hr class="colorgraph">
          <br>
          <h2 class="d-flex justify-content-center">Tipo de Evento Preferido</h2>
          <br>
          <div class="flex flex-wrap">
            <div class="col">
              <label for="tipoEvento">Tipo de Evento:</label>
              <select id="tipoEvento" name="tipoEvento" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
                <option value="musical" selected>Musical</option>
                <option value="deportivo">Deportivo</option>
                <option value="bailable">Bailable</option>
                <option value="teatral">Teatral</option>
                <option value="recital">Recital</option>
                <option value="cine">Cine</option>
                <option value="cultural">Cultural</option>
                <option value="gastronomico">Gastronómico</option>
                <option value="feria">Feria</option>
                <option value="marcha">Marcha</option>
              </select>
            </div>
            <div class="col">
              <label for="tipoLugar">Tipo de Lugar:</label>
              <select id="tipoLugar" name="tipoLugar" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
                <option value="aireLibre">Al aire libre</option>
                <option value="teatro" selected>En teatros</option>
                <option value="estadio">En estadios</option>
                <option value="centroCultural">En centros culturales</option>
              </select>
            </div>
            <div class="col">
              <label for="edades">Edades:</label>
              <select id="edades" name="edades" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
                <option value="infantil">Infantil</option>
                <option value="juvenil">Juvenil</option>
                <option value="adultos">Adultos</option>
                <option value="jubilados">Jubilados</option>
                <option value="todasLasEdades" selected>Todas las edades</option>
              </select>
            </div>
            <div class="col">
              <label for="horario">Horario:</label>
              <select id="horario" name="horario" class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
                <option value="matutino">Matutinos</option>
                <option value="vespertino" selected>Vespertinos</option>
                <option value="nocturno">Nocturnos</option>
              </select>
            </div>
          </div>
          <br>
        </div>
      </div>
      <div class="mt-6">
        <button type="submit" class="w-full px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Registrarme</button>
        <c:if test="${not empty mensaje}">
          <h4>
            <span>${mensaje}</span>
          </h4>
          <br>
        </c:if>
      </div>
    </form>
  </div>
</body>

</html>
