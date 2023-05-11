package ar.edu.unlam.tallerweb1.domain;

import org.springframework.stereotype.Service;

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
}
