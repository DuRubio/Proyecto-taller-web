package ar.edu.unlam.tallerweb1.delivery;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.domain.Categoria;

public class DatosPreferencias {
	
	private Long idUsuario;
    
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
    
    public DatosPreferencias() {}
    
    public DatosPreferencias(Long id) {
    	setIdUsuario(id);
    }
    
    public DatosPreferencias(Long id, Boolean musical, Boolean deportivo, Boolean bailable, Boolean teatral, Boolean recital, Boolean cine, Boolean cultural, Boolean gastronomico, Boolean feria, Boolean marcha){
    	setIdUsuario(id);
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
    	
    }
    
    public DatosPreferencias(Boolean musical, Boolean deportivo, Boolean bailable, Boolean teatral, Boolean recital, Boolean cine, Boolean cultural, Boolean gastronomico, Boolean feria, Boolean marcha){
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
    }
    
    
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public Boolean getMarcha() {
		return marcha;
	}

	public void setMarcha(Boolean marcha) {
		this.marcha = marcha;
	}
 
}
