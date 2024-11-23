/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author 52311
 */
public class Usuario {
    private Persona p;
    private String estatus;
    private String fechaalta;
    private String fechabaja;
    private String nombreU;
    private String password;

    public Usuario(Persona p, String estatus, String fechaalta, String fechabaja, String nombreU, String password) {
        this.p = p;
        this.estatus = estatus;
        this.fechaalta = fechaalta;
        this.fechabaja = fechabaja;
        this.nombreU = nombreU;
        this.password = password;
    }

    
    
    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(String fechaalta) {
        this.fechaalta = fechaalta;
    }

    public String getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(String fechabaja) {
        this.fechabaja = fechabaja;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("p=").append(p);
        sb.append(", estatus=").append(estatus);
        sb.append(", fechaalta=").append(fechaalta);
        sb.append(", fechabaja=").append(fechabaja);
        sb.append(", nombreU=").append(nombreU);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }
    
    
}
