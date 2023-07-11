package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.DatosEvento;
import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class EventoServiceImpl implements EventoService  {

    private static final String CARPETA_IMAGENES = "src/main/webapp/img/";
    private RepositorioEvento repoEvento;
    
    private RepositorioCategoria repoCategoria;
    private Evento evento;

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
    	//Evento evento = new Evento(datosEvento,categoria);
        evento = new Evento(datosEvento,categoria);
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

	@Override
	public List<Evento> buscarEventosPorPreferencias(Usuario usuario) {
		Long id = usuario.getId();
		List<Categoria> categorias = repoCategoria.findAll();
		List<Long> idCategoriasPreferencias = repoCategoria.findPreferenciasById(id);
		return repoEvento.buscarEventosPorPreferencias(id);
	}

    @Override
    public List<Evento> buscarEventosPorPreferenciasHome(Usuario usuario) {
        Long id = usuario.getId();
        List<Categoria> categorias = repoCategoria.findAll();
        List<Long> idCategoriasPreferencias = repoCategoria.findPreferenciasById(id);
        return repoEvento.buscarEventosPorPreferenciasHome(id);
    }

    @Override
    public void setInactivo(Long eventoId) {
        Evento evento = this.buscarPorId(eventoId);
        repoEvento.setInactivo(evento);
    }

    @Override
    public void asociarImagenConEvento(Evento evento, MultipartFile imagen) {
        String nombreImagen = UUID.randomUUID().toString() + "-" + imagen.getOriginalFilename();
        try {
            Path rutaImagen = Path.of(CARPETA_IMAGENES + nombreImagen);
            Files.copy(imagen.getInputStream(), rutaImagen, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        repoEvento.guardarImagen(evento, nombreImagen);
    }

    @Override
    public Evento getUltimoGuardado() {
        return repoEvento.getUltimoGuardado();
    }

    @Override
    public List<Evento> getEventosPorFecha() {
        return repoEvento.getEventosPorFecha();
    }

    @Override
    public List<Evento> getEventosOrdenadosPorDisponibilidad() {
        return repoEvento.getEventosOrdenadosPorDisponibilidad();
    }


}
