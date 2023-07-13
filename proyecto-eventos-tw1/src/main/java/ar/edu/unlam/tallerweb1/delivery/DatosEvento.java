package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DatosEvento {
    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private String localidad;
    private TipoDeEvento tipo;

    private String categoria;
    private Integer disponibilidad;

    private String imagen;


    public DatosEvento() {
    }
/*
    public DatosEvento(String nombre, TipoDeEvento tipo, String localidad, Integer disponibilidad) {
        setNombre(nombre);
        setTipo(tipo);
        setLocalidad(localidad);
        setDisponibilidad(disponibilidad);
    }

    public DatosEvento(String nombre, TipoDeEvento tipo, String localidad) {
    	setNombre(nombre);
    	setTipo(tipo);
    	setLocalidad(localidad);
    }
*/

public DatosEvento(String nombre, String categoria, String localidad, Integer disponibilidad, String fecha) {
        setNombre(nombre);
        setCategoria(categoria);
        setLocalidad(localidad);
        setDisponibilidad(disponibilidad);
        setFecha(fecha);
    }

    public DatosEvento(String nombre, String categoria, String localidad, String lugar ,Integer disponibilidad, String fecha) {
        setNombre(nombre);
        setCategoria(categoria);
        setLocalidad(localidad);
        setLugar(lugar);
        setDisponibilidad(disponibilidad);
        setFecha(fecha);

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

    public void setFecha(String fechaB) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.fecha = LocalDate.parse(fechaB, formatter);

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

    public TipoDeEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeEvento tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Integer disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
}
