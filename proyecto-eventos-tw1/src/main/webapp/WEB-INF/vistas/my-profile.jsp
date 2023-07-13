<%-- Created by IntelliJ IDEA. User: ailuv Date: 13/6/2023 Time: 20:39 To change this template use File | Settings |
    File Templates. --%>
<%@ page import="ar.edu.unlam.tallerweb1.domain.Entrada"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://cdn.tailwindcss.com"></script>
<title>Mi perfil</title>
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
			<img src="./img/coachella.jpeg" alt="Image"
				class="w-1/2 h-auto object-cover">
			<div class="w-1/2 px-6 py-8 bg-white">

				<!-- Imagen de perfil -->
				<div class="flex justify-center items-center mb-4">

					<img src="../img/perfil.png" alt="Imagen de perfil"
						class="w-16 h-16 rounded-full">
				</div>

				<!-- Nombre y Apellido -->
				<h1 class="text-2xl font-bold text-center mb-4">${usuario.nombre}
					${usuario.apellido}</h1>

				<!-- Email -->
				<p class="text-gray-700 mb-4">
					<strong>Email:</strong> ${usuario.correo}
				</p>

				<!-- Contraseña -->

				<a class="block text-violet-500 text-italic text-sm mb-4 underline"
					href="/my-profile/cambiar-clave?usuarioId=${usuario.id}">Cambiar
					contraseña</a>

				<h2 class="text-2xl font-semibold">Mis Preferencias</h2>

				<c:forEach items="${categorias}" var="categoria">
					<div class="bg-white shadow-md rounded p-6">
						<p class="text-gray-700">${categoria.nombre}</p>
					</div>
				</c:forEach>


				<!-- Localidad -->
				<p class="text-gray-700 mb-4">
					<strong>Localidad:</strong> ${usuario.localidad}
				</p>
				<div class="flex justify-evenly px-6 pt-4 pb-2 my-4">
					<a
						class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full"
						href="mis-entradas">Ver Mis Entradas</a>
				</div>

				<c:if test="${!usuario.isAdmin}">
					<div class="flex items-center mb-4">
						<form action="/my-profile/admin" method="POST">
							<div class="flex items-center mb-4">
								<label for="claveAdmin" class="mr-2">Quiero crear mis
									propios eventos:</label> <input type="text" id="claveAdmin"
									name="claveAdmin" placeholder="Ingresá tu token"
									class="w-full bg-white border border-gray-300 rounded py-2 px-4 focus:outline-none focus:ring-2 focus:ring-purple-500">
								<button type="submit"
									class="block bg-violet-500 hover:bg-purple-600 text-white font-bold py-2 px-4 rounded mx-2 disabled:opacity-50">Enviar</button>
							</div>
						</form>
					</div>

				</c:if>
				<c:if test="${usuario.isAdmin}">
					<h2 class="text-center text-lg font-bold mb-2">¡${usuario.nombre}
						ya sos Admininstrador!</h2>
					<a href="/my-profile/notadmin"
						class="flex justify-center mx-2 text-purple-500 underline cursor-pointer rounded-lg mb-4">Dejar
						de ser admin</a>
				</c:if>


				<a href="editar-mis-preferencias"
					class="block bg-violet-500 hover:bg-purple-600 text-white font-bold py-2 px-4 rounded">Actualizar
					preferencias</a>
			</div>
		</div>
	</div>



	<div class="flex justify-center px-6 pt-4 pb-2">
		<a
			class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full"
			href="home">Volver a home</a>
	</div>


	<c:if test="${mostrarPopup}">
		<div
			class="fixed inset-0 flex items-center justify-center bg-gray-900 bg-opacity-50">
			<div class="bg-white rounded-md shadow-lg p-4">
				<p class="text-lg text-gray-800 text-center">A partir de ahora
					sos Administrador</p>
				<br> <a href="/home"
					class=" flex justify-center mt-4 px-4 py-2 bg-violet-500 text-white rounded-md hover:bg-violet-600">Aceptar</a>
			</div>
		</div>
	</c:if>

	<c:if test="${mostrarPopup2}">
		<div
			class="fixed inset-0 flex items-center justify-center bg-gray-900 bg-opacity-50">
			<div class="bg-white rounded-md shadow-lg p-4">
				<p class="text-lg text-gray-800 text-center">La clave es
					incorrecta, no eres admin</p>
				<br> <a href="/my-profile"
					class=" flex justify-center mt-4 px-4 py-2 bg-violet-500 text-white rounded-md hover:bg-violet-600">Aceptar</a>
			</div>
		</div>
	</c:if>

</body>
<footer class="bg-violet-500 py-8 bottom-0 mt-20">
	<div class="container mx-auto px-4">
		<div class="flex flex-wrap justify-between">
			<div class="w-full lg:w-6/12 pr-4">
				<p class="text-white italic">Somos una plataforma especializada
					en la venta de entradas de espectáculos de alta demanda y ofrecemos
					servicios para la gestión de ingresos a eventos de distinta índole.</p>
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
<script>
	function mostrarPopUp() {
		var popUp = document.getElementById("pop-up");
		popUp.classList.remove("hidden");
	}

	function ocultarPopUp() {
		var popUp = document.getElementById("pop-up");
		popUp.classList.add("hidden");
	}

	function actualizarContraseña(event) {
		event.preventDefault();

		var claveNuevaInput = document.getElementById("claveNueva");
		var claveNueva = claveNuevaInput.value;

		usuario.clave = claveNueva;

		ocultarPopUp();
	}
	/*  function validarClave() {
	                  var claveInput = document.getElementById("clave");
	                  var botonEnviar = document.getElementById("setAdmin");
	            
	                  if (claveInput.value === "eventos1234") {
	                  botonEnviar.disabled = false;
	              } else {
	                  botonEnviar.disabled = true;
	              }
	              }
	            
	              var username = "${usuario.nombre}";
	                localStorage.setItem("username", username);
	            
	                function validarClave() {
	                    var claveInput = document.getElementById("clave");
	                    var botonEnviar = document.getElementById("setAdmin");
	            
	                    if (claveInput.value === "eventos1234") {
	                        botonEnviar.disabled = false;
	                    } else {
	                        botonEnviar.disabled = true;
	                    }
	                }*/
</script>

</html>