<%@ page import="ar.edu.unlam.tallerweb1.domain.Evento"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
<title>Home</title>
</head>

<body>
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

	<div class="flex justify-center items-center my-4">
		<div class="border rounded-md p-4 bg-white">
			<h2 class="text-lg font-semibold mb-2">Filtrar Eventos</h2>
			<form action="${pageContext.request.contextPath}/filtrar"
				method="POST">
				<div class="flex flex-wrap items-center">
					<div class="mr-4">
						<label for="filtro-ciudad" class="block mb-1">Ciudad:</label> <input
							type="text" id="filtro-ciudad" name="localidad"
							class="px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
							placeholder="Ingrese la ciudad">
					</div>

					<div class="mr-4">
						<label for="filtro-fecha" class="block mb-1">Fecha:</label> <input
							type="date" id="filtro-fecha" name="fecha"
							class="px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
					</div>

					<div class="mr-4">
						<label for="filtro-categoria" class="block mb-1">Categoría:</label>
						<select id="filtro-categoria" name="categoria"
							class="px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
							<option value="">Seleccione una categoría</option>
							<option value="1">Deportivo</option>
							<option value="2">Musical</option>
							<option value="3">Bailable</option>
							<option value="4">Teatro</option>
							<option value="5">Recital</option>
							<option value="6">Cine</option>
							<option value="7">Cultural</option>
							<option value="8">Gastronómico</option>
							<option value="9">Feria</option>
							<option value="10">Marcha</option>
						</select>
					</div>
					<div>
						<button type="submit"
							class="px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Filtrar
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- Cards -->
	<div class="max-w-6xl mx-auto mt-8">
		<div
			class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
			<c:forEach items="${eventos}" var="evento">
				<div class="bg-white shadow-md rounded p-6">
					<form action="/weather/">
						<input type="hidden" name="cityId" value="${evento.cityId}">
						<input type="hidden" name="eventoId" value="${evento.id}">
						<button type="submit">
					<img class="w-full" src="../img/${evento.URLImagen}" alt="Evento">
					<div class="mt-4">
						<h2 class="text-xl font-semibold mb-2">${evento.nombre}</h2>
						<p class="text-gray-700">Fecha: ${evento.fecha}</p>
						<p class="text-gray-700">Localidad: ${evento.localidad}</p>
						<p class="text-gray-700">Disponibilidad:
							${evento.disponibilidad}</p>
					</div>
						</button>
					</form>
					<div class="flex justify-center mt-6">
						<c:if test="${evento.disponibilidad>0}">
							<a href="asistir?eventoId=${evento.id}" class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full mr-2">Asistir</a>
						</c:if>
						<c:if test="${evento.disponibilidad==0}">
							<a href="#" class="bg-gray-500 cursor-not-allowed text-white font-bold py-2 px-4 rounded-full mr-2">Cupo lleno</a>
						</c:if>
						<c:if test="${usuario.isAdmin}">
							<a class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full ml-2" href="eliminar?eventoId=${evento.id}">Eliminar</a>
						</c:if>

					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- Cards -->
	<div class="max-w-6xl mx-auto mt-8">
		<h1 class="text-2xl font-bold mb-4">Esto podría interesarte...</h1>
		<div
				class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
			<c:forEach items="${eventosSegunPreferencias}" var="eventosSegunPreferencias">
				<div class="bg-white shadow-md rounded p-6">
					<form action="/weather/">
						<input type="hidden" name="cityId" value="${eventosSegunPreferencias.cityId}">
						<input type="hidden" name="eventoId" value="${eventosSegunPreferencias.id}">
						<button type="submit">
							<img class="w-full" src="../img/${eventosSegunPreferencias.URLImagen}" alt="Evento">
							<div class="mt-4">
								<h2 class="text-xl font-semibold mb-2">${eventosSegunPreferencias.nombre}</h2>
								<p class="text-gray-700">Fecha: ${eventosSegunPreferencias.fecha}</p>
								<p class="text-gray-700">Localidad: ${eventosSegunPreferencias.localidad}</p>
								<p class="text-gray-700">Disponibilidad:
										${eventosSegunPreferencias.disponibilidad}</p>
							</div>
						</button>
					</form>
					<div class="flex justify-center mt-6">
						<c:if test="${eventosSegunPreferencias.disponibilidad>0}">
							<a href="asistir?eventoId=${eventosSegunPreferencias.id}" class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full mr-2">Asistir</a>
						</c:if>
						<c:if test="${eventosSegunPreferencias.disponibilidad==0}">
							<a href="#" class="bg-gray-500 cursor-not-allowed text-white font-bold py-2 px-4 rounded-full mr-2">Cupo lleno</a>
						</c:if>
						<c:if test="${usuario.isAdmin}">
							<a class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full ml-2" href="eliminar?eventoId=${eventosSegunPreferencias.id}">Eliminar</a>
						</c:if>

					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	</div>
	<div class="flex justify-evenly px-6 pt-4 pb-2 my-4">
		<a
			class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full"
			href="mostrar-eventos">Ver todos los eventos</a>

		<c:if test="${not empty sessionScope.usuario}">
			<a
				class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full"
				href="filtrar-preferencias?idUsuario=${sessionScope.usuario.id}">
				Ver eventos recomendados para mi </a>
		</c:if>



		<c:if test="${usuario.isAdmin}">
			<a
				class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full"
				href="registrar-evento">Registra un evento</a>
		</c:if>




	</div>

	<div class="w-full mx-auto mt-2">
		<div id="carousel" class="owl-carousel owl-theme">
			<div class="item"><img src="../img/1.png" alt="Imagen 1"></div>
			<div class="item"><img src="../img/2.png" alt="Imagen 1"></div>
			<div class="item"><img src="../img/3.png" alt="Imagen 1"></div>
			<div class="item"><img src="../img/4.png" alt="Imagen 1"></div>
		</div>
	</div>


	<!-- Footer  -->

	<footer class="bg-violet-500 py-8">
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

	<c:if test="${mostrarPopup}">
		<div
			class="fixed inset-0 flex items-center justify-center bg-gray-900 bg-opacity-50">
			<div class="bg-white rounded-md shadow-lg p-4">
				<p class="text-lg text-gray-800">Para tu exquisitez no hay
					resultados, amplia la busqueda</p>
				<br> <a href="home"
					class=" flex justify-center mt-4 px-4 py-2 bg-violet-500 text-white rounded-md hover:bg-violet-600">Aceptar</a>
			</div>
		</div>
	</c:if>
	<script src="https://cdn.tailwindcss.com"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>

	<script>
		$(document).ready(function() {
			$("#carousel").owlCarousel({
				items: 1,
				loop: true,
				dots: false,
				autoplay: true,
				autoplayTimeout: 3000,
				autoplayHoverPause: true
			});
		});
	</script>
	<script>
		var username = localStorage.getItem("username");
		var usernameElement = document.getElementById("username");
		usernameElement.textContent = !username ? "" : username;
	</script>

</body>

</html>