package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;
import org.mindrot.jbcrypt.BCrypt;
import util.ConexionDB;

public class EmpleadosDAO {

    public void agregarEmpleado(Empleado empleado) {
        String sql = "INSERT INTO empleados (nombreCompleto, documento, legajo, contrasena, fecha_alta) VALUES (?, ?, ?, ?, ?)";
        //bloque try-with-resources
        //asegura que los recursos abiertos en su declaración (dentro de los paréntesis) se cierren automáticamente al final del bloque try 
        try (Connection conn = ConexionDB.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empleado.getNombreCompleto());
            pstmt.setString(2, empleado.getDocumento());
            pstmt.setInt(3, empleado.getLegajo());
            String passEnc = encriptarContrasena(empleado.getPassword());
            pstmt.setString(4, passEnc);
            pstmt.setDate(5, empleado.getFechaAlta());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String encriptarContrasena(String contrasena) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(contrasena, salt);
    }

    public Empleado obtenerPorLegajo(int legajo) {
        String sql = "SELECT * FROM empleados WHERE legajo = ?";
        try (Connection conn = ConexionDB.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, legajo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("id"));
                empleado.setNombreCompleto(rs.getString("nombre"));
                empleado.setDocumento(rs.getString("documento"));
                empleado.setLegajo(rs.getInt("legajo"));
                empleado.setFechaAlta(rs.getDate("fecha_alta"));
                return empleado;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Empleado> obtenerTodos() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try (Connection conn = ConexionDB.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("id"));
                empleado.setNombreCompleto(rs.getString("nombre"));
                empleado.setDocumento(rs.getString("documento"));
                empleado.setLegajo(rs.getInt("legajo"));
                empleado.setFechaAlta(rs.getDate("fecha_alta"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public void actualizarEmpleado(Empleado empleado) {
        String sql = "UPDATE empleados SET nombre = ?, apellido = ?, legajo = ?, fecha_alta = ? WHERE id = ?";
        try (Connection conn = ConexionDB.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empleado.getNombreCompleto());
            pstmt.setString(2, empleado.getDocumento());
            pstmt.setInt(3, empleado.getLegajo());
            pstmt.setDate(4, empleado.getFechaAlta());
            pstmt.setInt(5, empleado.getIdEmpleado());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEmpleado(int legajo) {
        String sql = "DELETE FROM empleados WHERE legajo = ?";
        try (Connection conn = ConexionDB.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, legajo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
