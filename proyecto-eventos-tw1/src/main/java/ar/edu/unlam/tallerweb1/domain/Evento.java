package ar.edu.unlam.tallerweb1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.unlam.tallerweb1.delivery.DatosEvento;

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
    private String tipoEvento;
    private String tipoLugar;
    private String horario;
    private String edades;
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
    
    public Evento(String nombre, Date fecha, String lugar,String localidad, String tipoEvento, String tipoLugar, String edades, String horario) {
    	setNombre(nombre);
    	setFecha(fecha);
    	setLugar(lugar);
    	setTipoLugar(tipoLugar);
    	setHorario(horario);
    	setEdades(edades);
    	setTipoEvento(tipoEvento);
    	setLocalidad(localidad);
    	setEventoActivo(true);
    }
    
    public Evento(DatosEvento datosEvento) {
    	setNombre(datosEvento.getNombre());
    	setFecha(datosEvento.getFecha());
    	setLugar(datosEvento.getLugar());
    	setTipoLugar(datosEvento.getTipoLugar());
    	setHorario(datosEvento.getHorario());
    	setEdades(datosEvento.getEdades());
    	setTipoEvento(datosEvento.getTipoEvento());
    	setLocalidad(datosEvento.getLocalidad());
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

	public Boolean getEventoActivo() {
		return eventoActivo;
	}

	public void setEventoActivo(Boolean eventoActivo) {
		this.eventoActivo = eventoActivo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edades, eventoActivo, fecha, horario, localidad, lugar, nombre, tipoEvento, tipoLugar);
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
		return Objects.equals(edades, other.edades) && Objects.equals(eventoActivo, other.eventoActivo)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(horario, other.horario)
				&& Objects.equals(localidad, other.localidad) && Objects.equals(lugar, other.lugar)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(tipoEvento, other.tipoEvento)
				&& Objects.equals(tipoLugar, other.tipoLugar);
	}

	

	

    
    
}
