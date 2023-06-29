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
	public List<Entrada> getEntradasByIdUsuario(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
