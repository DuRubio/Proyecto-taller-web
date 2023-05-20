package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;

import java.util.Date;
import java.util.List;

public interface HomeService { //NO USAR ESTA CLASE POR AHORA

    void save(Evento evento);

    Evento buscarPorId(Long id);

    Evento buscarPorNombre(String nombre);

    List<Evento> buscarPorTipoDeEvento(TipoDeEvento tipoDeEvento);

    List<Evento> buscarPorFecha(Date fechaEvento);

    List<Evento> buscarPorCiudad(String ciudad);
}
