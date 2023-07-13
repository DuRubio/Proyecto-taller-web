<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>¡Asistencia exitosa!</title>
    <link rel="shortcut icon" href="../img/logo.png">
</head>
<nav class="flex items-center justify-between flex-wrap bg-violet-500 p-6">
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
            <a href="my-profile" class="mx-2 text-white hover:text-violet-300">
                <i class="fa-solid fa-user"></i>
            </a>
            <a href="logout" class="mx-2 text-white">Cerrar sesión</a>
        </c:if>
        <c:if test="${empty sessionScope.usuario}">
            <a href="login" class="mx-2 text-white">Iniciar sesión</a>
        </c:if>

    </div>
</nav>

<body>
<div class="m-auto w-96 p-6 bg-white rounded shadow-md mt-40">
    <h1 class="text-2xl font-semibold text-center">¡Felicidades!</h1>
    <hr class="my-4">
    <p class="text-center">
        ¡Adquiriste tu entrada! Para visualizar tus entradas podes dirigirte a tu perfil o <br><a href="/mis-entradas" class="text-violet-500">hacer click aquí</a>.
    </p>
    <div class="mt-6">
        <a href="home"
           class="block text-center bg-transparent hover:bg-violet-500 text-violet-700 font-semibold hover:text-white border border-violet-500 hover:border-transparent rounded py-2 px-4 rounded">Volver</a>
    </div>
</div>
</body>
<footer class="fixed w-full bottom-0 bg-violet-500 mt-4 py-8">
    <div class="container mx-auto px-4">
        <div class="flex flex-wrap justify-between">
            <div class="w-full lg:w-6/12 pr-4">
                <p class="text-white italic">Somos una plataforma especializada en la venta de entradas de
                    espectáculos
                    de alta demanda y ofrecemos servicios para la gestión de ingresos a eventos de distinta
                    índole.</p>
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