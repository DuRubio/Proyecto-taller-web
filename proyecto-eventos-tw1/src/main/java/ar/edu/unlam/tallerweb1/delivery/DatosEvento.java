package ar.edu.unlam.tallerweb1.delivery;

import java.util.Date;

public class DatosEvento {
    private String nombre;
    private Date fecha;
    private String lugar;
    private String localidad;
    private String tipoEvento;
    private String tipoLugar;
    private String horario;
    private String edades;


    public DatosEvento() {
    }

    public DatosEvento(String nombre, Date fecha, String lugar, String localidad, String tipoEvento, String tipoLugar, String edades, String horario) {
        setNombre(nombre);
        setFecha(fecha);
        setLugar(lugar);
        setLocalidad(localidad);
        setTipoLugar(tipoLugar);
    	setHorario(horario);
    	setEdades(edades);
    	setTipoEvento(tipoEvento);
    	setLocalidad(localidad);
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

	
}
