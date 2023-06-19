<%@ page import="ar.edu.unlam.tallerweb1.domain.Evento" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<script src="https://cdn.tailwindcss.com"></script>
<title>Home</title>
</head>

<body>
	<!-- Barra de navegación -->
	<nav
		class="flex items-center justify-between flex-wrap bg-violet-500 p-6">
		<div class="flex items-center flex-shrink-0 text-white mr-6">
			<img src="../img/logo.png" alt="" class="w-8 m-1 rounded"> <span
				class="font-semibold text-xl tracking-tight">Mi App de
				Eventos</span>
		</div>
		<div class="w-full block flex-grow lg:flex lg:items-center lg:w-auto justify-end flex">
<%--			<div class="text-sm lg:flex-grow">--%>
<%--				<input--%>
<%--					class="bg-violet-800 appearance-none border-2 border-violet-800 rounded py-2 px-4 text-violet-300 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"--%>
<%--					type="text" placeholder="Buscar...">--%>
<%--			</div>--%>
			<div class="flex items-center">
				<c:if test="${not empty sessionScope.usuario}">
                <p class="mx-2 font-semibold text-white text-xl tracking-tight">¡Hola ${sessionScope.usuario.nombre}!</p>
				</c:if>
<%--				<a href="#" class="mx-2 text-white hover:text-violet-300"> <i--%>
<%--					class="fa-solid fa-bell"></i>--%>

			</div>

	<c:if test="${not empty sessionScope.usuario}">
		<a href="/my-profile" class="mx-2 text-white hover:text-violet-300"> <i
				class="fa-solid fa-user"></i>
		</a>
		<a href="logout" class="mx-2 text-white">Cerrar sesión</a>
	</c:if>
	<c:if test="${empty sessionScope.usuario}">
		<a href="login" class="mx-2 text-white">Iniciar sesión</a>
	</c:if>

		</div>
	</nav>

	<!-- Filtros -->
	<div class="flex justify-center items-center my-4">
		<div class="border rounded-md p-4 bg-white">
			<h2 class="text-lg font-semibold mb-2">Filtrar Eventos</h2>
			<form action="/filtrar" method="POST">
				<div class="flex flex-wrap items-center">
					<div class="mr-4">
						<label for="filtro-ciudad" class="block mb-1">Ciudad:</label> <input
							type="text" id="filtro-ciudad" name="localidad"
							class="px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
							placeholder="Ingrese la ciudad">
					</div>
					<!-- 
					<div class="mr-4">
						<label for="filtro-fecha" class="block mb-1">Fecha:</label> <input
							type="date" id="filtro-fecha" name="filtro-fecha"
							class="px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
					</div>
					 -->
					
					<div class="mr-4">
						<label for="filtro-categoria" class="block mb-1">Categor&iacute;a:</label>
						<select id="filtro-categoria" name="filtro-categoria"
							class="px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
							<option value="">Seleccione una categor&iacute;a</option>
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
					<div>
						<button type="submit" class="px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Filtrar</button>
					</div>
				</div>
			</form>
		</div>
		<div class="flex justify-evenly px-6 pt-4 pb-2">
		<a
			class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full"
			href="editar-mis-preferencias">Editar Mis Preferencias</a>
		</div>
	</div>

	<!-- Cards -->
	<div class="max-w-6xl mx-auto mt-8">
		<div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
			<c:forEach items="${eventos}" var="evento">
				<div class="bg-white shadow-md rounded p-6">
					<img class="w-full" src="../img/${evento.URLImagen}" alt="Evento">
					<div class="mt-4">
						<h2 class="text-xl font-semibold mb-2">${evento.nombre}</h2>
						<p class="text-gray-700">Fecha: ${evento.fecha}</p>
						<p class="text-gray-700">Localidad: ${evento.localidad}</p>
					</div>
					<div class="flex justify-center mt-6">
						<a href="asistir" class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full">Asistir</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	</div>
	<div class="flex justify-evenly px-6 pt-4 pb-2 my-4">
		<a
			class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full"
			href="mostrar-eventos">Ver todos los eventos</a> <a
			class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full"
			href="mostrar-eventos-preferencias">Buscar Eventos Por Mis
			Preferencias</a> <a
			class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full"
			href="registrar-evento">Registra un evento</a>
	</div>
	<!-- Google Maps -->
	<div class="flex justify-center">
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d26283.162649244754!2d-58.458951284375!3d-34.5688622!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95bcb5a28c37ff9b%3A0x289b0f07f03e748b!2sHip%C3%B3dromo%20de%20Palermo!5e0!3m2!1ses!2sar!4v1683763795538!5m2!1ses!2sar"
			width="600" height="450" style="border: 0;" allowfullscreen=""
			loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
	</div>

	<!-- Footer  -->

	<footer class="bg-violet-500 mt-4 py-8">
		<div class="container mx-auto px-4">
			<div class="flex flex-wrap justify-between">
				<div class="w-full lg:w-6/12 px-4">
					<h2 class="text-2xl font-semibold text-white">Nuestras redes
						sociales:</h2>
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

	<c:if test="${mostrarPopup}">
		<div class="fixed inset-0 flex items-center justify-center bg-gray-900 bg-opacity-50">
			<div class="bg-white rounded-md shadow-lg p-4">
				<p class="text-lg text-gray-800">Para tu exquisitez no hay resultados, amplia la busqueda</p> <br>
				<a href="/home" class=" flex justify-center mt-4 px-4 py-2 bg-violet-500 text-white rounded-md hover:bg-violet-600">Aceptar</a>
			</div>
		</div>
	</c:if>

    <script>
        var username = localStorage.getItem("username");
        var usernameElement = document.getElementById("username");
        usernameElement.textContent = !username ? "" : username;
    </script>

</body>

</html>