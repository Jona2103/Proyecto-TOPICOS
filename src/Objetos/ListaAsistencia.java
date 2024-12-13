/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author 52311
 */
public class ListaAsistencia {
    private String fecha;
    private Grupo g;
    private boolean asistencia;

    public ListaAsistencia(String fecha, Grupo g, boolean asistencia) {
        this.fecha = fecha;
        this.g = g;
        this.asistencia = asistencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Grupo getG() {
        return g;
    }

    public void setG(Grupo g) {
        this.g = g;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListaAsistencia{");
        sb.append("fecha=").append(fecha);
        sb.append(", g=").append(g);
        sb.append(", asistencia=").append(asistencia);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
