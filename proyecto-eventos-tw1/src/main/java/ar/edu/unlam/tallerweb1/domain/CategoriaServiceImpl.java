package ar.edu.unlam.tallerweb1.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.infrastructure.RepositorioCategoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	private RepositorioCategoria repoCategoria;
	
	@Autowired
	public CategoriaServiceImpl(RepositorioCategoria repositorioCategoria) {
		this.repoCategoria = repositorioCategoria;
	}

	@Override
	public List<Categoria> obtenerTodasCategorias() {
		return repoCategoria.findAll();
	}

	@Override
	public List<Categoria> obtenerCategoriasPorIds(List<Long> categoriasSeleccionadas) {
		return repoCategoria.findById(categoriasSeleccionadas);
	}

}
