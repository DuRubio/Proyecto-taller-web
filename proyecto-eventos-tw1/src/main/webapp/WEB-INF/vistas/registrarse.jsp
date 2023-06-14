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

		<form action="registrarme" method="POST" class="mt-4"
			modelAttribute="datosRegistracion">
			<div class="flex row align-items-center">
				<div class="col-6 p-2 bg-white rounded shadow-md">
					<div>
						<label for="correo" class="block mb-1">Correo:</label> <input
							id="correo" type="email" name="correo"
							class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
							placeholder="Ingresa tu correo">
					</div>
					<div class="mt-4">
						<label for="clave" class="block mb-1">Clave:</label> <input
							id="clave" type="password" name="clave"
							class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
							placeholder="Ingresa tu clave">
					</div>
					<div class="mt-4">
						<label for="nombre" class="block mb-1">Nombre:</label> <input
							id="nombre" type="text" name="nombre"
							class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
							placeholder="Ingresa tu nombre">
					</div>
					<div class="mt-4">
						<label for="apellido" class="block mb-1">Apellido:</label> <input
							id="apellido" type="text" name="apellido"
							class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
							placeholder="Ingresa tu apellido">
					</div>
					<div class="mt-4">
						<label for="localidad" class="block mb-1">Localidad:</label> <input
							id="localidad" type="text" name="localidad"
							class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500"
							placeholder="Ingresa tu localidad">
					</div>
				</div>
				<div class="col-6 p-2 bg-white rounded shadow-md ml-2">
					<h1 class="form-signin-heading">Mis Preferencias</h1>
					<hr class="colorgraph">
					<br>
					<h2 class="d-flex justify-content-center">Tipo de Evento
						Preferido</h2>
					<br>
					<div class="flex flex-wrap">

						<div class="col ">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="musical"
									id="musical" /> <label class="form-check-label" for="musical">Musical</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="deportivo"
									id="deportivo" /> <label class="form-check-label"
									for="deportivo">Deportivo</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="bailable"
									id="bailable" /> <label class="form-check-label"
									for="bailable">Bailable</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="teatral"
									id="teatral" /> <label class="form-check-label" for="teatral">Teatral</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="recital"
									id="recital" /> <label class="form-check-label" for="recital">Recital</label>
							</div>
						</div>
						<div class="col">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="cine"
									id="cine" /> <label class="form-check-label" for="cine">Cine</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="cultural"
									id="cultural" /> <label class="form-check-label"
									for="cultural">Cultural</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									name="gastronomico" id="gastronomico" /> <label
									class="form-check-label" for="gastronomico">Gastronómico</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="feria"
									id="feria" /> <label class="form-check-label" for="feria">Feria</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="marcha"
									id="marcha" /> <label class="form-check-label" for="marcha">Marcha</label>
							</div>
						</div>


					</div>
					<br>
					<h2 class="d-flex justify-content-center">Eventos</h2>
					<br>
					<div class="flex flex-wrap">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="infantil"
								id="infantil" /> <label class="form-check-label" for="infantil">Infantil</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="juvenil"
								id="juvenil" /> <label class="form-check-label" for="juvenil">Juvenil</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="adultos"
								id="adultos" /> <label class="form-check-label" for="adultos">Adultos</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="jubilados"
								id="jubilados" /> <label class="form-check-label"
								for="jubilados">Jubilados</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox"
								name="todasLasEdades" id="todasLasEdades" /> <label
								class="form-check-label" for="todasLasEdades">Todas las
								edades</label>
						</div>
					</div>
					<br>
					<h2 class="d-flex justify-content-center">Tipo de lugar del
						evento</h2>
					<br>
					<div class="flex flex-wrap">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="aireLibre"
								id="aireLibre" /> <label class="form-check-label"
								for="aireLibre">Al aire libre</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="teatro"
								id="teatro" /> <label class="form-check-label" for="teatro">En
								teatros</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="estadio"
								id="estadio" /> <label class="form-check-label" for="estadio">En
								estadios</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox"
								name="centroCultural" id="centroCultural" /> <label
								class="form-check-label" for="centroCultural">En centros
								culturales</label>
						</div>
					</div>
					<br>
					<h2 class="d-flex justify-content-center">Franja horaria</h2>
					<br>
					<div class="flex flex-wrap">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="matutino"
								id="matutino" /> <label class="form-check-label" for="matutino">Matutinos</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="vespertino"
								id="vespertino" /> <label class="form-check-label"
								for="vespertino">Vespertinos</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="nocturno"
								id="nocturno" /> <label class="form-check-label" for="nocturno">Nocturnos</label>
						</div>
					</div>
				</div>
			</div>
			<div class="mt-6">
				<button type="submit"
					class="w-full px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Registrarme</button>
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
