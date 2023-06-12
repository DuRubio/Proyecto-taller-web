package ar.edu.unlam.tallerweb1.delivery;

import static org.junit.Assert.*;

import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.Evento;
import ar.edu.unlam.tallerweb1.domain.EventoService;
import ar.edu.unlam.tallerweb1.domain.EventoServiceImpl;
import ar.edu.unlam.tallerweb1.domain.enums.LugarEvento;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioEvento;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioEventoImpl;


public class EventoControllerListPreferenciasTest {

	private EventoService servicioEvento;
	private RepositorioEvento repositorioEvento;
	private EventoController controladorEvento;
	
	public static final int CANTIDAD_EVENTOS = 4;
	public static final int CANTIDAD_EVENTOS_ENCONTRADOS = 2;
	
	@Before
	public void init() {
		this.servicioEvento = mock(EventoServiceImpl.class);
		this.repositorioEvento = mock(RepositorioEventoImpl.class);
		this.controladorEvento = new EventoController(this.servicioEvento, this.repositorioEvento);
	}
	
	
	@Test
	public void alPedirEventosPorMisPreferenciasObtengoUnaListaDeEventos() {
		dadoQueExistenEventos(CANTIDAD_EVENTOS);
		ModelAndView mav = cuandoListoExcursiones();
		entoncesEncuentro(mav, CANTIDAD_EVENTOS_ENCONTRADOS);
		entoncesMeLlevaALaVista(mav, "listar-eventos-segun-mis-preferencias");
	}

	private void entoncesMeLlevaALaVista(ModelAndView mav, String vistaEsperada) {
		assertThat(mav.getViewName()).isEqualTo(vistaEsperada);
	}

	private void entoncesEncuentro(ModelAndView mav, int cantidadEventosEncontrados) {
		assertThat((ArrayList<Evento>)mav.getModel().get("eventos")).hasSize(cantidadEventosEncontrados);
	}

	private ModelAndView cuandoListoExcursiones() {
		return controladorEvento.listarEventosPorMisPreferencias();
	}

	private void dadoQueExistenEventos(int cantidadEventos) {
		List<Evento> eventos = new ArrayList<>();
		List<Evento> eventosSegunPreferencias = new ArrayList<>();
		Evento e = new Evento();
		Evento e1 = new Evento("Superclasico", new Date(2023, 5, 7), LugarEvento.Estadio, "Nuñez");
		Evento e2 = new Evento("Clasico Avellaneda", new Date(2023, 9, 8), LugarEvento.Estadio, "Avellaneda");
		Evento e3 = new Evento("Drácula", new Date(2023, 11, 22), LugarEvento.Teatro, "Recoleta");
		Evento e4 = new Evento("Drácula", new Date(2023, 10, 24), LugarEvento.Teatro, "Morón");
		
		for(int i=0; i<cantidadEventos; i++) {
			if(i==0) 
				eventos.add(e1);
			
			if(i==1)
				eventos.add(e2);
			
			if(i==2)
				eventos.add(e3);
			
			if(i==3)
				eventos.add(e4);
		
	}
		
		for(int j=0; j<cantidadEventos;j++) {
			e = eventos.get(j);
			
			
			if(e.getNombre() == "Drácula") {
				eventosSegunPreferencias.add(e);
			}
			
		}
		
		when(this.servicioEvento.listarEventosPorMisPreferencias()).thenReturn(eventosSegunPreferencias);
	
	}
	
	
	
	

}
