package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.Categoria;

public interface RepositorioCategoria {
	
	Categoria buscarPorId(Long id);
	
	Categoria buscarPorNombre(String nombre);

	List<Categoria> findAll();

	List<Categoria> findById(List<Long> categoriasSeleccionadas);

}
