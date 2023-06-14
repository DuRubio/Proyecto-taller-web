package ar.edu.unlam.tallerweb1.domain;

import javax.persistence.*;

import ar.edu.unlam.tallerweb1.delivery.DatosRegistracion;

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

    private String tipoEvento;
    private String tipoLugar;
    private String horario;
    private String edades;
    
    /*
    private Boolean musical;
    private Boolean deportivo;
    private Boolean bailable;
    private Boolean teatral;
    private Boolean recital;
    private Boolean cine;
    private Boolean cultural;
    private Boolean gastronomico;
    private Boolean feria;
    private Boolean marcha;
    private Boolean infantil;
    private Boolean juvenil;
    private Boolean adultos;
    private Boolean jubilados;
    private Boolean todasLasEdades;
    private Boolean aireLibre;
    private Boolean teatro;
    private Boolean estadio;
    private Boolean centroCultural;
    private Boolean matutino;
    private Boolean vespertino;
    private Boolean nocturno;
    */
    
    
    /*
     * Modificar esto a string como evento
     * 
     * cambiar checkbox por botones
     * 
     * 1 opcion por variable (lugar, hora, etc)
     */

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
     * Que los campos sean enum en los eventos 
     * y boolean en los usuarios
     * para que elijan más de uno
     * 
     * 
     * Modificar lógica de preferencias
     * Agregar check en pantalla de registro
     * 
     * Pensar más adelante cómo hacer andar el editar preferencias
     * 
     * 
     * 
     */

    public Usuario() {}
    
    public Usuario(DatosRegistracion datosRegistro) {
    	setCorreo(datosRegistro.getCorreo());
        setClave(datosRegistro.getClave());
        setNombre(datosRegistro.getNombre());
        setApellido(datosRegistro.getApellido());
        setLocalidad(datosRegistro.getLocalidad());
    }

    /*
    public Usuario() {
    	setMusical(false);
        setDeportivo(false);
        setBailable(false);
        setTeatral(false);
        setRecital(false);
        setCine(false);
        setCultural(false);
        setGastronomico(false);
        setFeria(false);
        setMarcha(false);
        setInfantil(false);
        setJuvenil(false);
        setAdultos(false);
        setJubilados(false);
        setTodasLasEdades(false);
        setAireLibre(false);
        setTeatro(false);
        setEstadio(false);
        setCentroCultural(false);
        setMatutino(false);
        setVespertino(false);
        setNocturno(false);
    }

    public Usuario(String nombre, String apellido, String localidad, String correo, String clave) {
        setNombre(nombre);
        setApellido(apellido);
        setLocalidad(localidad);
        setCorreo(correo);
        setClave(clave);
        setMusical(false);
        setDeportivo(false);
        setBailable(false);
        setTeatral(false);
        setRecital(false);
        setCine(false);
        setCultural(false);
        setGastronomico(false);
        setFeria(false);
        setMarcha(false);
        setInfantil(false);
        setJuvenil(false);
        setAdultos(false);
        setJubilados(false);
        setTodasLasEdades(false);
        setAireLibre(false);
        setTeatro(false);
        setEstadio(false);
        setCentroCultural(false);
        setMatutino(false);
        setVespertino(false);
        setNocturno(false);
    }
    
    public Usuario(DatosRegistracion datosRegistro) {
        setCorreo(datosRegistro.getCorreo());
        setClave(datosRegistro.getClave());
        setMusical(datosRegistro.getMusical());
        setDeportivo(datosRegistro.getDeportivo());
        setBailable(datosRegistro.getBailable());
        setTeatral(datosRegistro.getTeatral());
        setRecital(datosRegistro.getRecital());
        setCine(datosRegistro.getCine());
        setCultural(datosRegistro.getCultural());
        setGastronomico(datosRegistro.getGastronomico());
        setFeria(datosRegistro.getFeria());
        setMarcha(datosRegistro.getMarcha());
        setInfantil(datosRegistro.getInfantil());
        setJuvenil(datosRegistro.getJuvenil());
        setAdultos(datosRegistro.getAdultos());
        setJubilados(datosRegistro.getJubilados());
        setTodasLasEdades(datosRegistro.getTodasLasEdades());
        setAireLibre(datosRegistro.getAireLibre());
        setTeatro(datosRegistro.getTeatro());
        setEstadio(datosRegistro.getEstadio());
        setCentroCultural(datosRegistro.getCentroCultural());
        setMatutino(datosRegistro.getMatutino());
        setVespertino(datosRegistro.getVespertino());
        setNocturno(datosRegistro.getNocturno());
    }

    public Usuario(String correo, String clave) {
        setCorreo(correo);
        setClave(clave);
        setMusical(false);
        setDeportivo(false);
        setBailable(false);
        setTeatral(false);
        setRecital(false);
        setCine(false);
        setCultural(false);
        setGastronomico(false);
        setFeria(false);
        setMarcha(false);
        setInfantil(false);
        setJuvenil(false);
        setAdultos(false);
        setJubilados(false);
        setTodasLasEdades(false);
        setAireLibre(false);
        setTeatro(false);
        setEstadio(false);
        setCentroCultural(false);
        setMatutino(false);
        setVespertino(false);
        setNocturno(false);
    }
    */

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
    
    public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getTipoLugar() {
		return tipoLugar;
	}

	public void setTipoLugar(String tipoLugar) {
		this.tipoLugar = tipoLugar;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getEdades() {
		return edades;
	}

	public void setEdades(String edades) {
		this.edades = edades;
	}

    /*
	public Boolean getMusical() {
		return musical;
	}

	public void setMusical(Boolean musical) {
		this.musical = musical;
	}

	public Boolean getDeportivo() {
		return deportivo;
	}

	public void setDeportivo(Boolean deportivo) {
		this.deportivo = deportivo;
	}

	public Boolean getBailable() {
		return bailable;
	}

	public void setBailable(Boolean bailable) {
		this.bailable = bailable;
	}

	public Boolean getTeatral() {
		return teatral;
	}

	public void setTeatral(Boolean teatral) {
		this.teatral = teatral;
	}

	public Boolean getRecital() {
		return recital;
	}

	public void setRecital(Boolean recital) {
		this.recital = recital;
	}

	public Boolean getCine() {
		return cine;
	}

	public void setCine(Boolean cine) {
		this.cine = cine;
	}

	public Boolean getMarcha() {
		return marcha;
	}

	public void setMarcha(Boolean marcha) {
		this.marcha = marcha;
	}

	public Boolean getCultural() {
		return cultural;
	}

	public void setCultural(Boolean cultural) {
		this.cultural = cultural;
	}

	public Boolean getGastronomico() {
		return gastronomico;
	}

	public void setGastronomico(Boolean gastronomico) {
		this.gastronomico = gastronomico;
	}

	public Boolean getFeria() {
		return feria;
	}

	public void setFeria(Boolean feria) {
		this.feria = feria;
	}

	public Boolean getInfantil() {
		return infantil;
	}

	public void setInfantil(Boolean infantil) {
		this.infantil = infantil;
	}

	public Boolean getJuvenil() {
		return juvenil;
	}

	public void setJuvenil(Boolean juvenil) {
		this.juvenil = juvenil;
	}

	public Boolean getAdultos() {
		return adultos;
	}

	public void setAdultos(Boolean adultos) {
		this.adultos = adultos;
	}

	public Boolean getJubilados() {
		return jubilados;
	}

	public void setJubilados(Boolean jubilados) {
		this.jubilados = jubilados;
	}

	public Boolean getTodasLasEdades() {
		return todasLasEdades;
	}

	public void setTodasLasEdades(Boolean todasLasEdades) {
		this.todasLasEdades = todasLasEdades;
	}

	public Boolean getAireLibre() {
		return aireLibre;
	}

	public void setAireLibre(Boolean aireLibre) {
		this.aireLibre = aireLibre;
	}

	public Boolean getTeatro() {
		return teatro;
	}

	public void setTeatro(Boolean teatro) {
		this.teatro = teatro;
	}

	public Boolean getEstadio() {
		return estadio;
	}

	public void setEstadio(Boolean estadio) {
		this.estadio = estadio;
	}

	public Boolean getCentroCultural() {
		return centroCultural;
	}

	public void setCentroCultural(Boolean centroCultural) {
		this.centroCultural = centroCultural;
	}

	public Boolean getMatutino() {
		return matutino;
	}

	public void setMatutino(Boolean matutino) {
		this.matutino = matutino;
	}

	public Boolean getVespertino() {
		return vespertino;
	}

	public void setVespertino(Boolean vespertino) {
		this.vespertino = vespertino;
	}

	public Boolean getNocturno() {
		return nocturno;
	}

	public void setNocturno(Boolean nocturno) {
		this.nocturno = nocturno;
	}
    */
	
    
}
