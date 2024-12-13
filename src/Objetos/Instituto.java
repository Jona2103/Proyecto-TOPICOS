/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author 52311
 */
public class Instituto {
    private String nombre;
    private String clave;
    private String entidad;
    private Carrera [] c;
    private Instalacion [] in;

    public Instituto(String nombre, String clave, String entidad, Carrera[] c, Instalacion[] in) {
        this.nombre = nombre;
        this.clave = clave;
        this.entidad = entidad;
        this.c = c;
        this.in = in;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public Carrera[] getC() {
        return c;
    }

    public void setC(Carrera[] c) {
        this.c = c;
    }

    public Instalacion[] getIn() {
        return in;
    }

    public void setIn(Instalacion[] in) {
        this.in = in;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instituto{");
        sb.append("nombre=").append(nombre);
        sb.append(", clave=").append(clave);
        sb.append(", entidad=").append(entidad);
        sb.append(", c=").append(c);
        sb.append(", in=").append(in);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}

