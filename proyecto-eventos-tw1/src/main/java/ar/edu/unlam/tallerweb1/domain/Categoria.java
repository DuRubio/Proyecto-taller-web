package ar.edu.unlam.tallerweb1.domain;

import java.util.ArrayList;
import java.util.List;

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

}
