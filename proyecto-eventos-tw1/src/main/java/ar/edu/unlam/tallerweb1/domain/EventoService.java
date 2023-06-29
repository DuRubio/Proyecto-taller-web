package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.DatosEvento;
import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface EventoService {
    boolean validarNombre(String nombre);

    boolean validarLocalidad(String localidad);
    
    void save(DatosEvento datosEvento);

    Evento buscarPorId(Long id);

    Evento buscarPorNombre(String nombre);

    List<Evento> buscarPorTipoDeEvento(Integer categoria);

    List<Evento> buscarPorFecha(LocalDate fechaEvento);

    List<Evento> buscarPorCiudad(String ciudad);

    List<Evento> getEventos();

	List<Evento> getPrimeros4Eventos();

	List<Evento> buscarEventosPorPreferencias(Usuario usuario);
}
