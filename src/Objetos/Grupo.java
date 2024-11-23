/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author 52311
 */
public class Grupo {
    private String horario;
    private ActividadExtraescolar A;
    private Persona In;
    private Persona [] E;
    private Instalacion I;
    private byte capacidad;
    private ListaAsistencia Li;

    public Grupo(String horario, ActividadExtraescolar A, Persona In, Persona[] E, Instalacion I, byte capacidad, ListaAsistencia Li) {
        this.horario = horario;
        this.A = A;
        this.In = In;
        this.E = E;
        this.I = I;
        this.capacidad = capacidad;
        this.Li = Li;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ActividadExtraescolar getA() {
        return A;
    }

    public void setA(ActividadExtraescolar A) {
        this.A = A;
    }

    public Persona getIn() {
        return In;
    }

    public void setIn(Persona In) {
        this.In = In;
    }

    public Persona[] getE() {
        return E;
    }

    public void setE(Persona[] E) {
        this.E = E;
    }

    public Instalacion getI() {
        return I;
    }

    public void setI(Instalacion I) {
        this.I = I;
    }

    public byte getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(byte capacidad) {
        this.capacidad = capacidad;
    }

    public ListaAsistencia getLi() {
        return Li;
    }

    public void setLi(ListaAsistencia Li) {
        this.Li = Li;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grupo{");
        sb.append("horario=").append(horario);
        sb.append(", A=").append(A);
        sb.append(", In=").append(In);
        sb.append(", E=").append(E);
        sb.append(", I=").append(I);
        sb.append(", capacidad=").append(capacidad);
        sb.append(", Li=").append(Li);
        sb.append('}');
        return sb.toString();
    }
    
}
