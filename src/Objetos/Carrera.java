/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author 52311
 */
public class Carrera {
    private String nombre;
    private String carrera;

    public Carrera(String nombre, String carrera) {
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrera{");
        sb.append("nombre=").append(nombre);
        sb.append(", carrera=").append(carrera);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
