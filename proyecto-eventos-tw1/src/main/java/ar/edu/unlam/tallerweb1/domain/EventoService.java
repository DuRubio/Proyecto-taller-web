package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.DatosEvento;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
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
    List<Evento> buscarEventosPorPreferenciasHome(Usuario usuario);

    void setInactivo(Long eventoId);

    void asociarImagenConEvento(Evento evento, MultipartFile imagen);

    Evento getUltimoGuardado();

    List<Evento> getEventosPorFecha();

    List<Evento> getEventosOrdenadosPorDisponibilidad();

    void inactivarLosPasados();
}
