package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Entrada;

public interface RepositorioEntrada {

    void save(Entrada entrada);

    Entrada buscarPorId(Long id);
}
