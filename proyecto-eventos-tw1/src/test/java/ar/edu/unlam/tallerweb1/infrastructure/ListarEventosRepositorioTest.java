package ar.edu.unlam.tallerweb1.infrastructure;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Evento;

public class ListarEventosRepositorioTest extends SpringTest{

	@Autowired
	private RepositorioEvento repositorioEvento;
	
	public static final int CANTIDAD_EVENTOS = 3;
	
	@Before
	public void init() {
		this.repositorioEvento = mock(RepositorioEvento.class);
	}
	
	@Test
	@Transactional
	@Rollback
	public void existenEventosYListoTodosLosEventos() {
		dadoQueExistenEventos(CANTIDAD_EVENTOS);
		List<Evento> listaEventos = cuandoListoTodosLosEventos();
		entoncesObtengoElListadoDeEventos(listaEventos, CANTIDAD_EVENTOS);
	}

	private void entoncesObtengoElListadoDeEventos(List<Evento> listaEventos, int cantidadEventos) {
		// TODO Auto-generated method stub
		
	}

	private List<Evento> cuandoListoTodosLosEventos() {
		// TODO Auto-generated method stub
		return null;
	}

	private void dadoQueExistenEventos(int cantidadEventos) {
		Evento evento = new Evento();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
