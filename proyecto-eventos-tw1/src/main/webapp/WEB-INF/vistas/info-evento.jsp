<%--
  Created by IntelliJ IDEA.
  User: ailuv
  Date: 6/7/2023
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Información del evento</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <script src="https://cdn.tailwindcss.com"></script>
  <style>
    .bgcolor{
      background-color: #E6E6E6;
    }
  </style>
</head>
<body class="bg-gray-100">
<div class="bgcolor shadow-md rounded p-6 m-auto max-w-5xl mt-8">
  <div class="grid grid-cols-2 gap-8">
    <div class="col-span-1">
      <h1 class="text-2xl font-bold mb-4">${evento.nombre}</h1>
      <img src="../img/${evento.URLImagen}" alt="Imagen del evento" class="w-full max-w-lg mb-4">
      <p class="text-gray-500 mb-2">${evento.localidad}</p>
      <p class="text-gray-500 mb-2">${evento.fecha}</p>
      <div class="mt-4">
        <c:if test="${evento.disponibilidad>0}">
          <a href="/asistir?eventoId=${evento.id}" class="bg-violet-500 hover:bg-violet-700 text-white  font-bold py-2 px-4 rounded-full">Asistir</a>
        </c:if>
      </div>
    </div>
    <div class="col-span-1">
      <div class="flex flex-col justify-between h-full">
        <div>
          <h2 class="text-xl font-bold mb-4">Mapa del evento</h2>
          <div id="mapa" class="w-full h-64 mb-4">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d105073.45340215511!2d-58.51569866452951!3d-34.61565477017335!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95bcca3b4ef90cbd%3A0xa0b3812e88e88e87!2sBuenos%20Aires%2C%20CABA!5e0!3m2!1ses!2sar!4v1688678711928!5m2!1ses!2sar" width="400" height="300" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
          </div>
        </div>
        <br>
        <br>
        <div>
          <h2 class="text-xl font-bold mb-4">Clima en la ciudad</h2>
          <div class="flex flex-wrap">
            <div class="w-full md:w-1/2 lg:w-1/3">
              <div>
                <p class="text-gray-500 mb-2">Datos del clima</p>
                <img id="weatherIcon" alt="Weather Icon" src="../img/${weatherData.weather.get(0).icon}.png">
              </div>
            </div>
            <div class="w-full md:w-1/2 lg:w-1/3 px-4">
              <div>
                <h2>${weatherData.name}</h2>
                <c:set var="celsiusTemp" value="${weatherData.main.temp - 273.15}" />
                <p>${String.format("%.2f", celsiusTemp)}°C</p>
              </div>
            </div>
          </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<div class="flex justify-center px-6 pt-4 pb-2 mt-4"><a class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full" href="/home">Volver a home</a></div>

</body>
</html>

