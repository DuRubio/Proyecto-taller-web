<%--
  Created by IntelliJ IDEA.
  User: ailuv
  Date: 11/5/2023
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://cdn.tailwindcss.com"></script>
  <title>Mis preferencias</title>
</head>

<body class="bg-gray-100">
<div class="flex items-center justify-center h-screen">
  <div class="flex items-center justify-center w-full max-w-5xl">
    <img src="./img/evento-cultural.jpg" alt="Image" class="w-1/2 h-auto object-cover">
    <div class="w-1/2 h-96 px-6 py-8 bg-white">
      <h1 class="text-3xl font-semibold mb-6">Seleccioná tus preferencias</h1>
      <div class="flex flex-wrap items-center gap-4">
        <label for="recitales" class="px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600 cursor-pointer">
          <input id="recitales" type="checkbox" class="hidden" name="category[]" value="recitales">
          Recitales
        </label>
        <label for="partidos" class="px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600 cursor-pointer">
          <input id="partidos" type="checkbox" class="hidden" name="category[]" value="partidos">
          Partidos de fútbol
        </label>
        <label for="peliculas" class="px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600 cursor-pointer">
          <input id="peliculas" type="checkbox" class="hidden" name="category[]" value="peliculas">
          Películas
        </label>
        <label for="teatro" class="px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600 cursor-pointer">
          <input id="teatro" type="checkbox" class="hidden" name="category[]" value="teatro">
          Obras de teatro
        </label>
      </div>
    </div>
  </div>
</div>
</body>

</html>
