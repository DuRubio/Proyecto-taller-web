package ar.edu.unlam.tallerweb1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.delivery.DatosRegistracion;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioEntrada;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;

public class EntradaServiceTest {
	
	private RepositorioEntrada repositorioEntrada;
	private EntradaService servicioEntrada;
	private Long usuarioId = 1L;
    public static final int CANTIDAD_ENTRADAS = 3;
    
    @Before
    public void inicializacion(){
        this.repositorioEntrada = mock(RepositorioEntrada.class);
        this.servicioEntrada = new EntradaServiceImpl(repositorioEntrada);
    }
	
	@Test
    public void alListarMisEntradasDevuelveLaListaDeEntradas() {
    	dadoQueExistenEntradas(CANTIDAD_ENTRADAS);
    	
    	List<Entrada> listaEntradas = cuandoListoMisEntradas(usuarioId);
    	
    	entoncesTraeListadoDeEntradas(listaEntradas, CANTIDAD_ENTRADAS);
    }
    
	private void entoncesTraeListadoDeEntradas(List<Entrada> listaEntradas, int cantidadEntradas) {
		assertThat(listaEntradas).isNotNull();
	}
	
	private List<Entrada> cuandoListoMisEntradas(Long usuarioId2) {
		return servicioEntrada.listarMisEntradas(usuarioId);
	}
	
	private void dadoQueExistenEntradas(int cantidadEntradas) {
		List<Entrada> entradas = new ArrayList<>();
		
		for(int i=0; i<cantidadEntradas; i++)
			entradas.add(new Entrada());
		
		when(this.servicioEntrada.listarMisEntradas(usuarioId)).thenReturn(entradas);
	}

}
