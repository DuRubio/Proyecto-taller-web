package ar.edu.unlam.tallerweb1.delivery;

import java.time.LocalDate;
import java.util.Date;

public class DatosEvento {
    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private String localidad;
    private String tipo;


    public DatosEvento() {
    }

    public DatosEvento(String nombre, LocalDate fecha, String lugar, String localidad, String tipo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.localidad = localidad;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
