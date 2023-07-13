<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Ticket Electrónico</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <script type="text/javascript" defer
            src="js\HTML2PDF\html2pdf.bundle.min.js"></script>
    <script type="text/javascript" defer src="js\HTML2PDF\descargarPDF.js"></script>
    <title>Entrada QR Code</title>
    <link rel="shortcut icon" href="../img/logo.png">
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

    </div>
</nav>
<body class="bg-gray-100">
<div class="flex justify-center px-6 pt-4 pb-2">
    <h1 class="text-lg font-bold text-gray-800">Tu código QR ya está disponible</h1>
</div>
<div class="flex justify-center px-6 my-8 contenedor">
    <div class="max-w-md mx-auto bg-white rounded-lg shadow-lg p-6 flex flex-col items-center">
        <div class="mb-4">
            <img src="../img/logo.png" alt="Logo" class="w-12 h-12 mx-auto">
            <p class="text-purple-600 text-medium">Gracias por adquirir tu entrada con EventiX</p>
        </div>
        <h1 class="text-black font-bold text-2xl uppercase mb-2">${datosEntrada.evento.nombre}</h1>
        <p class="text-black mb-2">${datosEntrada.evento.fecha}</p>
        <p class="text-black">${datosEntrada.evento.localidad}</p>
        <img src="data:image/png;base64,${qrCodeBase64}" alt="QR Code">
        <p class="text-sm text-gray-600">E-ticket: #1245281-${datosEntrada.id}</p>
    </div>
</div>
<div class="flex justify-center px-6 pt-4 pb-2">
    <button class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full" id="btnCrearPdf">Descargar</button>
</div>
<div class="flex justify-center px-6 pt-4 pb-2">
    <a
            class="bg-transparent hover:bg-violet-500 text-violet-700 font-semibold hover:text-white border border-violet-500 hover:border-transparent rounded py-2 px-4 rounded"
            href="home">Volver a home</a>
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