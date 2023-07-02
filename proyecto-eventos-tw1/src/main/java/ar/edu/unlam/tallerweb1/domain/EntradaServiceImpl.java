package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.infrastructure.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioEntrada;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioEntradaImpl;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaServiceImpl implements  EntradaService{

    private RepositorioEntrada repoEntrada;

    @Autowired
    public EntradaServiceImpl(RepositorioEntrada repoEntrada){
        this.repoEntrada=repoEntrada;

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
            return true;
        }
        return false;
    }
	@Override
	public List<Entrada> listarMisEntradas(Long usuarioId) {
		return repoEntrada.buscarMisEntradas(usuarioId);
	}

}
