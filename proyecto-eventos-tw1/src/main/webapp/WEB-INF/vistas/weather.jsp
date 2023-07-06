<%--
  Created by IntelliJ IDEA.
  User: ailuv
  Date: 2/7/2023
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Weather Information</title>
</head>
<body>
<h1>Weather Information</h1>

<form action="/weather/${cityId}">
    <input type="text" name="cityId" placeholder="Enter City ID">
    <button type="submit">Get Weather</button>
</form>

<c:choose>
    <c:when test="${not empty param.cityId}">
        <c:import url="/weather/${param.cityId}" var="weatherData" />
        <img id="weatherIcon" alt="Weather Icon">
        <h2>${weatherData}</h2>
    </c:when>
    <c:otherwise>
        <p>No weather data available</p>
    </c:otherwise>
</c:choose>

<script>
    // Obtén el código del icono del clima del objeto weatherData
    var iconCode = "${weatherData.weather[0].icon}";

    // Construye la URL de la imagen utilizando el código del icono
    var imageUrl = "../img/" + iconCode + ".png";

    // Asigna la URL de la imagen a la etiqueta de imagen con el id "weatherIcon"
    document.getElementById("weatherIcon").src = imageUrl;
</script>
</body>
</html>

