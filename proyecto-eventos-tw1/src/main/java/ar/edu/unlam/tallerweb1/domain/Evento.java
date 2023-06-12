package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.domain.enums.GrupoEtarioEvento;
import ar.edu.unlam.tallerweb1.domain.enums.HorarioEvento;
import ar.edu.unlam.tallerweb1.domain.enums.LugarEvento;
import ar.edu.unlam.tallerweb1.domain.enums.TipoDeEvento;

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
    private TipoDeEvento tipo;
    private HorarioEvento horario;
    private GrupoEtarioEvento edades;
    private LugarEvento lugar;
    private Boolean eventoActivo;

    public Evento (){
    }
    
    public Evento(String nombre, Date fecha, LugarEvento lugar, String localidad) {
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

	public TipoDeEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeEvento tipo) {
		this.tipo = tipo;
	}

	public HorarioEvento getHorario() {
		return horario;
	}

	public void setHorario(HorarioEvento horario) {
		this.horario = horario;
	}

	public GrupoEtarioEvento getEdades() {
		return edades;
	}

	public void setEdades(GrupoEtarioEvento edades) {
		this.edades = edades;
	}

	public LugarEvento getLugar() {
		return lugar;
	}

	public void setLugar(LugarEvento lugar) {
		this.lugar = lugar;
	}

	public Boolean getEventoActivo() {
		return eventoActivo;
	}

	public void setEventoActivo(Boolean eventoActivo) {
		this.eventoActivo = eventoActivo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edades, eventoActivo, fecha, horario, localidad, lugar, nombre, tipo);
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
		return edades == other.edades && Objects.equals(eventoActivo, other.eventoActivo)
				&& Objects.equals(fecha, other.fecha) && horario == other.horario
				&& Objects.equals(localidad, other.localidad) && lugar == other.lugar
				&& Objects.equals(nombre, other.nombre) && tipo == other.tipo;
	}

	

    
    
}
