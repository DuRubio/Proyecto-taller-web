package ar.edu.unlam.tallerweb1.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "categoria")
    private List<Evento> eventos = new ArrayList<>();
    
    @ManyToMany(mappedBy = "categoriasPreferidas")
    private List<Usuario> usuariosPreferencia = new ArrayList<>();

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

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Usuario> getUsuariosPreferencia() {
		return usuariosPreferencia;
	}

	public void setUsuariosPreferencia(List<Usuario> usuariosPreferencia) {
		this.usuariosPreferencia = usuariosPreferencia;
	}

	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}
    
    

}
