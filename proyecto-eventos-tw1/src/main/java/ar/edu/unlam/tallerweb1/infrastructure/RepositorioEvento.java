package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;
import ar.edu.unlam.tallerweb1.domain.Evento;
//import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RepositorioEvento /*extends JpaRepository<Evento, Long> */{

    public void save(Evento evento);

    Evento buscarPorId(Long id);

    Evento buscarPorNombre(String nombre);

    List<Evento> buscarPorTipoDeEvento(TipoDeEvento tipoDeEvento);

    List<Evento> buscarPorFechaDeEvento(Date fecha);

    List<Evento> buscarPorLocalidadDeEvento(String localidad);

    List<Evento> listarEventos();
}
