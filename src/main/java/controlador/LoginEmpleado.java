package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import util.ConexionDB;

//La URL en la anotación debe reflejar cómo quieres acceder al servlet desde el navegador,
//no su ubicación en la estructura de carpetas del proyecto
@WebServlet("/loginEmpleado")
public class LoginEmpleado extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String legajo = request.getParameter("legajo_login");
        String password = request.getParameter("password_login");

        if (autenticarUsuario(legajo, password)) {
            // Usuario autenticado con éxito
            HttpSession session = request.getSession();
            session.setAttribute("legajo", legajo);

            response.sendRedirect("vistas/verRecibos.jsp"); // Redirigir a la página de gestion
            //request.getRequestDispatcher("vistas/verRecibos.jsp").forward(request, response);
        } else {
            // Autenticación fallida
            request.setAttribute("error", "Legajo y/o contraseña incorrectos.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private boolean autenticarUsuario(String legajo, String password) {
        // Aquí va la lógica para conectarse a la base de datos y verificar las credenciales
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // cerrando los recursos manualmente
        try {
            conn = ConexionDB.conectar(); // Asume que tienes un método estático getConnection en tu clase Conexion
            String sql = "SELECT * FROM empleados WHERE legajo = ?"; // Modifica la consulta para obtener el usuario por legajo
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, legajo);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Obtiene la contraseña almacenada en la base de datos
                String passDB = rs.getString("contrasena");

                // Verifica la contraseña ingresada con la almacenada utilizando BCrypt
                if (verificarContrasena(password, passDB)) {
                    // Las credenciales son correctas
                    return true;
                } else {
                    System.out.println("ERROR: Contraseña incorrecta.");
                    return false;
                }
            } else {
                System.out.println("ERROR: Legajo no encontrado en el sistema.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private boolean verificarContrasena(String pass, String passDB) {
        return BCrypt.checkpw(pass, passDB);
    }
}
