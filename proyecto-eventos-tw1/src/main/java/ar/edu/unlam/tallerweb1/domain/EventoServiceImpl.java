package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService{
    @Override
    public boolean validarNombre(String nombre) {
       return !nombre.isEmpty();
    }

    @Override
    public boolean validarLocalidad(String localidad) {
        return !localidad.isEmpty();
    }

    @Override
    public void save(Evento evento) {

    }

    @Override
    public Evento buscarPorId(Long id) {
        return null;
    }

    @Override
    public Evento buscarPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<Evento> buscarPorTipoDeEvento(TipoDeEvento tipoDeEvento) {
        return null;
    }

    @Override
    public List<Evento> buscarPorFecha(Date fechaEvento) {
        return null;
    }

    @Override
    public List<Evento> buscarPorCiudad(String ciudad) {
        return null;
    }
}
