// DECLARACION DE VARIABLES
const pdfViewer = document.getElementById('pdfViewer');
let periodo = document.getElementById("periodo");
let anio = document.getElementById("anio");
let nLegajo = document.getElementById("nLegajo").innerHTML;

function abrirRecibo(legajo) {
    const inicioURL = 'http://localhost:8080/cccproyect/recibos/';
    const anioURL = anio.value + '/';
    const mesURL = periodo.value + '/';
    const legajoURL = legajo;
    const finalURL = '.pdf';
    const url = inicioURL + anioURL + mesURL + legajoURL + finalURL;
    pdfViewer.src = url;
    console.log('Visualizando pdf', url);
}

function seleccionarAnio() {

    console.log(anio);
    switch (anio.value) {
        case "2024":
            seleccionarMes();
            break;
        case "2023":
            seleccionarMes();
            break;
        case "2022":
            seleccionarMes();
            break;
        case "2021":
            seleccionarMes();
            break;
        case "2020":
            seleccionarMes();
            break;
        case "2019":
            seleccionarMes();
            break;
        case "2018":
            seleccionarMes();
            break;
        case "2017":
            seleccionarMes();
            break;
        case "2016":
            seleccionarMes();
            break;
        case "2015":
            seleccionarMes();
            break;
        case "2014":
            seleccionarMes();
            break;
        case "2013":
            seleccionarMes();
            break;
        default:
    }
}

function seleccionarMes() {

    console.log(periodo);
    switch (periodo.value) {
        case "12":
            abrirRecibo(nLegajo);
            pdfViewer.style.display = "block";
            console.log('Haberes de Diciembre ', anio.value);
            break;
        case "11":
            abrirRecibo(nLegajo);
            pdfViewer.style.display = "block";
            console.log('Haberes de Noviembre ', anio.value);
            break;
        case "10":
            abrirRecibo(nLegajo);
            pdfViewer.style.display = "block";
            console.log('Haberes de Octubre ', anio.value);
            break;
        case "09":
            abrirRecibo(nLegajo);
            pdfViewer.style.display = "block";
            console.log('Haberes de Septiembre ', anio.value);
            break;
        case "08":
            abrirRecibo(nLegajo);
            pdfViewer.style.display = "block";
            console.log('Haberes de Agosto ', anio.value);
            break;
        case "07":
            abrirRecibo(nLegajo);
            pdfViewer.style.display = "block";
            console.log('Haberes de Julio ', anio.value);
            break;
        case "06":
            abrirRecibo(nLegajo);
            pdfViewer.style.display = "block";
            console.log('Haberes de Junio ', anio.value);
            break;
        case "05":
            abrirRecibo(nLegajo);
            pdfViewer.style.display = "block";
            console.log('Haberes de Mayo ', anio.value);
            break;
        case "04":
            abrirRecibo(nLegajo);
            pdfViewer.style.display = "block";
            console.log('Haberes de Abril ', anio.value);
            break;
        case "03":
            abrirRecibo(nLegajo);
            pdfViewer.style.display = "block";
            console.log('Haberes de Marzo ', anio.value);
            break;
        case "02":
            abrirRecibo(nLegajo);
            pdfViewer.style.display = "block";
            console.log('Haberes de Febrero ', anio.value);
            break;
        case "01":
            abrirRecibo(nLegajo);
            pdfViewer.style.display = "block";
            console.log('Haberes de Enero ', anio.value);
            break;
        default:
    }
}

periodo.addEventListener('change', (e) => {
    e.preventDefault();
    seleccionarMes();
});

anio.addEventListener('change', (e) => {
    e.preventDefault();
    seleccionarAnio();
});

