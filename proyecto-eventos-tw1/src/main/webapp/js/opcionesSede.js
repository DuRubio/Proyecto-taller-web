const localidadSelect = document.getElementById('localidad');
const lugarSelect = document.getElementById('lugar');

const opcionesLugar = {
    'Buenos Aires': ['Vorterix', 'Movistar Arena', 'Teatro Gran Rex', 'Hipódromo de San Isidro', 'Hipódromo de Palermo', 'Teatro Ópera', 'Luna Park', 'Estadio Mâs Monumental', 'Estadio Alberto J. Armando', 'Estadio Ciudad de La Plata', 'Centro Cultural Kirchner'],
    'Córdoba': ['Estadio Mario Alberto Kempes', 'Club Paraguay'],
    'Madrid': ['Nuevo Espacio Mad Cool', 'Estadio Santiago Bernabéu'],
    'Barcelona': ['Estadio Camp Nou'],
    'Paris': ['Le Parc des Princes']
};

function generarOpcionesLugar() {

    console.log("generando lugares")

    const localidadSeleccionada = localidadSelect.value;


    lugarSelect.innerHTML = '';


    if (localidadSeleccionada && opcionesLugar.hasOwnProperty(localidadSeleccionada)) {

        const opciones = opcionesLugar[localidadSeleccionada];


        opciones.forEach(opcion => {
            const option = document.createElement('option');
            option.value = opcion;
            console.log(option.value)
            option.textContent = opcion;
            lugarSelect.appendChild(option);
        });
    }
}


localidadSelect.addEventListener('change', generarOpcionesLugar);