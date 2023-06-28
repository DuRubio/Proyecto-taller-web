package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.DatosEvento;
import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService  {

    
    private RepositorioEvento repoEvento;
    
    private RepositorioCategoria repoCategoria;
    
    @Autowired
    public EventoServiceImpl(RepositorioEvento repositorioEvento, RepositorioCategoria repositorioCategoria) {
		this.repoEvento = repositorioEvento;
		this.repoCategoria = repositorioCategoria;
	}

	@Override
    public boolean validarNombre(String nombre) {
       return !nombre.isEmpty();
    }

    @Override
    public boolean validarLocalidad(String localidad) {
        return !localidad.isEmpty();
    }

    @Override
    public void save(DatosEvento datosEvento) {
    	Categoria categoria = repoCategoria.buscarPorNombre(datosEvento.getCategoria());
    	Evento evento = new Evento(datosEvento,categoria);
    	repoEvento.save(evento);
    }

    @Override
    public Evento buscarPorId(Long id) {
        return repoEvento.buscarPorId(id);
    }

    @Override
    public Evento buscarPorNombre(String nombre) {
        return repoEvento.buscarPorNombre(nombre);
    }

    @Override
    public List<Evento> buscarPorTipoDeEvento(Integer categoria) {
    	Long idCategoria = new Long(categoria);
        return repoEvento.buscarPorTipoDeEvento(idCategoria);
    }

    @Override
    public List<Evento> buscarPorFecha(LocalDate fechaEvento) {
        return repoEvento.buscarPorFechaDeEvento(fechaEvento);
    }

    @Override
    public List<Evento> buscarPorCiudad(String ciudad) {
       return repoEvento.buscarPorLocalidadDeEvento(ciudad);
    }

    @Override
    public List<Evento> getEventos() {
        return repoEvento.findAll();
    }

    public List<Evento> getEventosConFiltros(LocalDate fecha, String ciudad, TipoDeEvento tipo){
        List<Evento> eventos = repoEvento.buscarEventosConFiltros(fecha, ciudad, tipo);
        return eventos;
    }

	@Override
	public List<Evento> getPrimeros4Eventos() {
		return repoEvento.findFirst4Events();
	}

}
