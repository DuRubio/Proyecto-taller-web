<%--
  Created by IntelliJ IDEA.
  User: Duilio
  Date: 7/7/2023
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Registra un evento</title>
</head>
<body class="flex items-center justify-center h-screen bg-gray-100">
<div class="w-96 p-6 bg-white rounded shadow-md">
    <h1 class="text-2xl font-semibold text-center">Crear evento</h1>
    <h2 class="text-2l font-semibold text-center">Paso 2/2</h2>
    <form method="post" action="subir-foto" enctype="multipart/form-data">


        <label for="imagen" class="block mb-1">Subir una Imagen:</label>
        <div class="relative flex items-start">
            <input type="file" id="imagen" name="imagen" class="px-4 py-2 bg-violet-500 text-white rounded-md cursor-pointer hover:bg-violet-600" >
        </div>
        <br>
        <button type="submit"
                class="w-full px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Crear Evento</button>

    </form>
    <div class="flex justify-center px-6 pt-4 pb-2"><a class="bg-transparent hover:bg-violet-500 text-violet-700 font-semibold hover:text-white border border-violet-500 hover:border-transparent rounded py-2 px-4 rounded" href="home">Volver a home</a>
    </div>

</div>
</body>
</html>



