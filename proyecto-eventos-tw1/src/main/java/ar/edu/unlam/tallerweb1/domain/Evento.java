package ar.edu.unlam.tallerweb1.domain;

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
    private LocalDate fecha;
    private String lugar;
    private String localidad;
    private String URLImagen;
    private Boolean musica;
    private Boolean deporte;
    private Boolean cultural;
    private Boolean gastronomico;
    private Boolean feria;
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
    
    public Evento(String nombre, LocalDate fecha, String lugar, String localidad) {
    	setNombre(nombre);
    	setFecha(fecha);
    	setLugar(lugar);
    	setLocalidad(localidad);
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

    public String getURLImagen() {
        return URLImagen;
    }

    public void setURLImagen(String URLImagen) {
        this.URLImagen = URLImagen;
    }

	public Boolean getMusica() {
		return musica;
	}

	public void setMusica(Boolean musica) {
		this.musica = musica;
	}

	public Boolean getDeporte() {
		return deporte;
	}

	public void setDeporte(Boolean deporte) {
		this.deporte = deporte;
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

	@Override
	public int hashCode() {
		return Objects.hash(adultos, aireLibre, centroCultural, cultural, deporte, estadio, fecha, feria, gastronomico,
				infantil, jubilados, juvenil, localidad, lugar, matutino, musica, nocturno, nombre, teatro,
				todasLasEdades, vespertino);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(adultos, other.adultos) && Objects.equals(aireLibre, other.aireLibre)
				&& Objects.equals(centroCultural, other.centroCultural) && Objects.equals(cultural, other.cultural)
				&& Objects.equals(deporte, other.deporte) && Objects.equals(estadio, other.estadio)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(feria, other.feria)
				&& Objects.equals(gastronomico, other.gastronomico) && Objects.equals(infantil, other.infantil)
				&& Objects.equals(jubilados, other.jubilados) && Objects.equals(juvenil, other.juvenil)
				&& Objects.equals(localidad, other.localidad) && Objects.equals(lugar, other.lugar)
				&& Objects.equals(matutino, other.matutino) && Objects.equals(musica, other.musica)
				&& Objects.equals(nocturno, other.nocturno) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(teatro, other.teatro) && Objects.equals(todasLasEdades, other.todasLasEdades)
				&& Objects.equals(vespertino, other.vespertino);
	}

    
    
}
