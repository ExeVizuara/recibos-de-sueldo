package controlador;

import dao.EmpleadosDAO;
import modelo.Empleado;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.http.HttpSession;

@WebServlet("/registroEmpleado")
public class RegistroEmpleado extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener datos del formulario
        String nombre = request.getParameter("nombre");
        String documento = request.getParameter("dni_registro");
        int legajo = Integer.parseInt(request.getParameter("legajo_registro"));
        String pass = request.getParameter("password_registro");

        Empleado empleado = new Empleado();
        empleado.setNombreCompleto(nombre);
        empleado.setDocumento(documento);
        empleado.setLegajo(legajo);
        empleado.setPassword(pass);
        java.util.Date fechaActual = new java.util.Date(); //es una forma de utilizar la clase sin necesitar una declaracion 'import'
        empleado.setFechaAlta(new Date(fechaActual.getTime()));
        EmpleadosDAO empleadosDAO = new EmpleadosDAO();
        empleadosDAO.agregarEmpleado(empleado);

        HttpSession session = request.getSession();
        session.setAttribute("legajo", legajo);
        response.sendRedirect(request.getContextPath() + "/vistas/verRecibos.jsp");
    }
}

