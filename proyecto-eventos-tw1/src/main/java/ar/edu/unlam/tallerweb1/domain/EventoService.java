package ar.edu.unlam.tallerweb1.domain;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unlam.tallerweb1.delivery.DatosEvento;

public interface EventoService {
    boolean validarNombre(String nombre);

    boolean validarLocalidad(String localidad);
    void save(Evento evento);

    Evento buscarPorId(Long id);

    Evento buscarPorNombre(String nombre);

    List<Evento> buscarPorTipoDeEvento(String categoria);

    List<Evento> buscarPorFecha(LocalDate fechaEvento);

    List<Evento> buscarPorCiudad(String ciudad);

    List<Evento> getEventos();

	List<Evento> getPrimeros4Eventos();

	List<Evento> listarEventosPorMisPreferencias();

	void save(DatosEvento evento);
}
