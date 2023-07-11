package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.infrastructure.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaServiceImpl implements  EntradaService{

    private RepositorioEntrada repoEntrada;
    private RepositorioEvento repoEvento;

    @Autowired
    public EntradaServiceImpl(RepositorioEntrada repoEntrada, RepositorioEvento repoEvento){
        this.repoEntrada=repoEntrada;
        this.repoEvento = repoEvento;

    }
    @Override
    public void save(Entrada entrada) {
        repoEntrada.save(entrada);
    }

    @Override
    public Entrada buscarPorId(Long id) {
       return repoEntrada.buscarPorId(id);
    }

    @Override
    public boolean asignarEntrada(Usuario usuario, Evento evento) {
        if(evento.getDisponibilidad()>0){
            Entrada entrada = new Entrada(usuario, evento);
            evento.agregarEntrada(entrada);
            save(entrada);
            Integer nuevoCupo = evento.getDisponibilidad();
            evento.setDisponibilidad(--nuevoCupo);
            if(nuevoCupo==0){
                evento.setEventoActivo(false);
            }
            repoEvento.updateEvento(evento);
            return true;
        }
        return false;
    }

    @Override
    public List<Entrada> listarMisEntradas(Long usuarioId) {
        return repoEntrada.buscarMisEntradas(usuarioId);
    }

}
