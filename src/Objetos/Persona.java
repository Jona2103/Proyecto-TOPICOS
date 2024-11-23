/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author 52311
 */
public class Persona {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private Instituto i;
    private Carrera c;
    private String rol;

    public Persona(String nombre, String apellidoP, String apellidoM, Instituto i, Carrera c, String rol) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.i = i;
        this.c = c;
        this.rol = rol;
    }

    public Persona(String nombre, String apellidoP, String apellidoM, Instituto i, String rol) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.i = i;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Instituto getI() {
        return i;
    }

    public void setI(Instituto i) {
        this.i = i;
    }

    public Carrera getC() {
        return c;
    }

    public void setC(Carrera c) {
        this.c = c;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellidoP=").append(apellidoP);
        sb.append(", apellidoM=").append(apellidoM);
        sb.append(", i=").append(i);
        sb.append(", c=").append(c);
        sb.append(", rol=").append(rol);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
