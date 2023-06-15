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
        <form:form action="guardar-preferencias-usuario" method="POST" modelAttribute="datosPreferencias">
            <h3 class="form-signin-heading">Mis Preferencias</h3>
            <hr class="colorgraph">
            <br>

            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="musical" id="musical"/>
                <label class="form-check-label" for="musical">Musical</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="deportivo" id="deportivo"/>
                <label class="form-check-label" for="deportivo">Deportivo</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="bailable" id="bailable"/>
                <label class="form-check-label" for="bailable">Bailable</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="teatral" id="teatral"/>
                <label class="form-check-label" for="teatral">Teatral</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="recital" id="recital"/>
                <label class="form-check-label" for="recital">Recital</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="cine" id="cine"/>
                <label class="form-check-label" for="cine">Cine</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="cultural" id="cultural"/>
                <label class="form-check-label" for="cultural">Cultural</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gastronomico" id="gastronomico"/>
                <label class="form-check-label" for="gastronomico">Gastronomico</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="feria" id="feria"/>
                <label class="form-check-label" for="feria">Feria</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="marcha" id="marcha"/>
                <label class="form-check-label" for="marcha">Marcha</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="infantil" id="infantil"/>
                <label class="form-check-label" for="infantil">Infantil</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="juvenil" id="juvenil"/>
                <label class="form-check-label" for="juvenil">Juvenil</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="adultos" id="adultos"/>
                <label class="form-check-label" for="adultos">Adultos</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="jubilados" id="jubilados"/>
                <label class="form-check-label" for="jubilados">Jubilados</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="todasLasEdades" id="todasLasEdades"/>
                <label class="form-check-label" for="todasLasEdades">Todas las edades</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="aireLibre" id="aireLibre"/>
                <label class="form-check-label" for="aireLibre">al Aire Libre</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="teatro" id="teatro"/>
                <label class="form-check-label" for="teatro">En Teatros</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="estadio" id="estadio"/>
                <label class="form-check-label" for="estadio">En Estadios</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="centroCultural" id="centroCultural"/>
                <label class="form-check-label" for="centroCultural">En Centros Culturales</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="matutino" id="matutino"/>
                <label class="form-check-label" for="matutino">Matutinos</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="vespertino" id="vespertino"/>
                <label class="form-check-label" for="vespertino">Vespertinos</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="nocturno" id="nocturno"/>
                <label class="form-check-label" for="nocturno">Nocturnos</label>
            </div>
            
            <!-- Agrega los demás checkboxes aquí -->

            <br>
            <br>
            <br>

            <button id="btn-registrarme" class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>
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