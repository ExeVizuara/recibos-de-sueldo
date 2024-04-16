<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
        <link href="../estilos/estilos.css" rel="stylesheet" type="text/css">
        <title>Compañia de Circuitos Cerrados S.A.</title>
    </head>
    <body>
        <header class="contenedor">
            <div class="navbar">
                <div class="logo">
                    <img src="../img/LogoCCC.png" alt="logo">
                </div>
                <div class="titulo">
                    <h1>Compañia de Circuitos Cerrados S.A.</h1>
                </div>
            </div>
            <div class="container col-lg-5 mt-3">
                <div class="row">
                    <div class="col">
                        <select id="anio" class="form-select form-select-sm mb-3 d-grid gap-2 col-3 mx-auto text-danger-emphasis bg-light-subtle" aria-label="Large select example">
                            <option selected>Año</option>
                            <option value="2024">2024</option>
                            <option value="2023">2023</option>
                            <option value="2022">2022</option>
                            <option value="2021">2021</option>
                            <option value="2020">2020</option>
                            <option value="2019">2019</option>
                            <option value="2018">2018</option>
                            <option value="2017">2017</option>
                            <option value="2016">2016</option>
                            <option value="2015">2015</option>
                            <option value="2014">2014</option>
                            <option value="2013">2013</option>
                        </select>
                    </div>
                    <div class="col">
                        <select id="periodo" class="form-select form-select-sm mb-3 d-grid gap-2 col-3 mx-auto text-danger-emphasis bg-light-subtle" aria-label="Large select example">
                            <option selected>Mes</option>
                            <option value="12">Diciembre</option>
                            <option value="11">Noviembre</option>
                            <option value="10">Octubre</option>
                            <option value="09">Septiembre</option>
                            <option value="08">Agosto</option>
                            <option value="07">Julio</option>
                            <option value="06">Junio</option>
                            <option value="05">Mayo</option>
                            <option value="04">Abril</option>
                            <option value="03">Marzo</option>
                            <option value="02">Febrero</option>
                            <option value="01">Enero</option>
                        </select>
                    </div>
                </div>
                <p id="nLegajo" hidden>${legajo}</p>
                <div class="d-flex justify-content-center">
                    <embed id="pdfViewer" type="application/pdf" width="500" height="600" display="none" />
                </div>
            </div>
        </header>
        <script src="../javascript/scriptsLogueado.js"></script>
    </body>
</html>