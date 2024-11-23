/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author 52311
 */
public class ActividadExtraescolar {
    private String nombre;
    private String descripcion;
    private String tipoCreedito;

    public ActividadExtraescolar(String nombre, String descripcion, String tipoCreedito) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoCreedito = tipoCreedito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoCreedito() {
        return tipoCreedito;
    }

    public void setTipoCreedito(String tipoCreedito) {
        this.tipoCreedito = tipoCreedito;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActividadExtraescolar{");
        sb.append("nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", tipoCreedito=").append(tipoCreedito);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
