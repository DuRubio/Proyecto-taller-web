package ar.edu.unlam.tallerweb1.domain;

import java.util.List;

public interface EntradaService {

    void save(Entrada entrada);

    Entrada buscarPorId(Long id);

    boolean asignarEntrada(Usuario usuario, Evento evento);

	List<Entrada> listarMisEntradas(Long usuarioId);
}
