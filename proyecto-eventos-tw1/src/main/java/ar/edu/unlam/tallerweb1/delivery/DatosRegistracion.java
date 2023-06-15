package ar.edu.unlam.tallerweb1.delivery;

public class DatosRegistracion {

    private String correo;
    private String clave;
    private String nombre;
    private String apellido;
    private String localidad;

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

    public DatosRegistracion(String correo, String clave) {
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

    public DatosRegistracion() {
    }

    public DatosRegistracion(String nombre, String apellido, String localidad) {

        setNombre(nombre);
        setApellido(apellido);
        setLocalidad(localidad);
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

    public DatosRegistracion(String nombre, String apellido, String localidad, String correo, String clave) {

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
    
    public DatosRegistracion(String nombre, String apellido, String localidad, String correo, String clave, Boolean musical, Boolean deportivo, Boolean bailable,
    		Boolean teatral, Boolean recital, Boolean cine, Boolean cultural, Boolean gastronomico, Boolean feria, Boolean marcha, Boolean infantil, Boolean juvenil, Boolean adultos, Boolean jubilados,
    		Boolean todasLasEdades, Boolean aireLibre, Boolean teatro, Boolean estadio, Boolean centroCultural, Boolean matutino, Boolean vespertino, Boolean nocturno) {

    	setNombre(nombre);
        setApellido(apellido);
        setLocalidad(localidad);
        setCorreo(correo);
        setClave(clave);
        setMusical(musical);
        setDeportivo(deportivo);
        setBailable(bailable);
        setTeatral(teatral);
        setRecital(recital);
        setCine(cine);
        setCultural(cultural);
        setGastronomico(gastronomico);
        setFeria(feria);
        setMarcha(marcha);
        setInfantil(infantil);
        setJuvenil(juvenil);
        setAdultos(adultos);
        setJubilados(jubilados);
        setTodasLasEdades(todasLasEdades);
        setAireLibre(aireLibre);
        setTeatro(teatro);
        setEstadio(estadio);
        setCentroCultural(centroCultural);
        setMatutino(matutino);
        setVespertino(vespertino);
        setNocturno(nocturno);
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
}