package controlador;

import dao.EmpleadosDAO;
import modelo.Empleado;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/vistas/GestionEmpleadoServlet") //falta definir en que seccion estara la opcion para ingresar
public class GestionEmpleadoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        EmpleadosDAO empleadosDAO = new EmpleadosDAO();

        // Inicializar idOrador antes del switch para que esté disponible en todos los casos
        //int idEmpleado = Integer.parseInt(request.getParameter("id"));
        int legajo = Integer.parseInt(request.getParameter("legajo"));
        switch (accion) {
            case "actualizar":
                Empleado empleado = empleadosDAO.obtenerPorLegajo(legajo);
                request.setAttribute("empleado", empleado); //Esto permite pasar datos del servlet a una vista (como un archivo JSP) o a otro servlet al que se redirige o se reenvía la solicitud
                request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                break;
            case "confirmarActualizacion":
                Empleado empleadoActualizado = new Empleado();
                empleadoActualizado.setNombreCompleto("nombre");
                empleadoActualizado.setDocumento(request.getParameter("documento"));
                empleadoActualizado.setLegajo(legajo);
                // Asume que el método setFechaAlta acepta un java.sql.Date
                empleadoActualizado.setFechaAlta(java.sql.Date.valueOf(request.getParameter("fechaAlta")));

                empleadosDAO.actualizarEmpleado(empleadoActualizado);
                response.sendRedirect("gestionEmpleados.jsp");
                break;
            case "eliminar":
                empleadosDAO.eliminarEmpleado(legajo);
                response.sendRedirect("gestionEmpleados.jsp");
                break;
            default:
                response.sendRedirect("gestionEmpleados.jsp");
                break;
        }
    }
}
