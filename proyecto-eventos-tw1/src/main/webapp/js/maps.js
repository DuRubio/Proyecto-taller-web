
var mapaDiv = document.getElementById("mapa");


var lugarEvento = document.getElementById("lugarEvento").value;


var urlsMapas = {
    "Vorterix": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3284.948732502583!2d-58.453486223374334!3d-34.580163756256184!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95bcb5e77287c945%3A0xbaff5332b9e61c29!2sVorterix!5e0!3m2!1ses!2sar!4v1689198738119!5m2!1ses!2sar",
    "Movistar Arena": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3284.3933781916226!2d-58.450601223373965!3d-34.594212956997815!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95bcb5eb6fb40a93%3A0x1fcab11b62b55896!2sMovistar%20Arena!5e0!3m2!1ses!2sar!4v1689198714464!5m2!1ses!2sar",
    "Teatro Gran Rex": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3284.0307924284343!2d-58.38144152337346!3d-34.603382857482!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95bccaceed5746b9%3A0xf933ab84305babc0!2sTeatro%20Gran%20Rex!5e0!3m2!1ses!2sar!4v1689198693032!5m2!1ses!2sar",
    "Hipodromo de San Isidro": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3288.8802038901063!2d-58.52332722337822!3d-34.48056315100606!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95bcb040d363f587%3A0x78e513cecbc25f7f!2sHip%C3%B3dromo%20de%20San%20Isidro!5e0!3m2!1ses!2sar!4v1689198669952!5m2!1ses!2sar",
    "Hipodromo de Palermo": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3285.3955067555066!2d-58.42856722337479!3d-34.56885775565959!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95bcb5a28c37ff9b%3A0x289b0f07f03e748b!2sHip%C3%B3dromo%20de%20Palermo!5e0!3m2!1ses!2sar!4v1689198624664!5m2!1ses!2sar",
    "Teatro Opera": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3284.011865861379!2d-58.381533223373424!3d-34.60386145750751!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95bccacef2a6afd9%3A0x68043201aaa9f1d0!2sTeatro%20%C3%93pera%20Orbis!5e0!3m2!1ses!2sar!4v1689198599281!5m2!1ses!2sar",
    "Luna Park": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3284.085988993353!2d-58.37149272337353!3d-34.60198705740826!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95a335325f19f9a3%3A0xfd34b93fba734a98!2sLuna%20Park!5e0!3m2!1ses!2sar!4v1689198574736!5m2!1ses!2sar",
    "Club Paraguay": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3404.708996782527!2d-64.19459862348985!3d-31.422142796531283!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x943298711745fcb7%3A0xe908841f4004216d!2sClub%20Paraguay!5e0!3m2!1ses!2sar!4v1689198547120!5m2!1ses!2sar",
    "Estadio Mas Monumental": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3286.3259479474114!2d-58.45234982337582!3d-34.54530175441704!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95bcb43ae6018ddf%3A0x3d7f60a75bfa308a!2sEstadio%20M%C3%A2s%20Monumental!5e0!3m2!1ses!2sar!4v1689198518375!5m2!1ses!2sar",
    "Estadio Alberto J. Armando": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3282.755800594863!2d-58.36475629999999!3d-34.635610899999996!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95a334b6925e5473%3A0x1ca5b2748858b40d!2sEstadio%20Alberto%20J.%20Armando-%20La%20Bombonera!5e0!3m2!1ses!2sar!4v1689198473360!5m2!1ses!2sar",
    "Estadio Mario Alberto Kempes": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3406.6395318648433!2d-64.24872812349163!3d-31.368924993960192!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94329ecc4516ee49%3A0x52b97a2b4d3699bf!2sEstadio%20Mario%20Alberto%20Kempes!5e0!3m2!1ses!2sar!4v1689198451951!5m2!1ses!2sar",
    "Estadio Ciudad de La Plata": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3271.7074897402154!2d-57.99168322336168!3d-34.9137894739413!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95a2e796c35ba77f%3A0xfa546c6ec8fdfd96!2sEstadio%20Unico%20Diego%20Armando%20Maradona!5e0!3m2!1ses!2sar!4v1689198402264!5m2!1ses!2sar",
    "Centro Cultural Kirchner": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3284.0217348131796!2d-58.3697291!3d-34.6036119!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95a3353283598701%3A0xff14e7edde2f5152!2sCentro%20Cultural%20Kirchner%20(CCK)!5e0!3m2!1ses!2sar!4v1689198378752!5m2!1ses!2sar",
    "Nuevo Espacio Mad Cool": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d97327.61383809752!2d-3.840759737500011!3d40.3315208!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd42276d80c70b89%3A0x16310bb05551ba7b!2sMAD%20COOL%20Festival!5e0!3m2!1ses!2sar!4v1689198352226!5m2!1ses!2sar",
    "Estadio Santiago Bernabéu": "https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12144.01775991697!2d-3.6883337!3d40.4530387!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd4228e23705d39f%3A0xa8fff6d26e2b1988!2sStade%20Santiago-Bernab%C3%A9u!5e0!3m2!1sfr!2sar!4v1689193398561!5m2!1sfr!2sar",
    "Estadio Camp Nou": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2993.6862912792008!2d2.120244875308609!3d41.38089999639872!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x12a498f576297baf%3A0x44f65330fe1b04b9!2sCamp%20Nou!5e0!3m2!1sfr!2sar!4v1689193719464!5m2!1sfr!2sar",
    "Le Parc des Princes": "https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d10503.51831964161!2d2.2530484!3d48.8414356!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e67ac09948a18d%3A0xdd2450406cef2c5c!2sLe%20Parc%20des%20Princes!5e0!3m2!1sfr!2sar!4v1689193271185!5m2!1sfr!2sar"
};


if (urlsMapas.hasOwnProperty(lugarEvento)) {

    var iframe = document.createElement("iframe");
    iframe.src = urlsMapas[lugarEvento];
    iframe.width = "400";
    iframe.height = "300";
    iframe.style.border = "0";
    iframe.allowfullscreen = "";
    iframe.loading = "lazy";
    iframe.referrerpolicy = "no-referrer-when-downgrade";


    mapaDiv.appendChild(iframe);
} else {

    mapaDiv.innerHTML = "No se encontró un mapa para este evento.";
}
