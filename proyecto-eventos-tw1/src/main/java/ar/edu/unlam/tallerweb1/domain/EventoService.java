package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;

import java.util.Date;
import java.util.List;

public interface EventoService {
    boolean validarNombre(String nombre);

    boolean validarLocalidad(String localidad);
    void save(Evento evento);

    Evento buscarPorId(Long id);

    Evento buscarPorNombre(String nombre);

    List<Evento> buscarPorTipoDeEvento(TipoDeEvento tipoDeEvento);

    List<Evento> buscarPorFecha(Date fechaEvento);

    List<Evento> buscarPorCiudad(String ciudad);
}
