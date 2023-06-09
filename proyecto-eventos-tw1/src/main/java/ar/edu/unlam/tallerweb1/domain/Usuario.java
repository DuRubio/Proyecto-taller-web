package ar.edu.unlam.tallerweb1.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(nullable = false)
    private String nombre;
   // @Column(nullable = false)
    private String apellido;
   // @Column(nullable = false)
    private String localidad;
    @Column(nullable = false, unique = true)
    private String correo;
    @Column(nullable = false)
    private String clave;


    /*
     * Funcionalidad: Permitir que los usuarios puedan filtrar eventos por sus preferencias
     * 
     * Agregar los siguientes campos a las tablas Usuario y Evento
     * 
     * Tipo de evento
     * Musica, Deporte, Cultural, Gastronomico, Feria, Todos
     * Edad
     * Infantil, Juvenil, Adultos, Todos
     * Lugar
     * Aire libre, Teatro, Estadio, Todas
     * Horario
     * Mañana, Tarde, Noche, Todas
     * 
     * Crear un botón en el inicio/home, que redirija a una pantalla y permita editar mis preferencias
     * La seleccion será mediante checkbox que setearan el valor en true
     * 
     * Las preferencias se setearan en false al registrarse
     * 
     * Crear boton de Filtrar por mis preferencias
     * 
     * Mostrará un listado de eventos que cumplen con alguna de las preferencias del usuario
     * 
     * 
     */


    public Usuario() {
    }



    public Usuario(String nombre, String apellido, String localidad, String correo, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.localidad = localidad;
        this.correo = correo;
        this.clave = clave;
    }

    public Usuario(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
