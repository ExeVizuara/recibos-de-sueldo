document.getElementById("btn_ingresar").addEventListener("click", logueo);
document.getElementById("btn_registrarse").addEventListener("click", registro);
window.addEventListener("resize", anchoPagina);

// DECLARACION DE VARIABLES
var contenedor__usuario = document.querySelector(".contenedor_usuario");
var formulario__login = document.querySelector(".formulario_login");
var formulario__registro = document.querySelector(".formulario_registro");
var caja_trasera_l = document.querySelector(".caja_tr_login");
var caja_trasera_r = document.querySelector(".caja_tr_registro");

// FUNCIONES
function logueo(){
    if(window.innerWidth > 850){
        formulario__registro.style.display = "none";
        contenedor__usuario.style.left = "10px";
        formulario__login.style.display = "block";
        caja_trasera_r.style.opacity = "1";
        caja_trasera_l.style.opacity = "0";
    }else{
        formulario__registro.style.display = "none";
        contenedor__usuario.style.left = "0px";
        formulario__login.style.display = "block";
        caja_trasera_r.style.display = "block";
        caja_trasera_l.style.display = "none";
    }
}

function registro(){
    if(window.innerWidth > 850){
        formulario__registro.style.display = "block";
        contenedor__usuario.style.left = "410px";
        formulario__login.style.display = "none";
        caja_trasera_r.style.opacity = "0";
        caja_trasera_l.style.opacity = "1";
    }else{
        formulario__registro.style.display = "block";
        contenedor__usuario.style.left = "0px";
        formulario__login.style.display = "none";
        caja_trasera_r.style.display = "none";
        caja_trasera_l.style.display = "block";
        caja_trasera_l.style.opacity = "1";
    }
}

function anchoPagina(){
    if(window.innerWidth > 850){
        caja_trasera_l.style.display = "block";
        caja_trasera_r.style.display = "block";
    }else{
        caja_trasera_r.style.display = "block";
        caja_trasera_r.style.opacity = "1";
        caja_trasera_l.style.display = "none";
        formulario__login.style.display = "block";
        formulario__registro.style.display = "none";
        contenedor__usuario.style.left = "0px";
    }
}

anchoPagina();
