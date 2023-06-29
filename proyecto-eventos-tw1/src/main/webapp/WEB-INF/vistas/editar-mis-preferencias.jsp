<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Mis Preferencias</title>
</head>

<body class="bg-gray-100">
<div class="container m-auto mt-10">
    <div id="loginbox" class="m-auto w-2/3 md:w-1/2 lg:w-1/3 xl:w-1/4">
        <form action="guardar-preferencias-usuario" method="POST" class="bg-white shadow-md rounded px-8 py-6">
            <h3 class="text-2xl font-bold mb-4">Mis Preferencias</h3>
            <hr class="border-t-2 border-gray-300 mb-4">
            <br>
            <div class="flex flex-wrap items-center gap-4">
                <label for="deportivo" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="deportivo" type="checkbox" class="hidden" name="deportivo" value="true">
                    Deportivo
                </label>

                <label for="musical" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="musical" type="checkbox" class="hidden" name="musical" value="true">
                    Musical
                </label>

                <label for="bailable" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="bailable" type="checkbox" class="hidden" name="bailable" value="true">
                    Bailable
                </label>

                <label for="teatral" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="teatral" type="checkbox" class="hidden" name="teatral" value="true">
                    Teatral
                </label>

                <label for="recital" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="recital" type="checkbox" class="hidden" name="recital" value="true">
                    Recital
                </label>

                <label for="cine" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="cine" type="checkbox" class="hidden" name="cine" value="true">
                    Cine
                </label>

                <label for="cultural" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="cultural" type="checkbox" class="hidden" name="cultural" value="true">
                    Cultural
                </label>

                <label for="gastronomico" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="gastronomico" type="checkbox" class="hidden" name="gastronomico" value="true">
                    Gastronomico
                </label>

                <label for="feria" class="px-4 py-2 text-white bg-violet-300 rounded-md hover:bg-violet-600 cursor-pointer checkbox-label">
                    <input id="feria" type="checkbox" class="hidden" name="feria" value="true">
                    Feria
                </label>
            </div>
            <br>
            <br>
            <br>
            <button id="btn-registrarme" class="w-full bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded" type="submit">Guardar</button>
        </form>

        <c:if test="${not empty mensaje}">
            <h4>
                <span>${mensaje}</span>
            </h4>
            <br>
        </c:if>
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
    window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
</script>
<script>
    const checkboxes = document.querySelectorAll('input[type="checkbox"]');

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            const label = this.parentElement;
            if (this.checked) {
                label.classList.add('bg-violet-600');
                label.classList.remove('bg-violet-300');
            } else {
                label.classList.add('bg-violet-300');
                label.classList.remove('bg-violet-600');
            }
        });
    });
</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>

</html>