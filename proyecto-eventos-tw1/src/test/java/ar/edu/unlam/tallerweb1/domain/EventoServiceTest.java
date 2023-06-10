package ar.edu.unlam.tallerweb1.domain;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.infrastructure.RepositorioEvento;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.ArrayList;



public class EventoServiceTest {
	
	private EventoService servicioEvento;
	private RepositorioEvento repositorioEvento = mock(RepositorioEvento.class);
	public static final int CANTIDAD_EVENTOS = 4;
	
	
	@Before
	public void init() {
		this.servicioEvento = new EventoServiceImpl(this.repositorioEvento);
	}
	
	@Test
	public void alListarTodosLosEventosDevuelveLaListaCompleta() {
		dadoQueExistenEventos(CANTIDAD_EVENTOS);
		List<Evento> listadoDeEventos = cuandoListoEventos();
		entoncesTraeListadoEventos(listadoDeEventos, CANTIDAD_EVENTOS);
	}

	private void entoncesTraeListadoEventos(List<Evento> listadoDeEventos, int cantidadEventos) {
		assertThat(listadoDeEventos).isNotNull();
		assertThat(listadoDeEventos.size()).isEqualTo(CANTIDAD_EVENTOS);
	}

	private List<Evento> cuandoListoEventos() {
		return servicioEvento.getEventos();
	}

	private void dadoQueExistenEventos(int cantidadEventos) {
		List<Evento> eventos = new ArrayList<>();
		
		for(int i=0; i<cantidadEventos; i++) {
			eventos.add(new Evento());
		}
		
		when(this.servicioEvento.getEventos()).thenReturn(eventos);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
