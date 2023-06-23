package ar.edu.unlam.tallerweb1.domain;

import java.util.List;

public interface CategoriaService {

	List<Categoria> obtenerTodasCategorias();

	List<Categoria> obtenerCategoriasPorIds(List<Long> categoriasSeleccionadas);
	
	

}
