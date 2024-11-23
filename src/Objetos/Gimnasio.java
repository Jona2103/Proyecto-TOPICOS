/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author 52311
 */
public class Gimnasio {
    private String nombre;
    private Instituto i;
    private String ubicacion;
    private String horario;

    public Gimnasio(String nombre, Instituto i, String ubicacion, String horario) {
        this.nombre = nombre;
        this.i = i;
        this.ubicacion = ubicacion;
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Instituto getI() {
        return i;
    }

    public void setI(Instituto i) {
        this.i = i;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gimnasio{");
        sb.append("nombre=").append(nombre);
        sb.append(", i=").append(i);
        sb.append(", ubicacion=").append(ubicacion);
        sb.append(", horario=").append(horario);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
