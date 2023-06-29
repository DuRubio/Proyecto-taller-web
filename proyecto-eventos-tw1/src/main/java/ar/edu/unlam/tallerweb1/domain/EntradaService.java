package ar.edu.unlam.tallerweb1.domain;

import java.util.List;

public interface EntradaService {

    void save(Entrada entrada);

    Entrada buscarPorId(Long id);

	List<Entrada> getEntradasByIdUsuario(Long id);
}
