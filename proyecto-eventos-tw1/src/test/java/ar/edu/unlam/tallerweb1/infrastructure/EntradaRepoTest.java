package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Entrada;
import ar.edu.unlam.tallerweb1.domain.Evento;
import ar.edu.unlam.tallerweb1.domain.Usuario;


public class EntradaRepoTest extends SpringTest{

	@Autowired
	private RepositorioEntrada repositorioEntrada;
	
	public static final int CANTIDAD_ENTRADAS = 3;
	private Long usuarioId = 1L;
	LocalDate fechaEvento = LocalDate.of(2023, 5, 7);
	
	@Before
    public void init() {
        this.repositorioEntrada = mock(RepositorioEntrada.class);
    }

	@Test
	@Transactional
	@Rollback
	public void siTengoEntradasYPidoTodasLasEntradasDevuelveUnaListaDeEntradas() {
		
		dadoQueExistenEntradas(CANTIDAD_ENTRADAS);
	
		List<Entrada> listaEntradas = cuandoBuscoMisEntradas(usuarioId);
		
		entoncesObtengoElListadoDeEntradas(listaEntradas, CANTIDAD_ENTRADAS);
	}

	private void entoncesObtengoElListadoDeEntradas(List<Entrada> listaEntradas,
			int cantidadEntradas) {
		assertThat(listaEntradas).isNotNull();
		assertThat(listaEntradas).hasSize(cantidadEntradas);
	}

	private List<Entrada> cuandoBuscoMisEntradas(Long usuarioId) {
		return repositorioEntrada.buscarMisEntradas(usuarioId);
	}

	private void dadoQueExistenEntradas(int cantidadEntradas) {
		Entrada entrada = new Entrada();
		Double precio = 550.5;
		List<Entrada> entradas = new ArrayList<>();
		Integer j = 0;
		for(int i = 1; i <= cantidadEntradas; i++) {
			j = i;
			entrada.setEvento(new Evento(j.toString(), fechaEvento, "CABA", j.toString()));
			entrada.setUsuario(new Usuario());
			entradas.add(entrada);
			repositorioEntrada.save(entrada);
		}
		when(this.repositorioEntrada.buscarMisEntradas(usuarioId)).thenReturn(entradas);
	}

}
