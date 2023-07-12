<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Mis Preferencias</title>
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
<div class="flex items-center justify-center mb-16 mt-20">
    <div class="flex items-center justify-center w-full max-w-5xl">
        <img src="./img/evento-cultural.jpg" alt="Image" class="w-1/2 h-auto object-cover">
        <div class="w-1/2 h-auto px-6 py-8 bg-white">
            <h1 class="text-3xl font-semibold mb-6">Seleccioná tus preferencias</h1>
        <form action="guardar-preferencias-usuario" method="POST" >
            <div class="flex flex-wrap items-center gap-4">
                <label for="deportivo" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="deportivo" type="checkbox" class="hidden" name="deportivo" value="true">
                    Deportivo
                </label>

                <label for="musical" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="musical" type="checkbox" class="hidden" name="musical" value="true">
                    Musical
                </label>

                <label for="bailable" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="bailable" type="checkbox" class="hidden" name="bailable" value="true">
                    Bailable
                </label>

                <label for="teatral" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="teatral" type="checkbox" class="hidden" name="teatral" value="true">
                    Teatral
                </label>

                <label for="recital" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="recital" type="checkbox" class="hidden" name="recital" value="true">
                    Recital
                </label>

                <label for="cine" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="cine" type="checkbox" class="hidden" name="cine" value="true">
                    Cine
                </label>

                <label for="cultural" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="cultural" type="checkbox" class="hidden" name="cultural" value="true">
                    Cultural
                </label>

                <label for="gastronomico" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="gastronomico" type="checkbox" class="hidden" name="gastronomico" value="true">
                    Gastronomico
                </label>

                <label for="feria" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="feria" type="checkbox" class="hidden" name="feria" value="true">
                    Feria
                </label>

                <label for="marcha" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="marcha" type="checkbox" class="hidden" name="marcha" value="true">
                    Marcha
                </label>
            </div>
            <br>
            <br>
            <br>
            <button id="btn-registrarme" class="w-full bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded" type="submit">Guardar</button>
                <a href="/home"
                   class="block m-auto text-center bg-transparent hover:bg-violet-500 text-violet-700 font-semibold hover:text-white border border-violet-500 hover:border-transparent rounded py-2 px-4 rounded mt-6">Volver a home</a>
        </form>

        <c:if test="${not empty mensaje}">
            <h4>
                <span>${mensaje}</span>
            </h4>
            <br>
        </c:if>
        </div>
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
    window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
</script>
<script>
    const checkboxes = document.querySelectorAll('input[type="checkbox"]');

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            const label = this.parentElement;
            if (this.checked) {
                label.classList.add('bg-violet-600');
                label.classList.remove('bg-violet-300');
            } else {
                label.classList.add('bg-violet-300');
                label.classList.remove('bg-violet-600');
            }
        });
    });
</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
<footer class="bg-violet-500 py-8 mt-40">
    <div class="container mx-auto px-4">
        <div class="flex flex-wrap justify-between">
            <div class="w-full lg:w-6/12 pr-4">
                <p class="text-white italic">Somos una plataforma especializada en la venta de entradas de espectáculos de alta demanda y ofrecemos servicios para la gestión de ingresos a eventos de distinta índole.</p>
            </div>
            <div class="w-full lg:w-6/12 px-4">
                <ul class="flex flex-wrap list-none justify-end">
                    <li><a href="#" class="text-white hover:text-violet-300 mr-4">
                        <i class="fab fa-facebook"></i>
                    </a></li>
                    <li><a href="#" class="text-white hover:text-violet-300 mr-4">
                        <i class="fab fa-twitter"></i>
                    </a></li>
                    <li><a href="#" class="text-white hover:text-violet-300">
                        <i class="fab fa-instagram"></i>
                    </a></li>
                </ul>
            </div>
        </div>
    </div>
</footer>
</html>