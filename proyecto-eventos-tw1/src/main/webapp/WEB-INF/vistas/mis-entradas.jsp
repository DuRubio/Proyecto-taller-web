<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<script src="https://cdn.tailwindcss.com"></script>
<title>Listado de Eventos</title>
</head>
<nav
	class="flex items-center justify-between flex-wrap bg-violet-500 p-6">
	<div class="flex items-center flex-shrink-0 text-white mr-6">
		<img src="../img/logo.png" alt="" class="w-8 m-1 rounded"> <span
			class="font-semibold text-xl tracking-tight">Mi App de Eventos</span>
	</div>
	<div class="w-full block flex-grow lg:flex lg:items-center lg:w-auto">
		<div class="text-sm lg:flex-grow">
			<input
				class="bg-violet-800 appearance-none border-2 border-violet-800 rounded py-2 px-4 text-violet-300 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
				type="text" placeholder="Buscar...">
		</div>
		<div>
			<a href="#" class="mx-2 text-white hover:text-violet-300"> <i
				class="fa-solid fa-bell"></i>
			</a> <a href="#" class="mx-2 text-white hover:text-violet-300"> <i
				class="fa-solid fa-user"></i>
			</a>
		</div>
	</div>
</nav>
<body class="bg-gray-100">
	<h1 class="text-4xl text-center font-bold mt-8">Mis Entradas</h1>

	<div class="max-w-6xl mx-auto mt-8">
		<div
			class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
			<c:forEach items="${entradas}" var="entrada">
				<div class="bg-white shadow-md rounded p-6">
					<div class="mt-4">
						<h2 class="text-xl font-semibold mb-2">Identificador entrada:
							${entrada.id}</h2>
						<p class="text-gray-700">Evento: ${entrada.evento.nombre}</p>
						<p class="text-gray-700">Localidad:
							${entrada.evento.localidad}</p>
						<p class="text-gray-700">Lugar: ${entrada.evento.lugar}</p>
						<p class="text-gray-700">Fecha: ${entrada.evento.fecha}</p>
						<p class="text-gray-700">Tipo de Evento: ${entrada.evento.categoria.nombre}</p>
						<!-- <p class="text-gray-700">Fecha: ${evento.fecha}</p>
                    <p class="text-gray-700">Localidad: ${evento.localidad}</p>
                    <p class="text-gray-700">Disponibilidad: ${evento.disponibilidad}</p>  -->
						<div class="flex justify-center mt-6">
							<a href="entrada?entradaId=${entrada.id}"
								class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full">Ver QR</a>
						</div>
						<!-- 
						<form action="entrada/${entrada.id}" method="get">
							<input type="hidden" name="id" value="${entrada.id}">
							<div class="flex justify-center px-6 pt-4 pb-2">
								<button type="submit"
									class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full">Ver
									Entrada</button>
							</div>
						</form>
						 -->
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<div class="flex justify-center px-6 pt-4 pb-2">
		<a
			class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full"
			href="home">Volver a home</a>
	</div>

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


</body>

</html>