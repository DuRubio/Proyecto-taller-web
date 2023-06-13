<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<form:form action="guardar-preferencias-usuario" method="POST">
				<h3 class="form-signin-heading">Mis Preferencias</h3>
				<hr class="colorgraph">
				<br>

				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="true"
						id="musical"> <label class="form-check-label"
						for="musical"> Musical </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="deportivo"
						id="deportivo"> <label
						class="form-check-label" for="deportivo"> Deportivo
						 </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="bailable"
						id="bailable"> <label class="form-check-label"
						for="bailable"> Bailable </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="teatral"
						id="teatral"> <label
						class="form-check-label" for="teatral"> Teatral
						 </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="recital"
						id="recital"> <label class="form-check-label"
						for="recital"> Recital </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="cine"
						id="cine" > <label
						class="form-check-label" for="cine"> Cine
						 </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="cultural"
						id="cultural"> <label class="form-check-label"
						for="cultural"> Cultural </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="gastronomico"
						id="gastronomico" > <label
						class="form-check-label" for="gastronomico"> Gastronómico
						 </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="feria"
						id="feria"> <label class="form-check-label"
						for="feria"> Feria </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="marcha"
						id="marcha"> <label
						class="form-check-label" for="marcha"> Marcha
						 </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="infantil"
						id="infantil"> <label class="form-check-label"
						for="infantil"> Infantil </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="juvenil"
						id="juvenil"> <label
						class="form-check-label" for="juvenil"> Juvenil
						 </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="adultos"
						id="adultos"> <label class="form-check-label"
						for="adultos"> Adultos </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="jubilados"
						id="jubilados" > <label
						class="form-check-label" for="jubilados"> Jubilados
						 </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="todasLasEdades"
						id="todasLasEdades"> <label class="form-check-label"
						for="todasLasEdades"> Todas las edades </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="aireLibre"
						id="aireLibre" > <label
						class="form-check-label" for="aireLibre"> Aire Libre
						 </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="teatro"
						id="teatro"> <label class="form-check-label"
						for="teatro"> Teatro </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="estadio"
						id="estadio"> <label
						class="form-check-label" for="estadio"> Estadio
						 </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="centroCultural"
						id="centroCultural"> <label class="form-check-label"
						for="centroCultural"> Centro Cultural </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="matutino"
						id="matutino" > <label
						class="form-check-label" for="matutino"> Matutino
						 </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="vespertino"
						id="vespertino"> <label class="form-check-label"
						for="vespertino"> Vespertino </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="nocturno"
						id="nocturno" > <label
						class="form-check-label" for="nocturno"> Nocturno
						 </label>
				</div>

				
				<br>
				<br>
				<br>

				<button id="btn-registrarme"
					class="btn btn-lg btn-primary btn-block" Type="Submit" />Guardar</button>
			</form:form>

			<c:if test="${not empty mensaje}">
				<h4>
					<span>${mensaje}</span>
				</h4>
				<br>
			</c:if>
		</div>
	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>