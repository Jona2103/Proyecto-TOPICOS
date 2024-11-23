/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author 52311
 */
public class Instalacion {
    private String nombre;
    private String tipo;
    private String Ubicacion;

    public Instalacion(String nombre, String tipo, String Ubicacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.Ubicacion = Ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instalacion{");
        sb.append("nombre=").append(nombre);
        sb.append(", tipo=").append(tipo);
        sb.append(", Ubicacion=").append(Ubicacion);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
