package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;
import ar.edu.unlam.tallerweb1.domain.Evento;

import java.time.LocalDate;
import java.util.List;


public interface RepositorioEvento {

    public void save(Evento evento);

    Evento buscarPorId(Long id);

    Evento buscarPorNombre(String nombre);

    List<Evento> buscarPorTipoDeEvento(Long categoria);

    List<Evento> buscarPorFechaDeEvento(LocalDate fecha);

    List<Evento> buscarPorLocalidadDeEvento(String localidad);

    public List<Evento> findAll() ;

    List<Evento> buscarEventosConFiltros(LocalDate fecha, String ciudad, TipoDeEvento tipo);

	public List<Evento> findFirst4Events();

	public List<Evento> buscarEventosPorPreferencias(Long id);


    void setInactivo(Evento evento);
}

