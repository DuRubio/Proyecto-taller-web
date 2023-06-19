
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Medios de Pago</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        .hidden {
            display: none;
        }

        .mpbutton{
            width:200px;
        }
    </style>
</head>
<body class="flex items-center justify-center h-screen bg-gray-100">
<div class="w-96 p-6 bg-white rounded shadow-md">
    <h1 class="text-2xl font-semibold text-center">Medios de Pago</h1>
    <form id="paymentForm" class="mt-4">
        <div>
            <label for="paymentMethod" class="block mb-1">Seleccione un medio de pago:</label>
            <select id="paymentMethod" onchange="toggleFields()"
                    class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-violet-500" required>
                <option value="debitCard">Tarjeta de Débito</option>
                <option value="creditCard">Tarjeta de Crédito</option>
                <option value="mercadoPago">Mercado Pago</option>
            </select>
        </div>

        <div id="debitCardFields" class="hidden mt-4">
            <h2 class="text-lg font-semibold">Información de Tarjeta de Débito</h2>
            <label for="debitCardNumber" class="block mb-1">Número de Tarjeta:</label>
            <input type="text" id="debitCardNumber" maxlength="12" required
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-violet-500"><br>

            <label for="debitCardExpiration" class="block mb-1">Fecha de Vencimiento:</label>
            <input type="text" id="debitCardExpiration" required
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-violet-500"><br>

            <label for="debitCardSecurityCode" class="block mb-1">Código de Seguridad:</label>
            <input type="text" id="debitCardSecurityCode" required
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-violet-500"><br>

            <label for="debitCardHolderName" class="block mb-1">Nombre del Titular:</label>
            <input type="text" id="debitCardHolderName" required
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-violet-500"><br>
        </div>

        <div id="creditCardFields" class="hidden mt-4">
            <h2 class="text-lg font-semibold">Información de Tarjeta de Crédito</h2>
            <label for="creditCardNumber" class="block mb-1">Número de Tarjeta:</label>
            <input type="text" id="creditCardNumber" maxlength="12" required
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-violet-500"><br>

            <label for="creditCardExpiration" class="block mb-1">Fecha de Vencimiento:</label>
            <input type="text" id="creditCardExpiration" required
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-violet-500"><br>

            <label for="creditCardSecurityCode" class="block mb-1">Código de Seguridad:</label>
            <input type="text" id="creditCardSecurityCode" required
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-violet-500"><br>

            <label for="creditCardHolderName" class="block mb-1">Nombre del Titular:</label>
            <input type="text" id="creditCardHolderName" required
                   class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-violet-500"><br>

            <label for="installments" class="block mb-1">Cantidad de Cuotas:</label>
            <select id="installments"
                    class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-violet-500">
                <option value="3">3 cuotas</option>
                <option value="6">6 cuotas</option>
                <option value="12">12 cuotas</option>
            </select>
        </div>

        <div id="mercadoPagoFields" class="hidden mt-4 flex justify-center">
            <a href="https://www.mercadopago.com" target="_blank"
               class="flex justify-center bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full block mpbutton">Ir a Mercado Pago</a>
        </div>

        <br>
        <input type="submit" value="Pagar"
               class="w-full px-4 py-2 bg-violet-500 text-white rounded-md hover:bg-violet-700">
        <br><br>
        <input type="submit" value="Cancelar" onclick="window.location.href='/home';"
               class="w-full px-4 py-2 bg-violet-500 text-white rounded-md hover:bg-violet-700">
    </form>
</div>



<script>
    function toggleFields() {
        var paymentMethod = document.getElementById("paymentMethod").value;
        var debitCardFields = document.getElementById("debitCardFields");
        var creditCardFields = document.getElementById("creditCardFields");
        var mercadoPagoFields = document.getElementById("mercadoPagoFields");

        if (paymentMethod === "debitCard") {
            debitCardFields.classList.remove("hidden");
            creditCardFields.classList.add("hidden");
            mercadoPagoFields.classList.add("hidden");
        } else if (paymentMethod === "creditCard") {
            debitCardFields.classList.add("hidden");
            creditCardFields.classList.remove("hidden");
            mercadoPagoFields.classList.add("hidden");
        } else if (paymentMethod === "mercadoPago") {
            debitCardFields.classList.add("hidden");
            creditCardFields.classList.add("hidden");
            mercadoPagoFields.classList.remove("hidden");
        }
    }
</script>
</body>
</html>