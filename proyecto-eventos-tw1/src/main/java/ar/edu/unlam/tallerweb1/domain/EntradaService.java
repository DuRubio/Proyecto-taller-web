package ar.edu.unlam.tallerweb1.domain;



public interface EntradaService {

    void save(Entrada entrada);

    Entrada buscarPorId(Long id);
}
