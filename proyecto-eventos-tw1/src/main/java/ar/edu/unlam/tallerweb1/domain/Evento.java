package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.DatosEvento;
import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Evento {

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private Date fecha;
    private String localidad;
    private String URLImagen;
    private String lugar;
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
    
    private Boolean eventoActivo;

    public Evento (){
    }
    
    public Evento(String nombre, Date fecha, String lugar, String localidad) {
    	setNombre(nombre);
    	setFecha(fecha);
    	setLugar(lugar);
    	setLocalidad(localidad);
    	setEventoActivo(true);
    }
    
    public Evento(DatosEvento datosEvento) {
    	setNombre(datosEvento.getNombre());
    	//setFecha(datosEvento.getFecha());
    	setLugar(datosEvento.getLugar());
    	setLocalidad(datosEvento.getLocalidad());
    	setMusical(datosEvento.getMusical());
        setDeportivo(datosEvento.getDeportivo());
        setBailable(datosEvento.getBailable());
        setTeatral(datosEvento.getTeatral());
        setRecital(datosEvento.getRecital());
        setCine(datosEvento.getCine());
        setCultural(datosEvento.getCultural());
        setGastronomico(datosEvento.getGastronomico());
        setFeria(datosEvento.getFeria());
        setMarcha(datosEvento.getMarcha());
        setInfantil(datosEvento.getInfantil());
        setJuvenil(datosEvento.getJuvenil());
        setAdultos(datosEvento.getAdultos());
        setJubilados(datosEvento.getJubilados());
        setTodasLasEdades(datosEvento.getTodasLasEdades());
        setAireLibre(datosEvento.getAireLibre());
        setTeatro(datosEvento.getTeatro());
        setEstadio(datosEvento.getEstadio());
        setCentroCultural(datosEvento.getCentroCultural());
        setMatutino(datosEvento.getMatutino());
        setVespertino(datosEvento.getVespertino());
        setNocturno(datosEvento.getNocturno());
    	setEventoActivo(true);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getURLImagen() {
        return URLImagen;
    }

    public void setURLImagen(String URLImagen) {
        this.URLImagen = URLImagen;
    }
	
    public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

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

	public Boolean getEventoActivo() {
		return eventoActivo;
	}

	public void setEventoActivo(Boolean eventoActivo) {
		this.eventoActivo = eventoActivo;
	}

	

	

	

    
    
}