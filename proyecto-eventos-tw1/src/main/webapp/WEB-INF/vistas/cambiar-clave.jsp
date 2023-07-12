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
<nav
        class="flex items-center justify-between flex-wrap bg-violet-500 p-6">
    <div class="flex items-center flex-shrink-0 text-white mr-6">
        <img src="../img/logo.png" alt="" class="w-8 m-1 rounded"> <span
            class="font-semibold text-xl tracking-tight">Eventix</span>
    </div>
    <div
            class="w-full block flex-grow lg:flex lg:items-center lg:w-auto justify-end flex">
        <div class="flex items-center">
            <c:if test="${not empty sessionScope.usuario}">
                <p class="mx-2 font-semibold text-white text-xl tracking-tight">¡Hola
                        ${sessionScope.usuario.nombre}!</p>
            </c:if>
        </div>

        <c:if test="${not empty sessionScope.usuario}">
            <a href="/my-profile" class="mx-2 text-white hover:text-violet-300">
                <i class="fa-solid fa-user"></i>
            </a>
            <a href="logout" class="mx-2 text-white">Cerrar sesión</a>
        </c:if>
        <c:if test="${empty sessionScope.usuario}">
            <a href="login" class="mx-2 text-white">Iniciar sesión</a>
        </c:if>

    </div>
</nav>
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
                    <input placeholder="Escriba su contraseña anterior..." type="password" id="claveVieja" name="claveVieja" class="w-full bg-gray-100 border border-gray-300 rounded py-2 px-4 focus:outline-none focus:ring-2 focus:ring-purple-500">
                </div>
                <c:if test="${not empty error}">
                    <h4><span>${error}</span></h4>
                    <br>
                </c:if>
                ${errorClave1}
                <div class="mb-4">
                    <label for="claveNueva1" class="block font-semibold mb-1">Nueva contraseña</label>
                    <input placeholder="Escriba su contraseña nueva..." type="password" id="claveNueva1" name="claveNueva1" class="w-full bg-gray-100 border border-gray-300 rounded py-2 px-4 focus:outline-none focus:ring-2 focus:ring-purple-500">
                </div>
                <c:if test="${not empty error}">
                    <h4><span>${error}</span></h4>
                    <br>
                </c:if>
                ${errorClave2}
                <div class="mb-4">
                    <label for="claveNueva" class="block font-semibold mb-1">Repetir contraseña</label>
                    <input  placeholder="Repita su contraseña nueva..." type="password" id="claveNueva" name="claveNueva" class="w-full bg-gray-100 border border-gray-300 rounded py-2 px-4 focus:outline-none focus:ring-2 focus:ring-purple-500">
                </div>
                <c:if test="${not empty error}">
                    <h4><span>${error}</span></h4>
                    <br>
                </c:if>
                ${errorClave2}
                <div class="flex justify-between px-6 pt-4 pb-2">
                    <a class="bg-transparent hover:bg-violet-500 text-violet-700 font-semibold hover:text-white border border-violet-500 hover:border-transparent rounded py-2 px-4 rounded" href="/my-profile">Volver a mi perfil</a>
                    <button type="submit" class="bg-purple-500 hover:bg-purple-600 text-white font-semibold py-2 px-4 rounded mr-4">Actualizar</button>
                </div>
            </form>
        </div>
    </div>


</body>
<footer class="bg-violet-500 mt-16 py-8 fixed w-full bottom-0">
    <div class="container mx-auto px-4">
        <div class="flex flex-wrap justify-between">
            <div class="w-full lg:w-6/12 pr-4">
                <p class="text-white italic">Somos una plataforma especializada en la venta de entradas de espectáculos
                    de alta demanda y ofrecemos servicios para la gestión de ingresos a eventos de distinta índole.</p>
            </div>
            <div class="w-full lg:w-6/12 px-4">
                <ul class="flex flex-wrap list-none justify-end">
                    <li>
                        <a href="#" class="text-white hover:text-violet-300 mr-4">
                            <i class="fab fa-facebook"></i>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="text-white hover:text-violet-300 mr-4">
                            <i class="fab fa-twitter"></i>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="text-white hover:text-violet-300">
                            <i class="fab fa-instagram"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>
</html>