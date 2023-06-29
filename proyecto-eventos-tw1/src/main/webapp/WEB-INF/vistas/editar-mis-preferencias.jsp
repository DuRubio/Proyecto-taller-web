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
                <input class="form-check-input" type="checkbox" name="deportivo" id="deportivo" value="true"/>
                <label class="form-check-label" for="deportivo">Deportivo</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="musical" id="musical" value="true"/>
                <label class="form-check-label" for="musical">Musical</label>
            </div>

            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="bailable" id="bailable" value="true"/>
                <label class="form-check-label" for="bailable">Bailable</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="teatral" id="teatral" value="true"/>
                <label class="form-check-label" for="teatral">Teatral</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="recital" id="recital" value="true"/>
                <label class="form-check-label" for="recital">Recital</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="cine" id="cine" value="true"/>
                <label class="form-check-label" for="cine">Cine</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="cultural" id="cultural" value="true"/>
                <label class="form-check-label" for="cultural">Cultural</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gastronomico" id="gastronomico" value="true"/>
                <label class="form-check-label" for="gastronomico">Gastronomico</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="feria" id="feria" value="true"/>
                <label class="form-check-label" for="feria">Feria</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="marcha" id="marcha" value="true"/>
                <label class="form-check-label" for="marcha">Marcha</label>
            </div>

            <!-- Agrega los dem�s checkboxes aqu� -->

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