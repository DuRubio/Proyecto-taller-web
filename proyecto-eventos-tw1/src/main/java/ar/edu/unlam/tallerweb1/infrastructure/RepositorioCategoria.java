package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Categoria;

public interface RepositorioCategoria {
	
	Categoria buscarPorId(Long id);
	
	Categoria buscarPorNombre(String nombre);

}
