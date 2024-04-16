package modelo;

import java.sql.Date;

public class Empleado {
    private int idEmpleado;
    private String nombreCompleto;
    private String documento;
    private int legajo;
    private String password;
    private Date fechaAlta;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Constructor
    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDocumento() {
        return documento;
    }

    public int getLegajo() {
        return legajo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
}