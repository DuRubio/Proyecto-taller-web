package ar.edu.unlam.tallerweb1.delivery;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.Usuario;
import ar.edu.unlam.tallerweb1.domain.UsuarioService;
import ar.edu.unlam.tallerweb1.domain.UsuarioServiceImpl;

public class UsuarioCompletarMisPreferenciasControllerTest {

	private UsuarioController controladorUsuario;
	private DatosRegistracion datosRegistro;
	private UsuarioService servicioUsuario;
	private Usuario usuario;
	
	
	@Before
	public void init() {
		this.datosRegistro = new DatosRegistracion("correo1@correo.com", "Correo1234");
		this.usuario = new Usuario(datosRegistro);
		this.servicioUsuario = mock(UsuarioServiceImpl.class);
		this.controladorUsuario = new UsuarioController(servicioUsuario);
	}
	
	@Test
	public void queRegistroUnUsuarioYVoyAEditarMisPreferencias() {
		dadoQueNoExisteUnUsuario(datosRegistro, true);
        ModelAndView mav = cuandoSeRegistra(datosRegistro);
        entoncesElRegistroEsExitoso(mav);
        ModelAndView mav2 = cuandoVoyAEditarMisPreferencias();
        entoncesMeLlevaAEditarMisPreferencias(mav2);
	}
	
	private void entoncesMeLlevaAEditarMisPreferencias(ModelAndView mav2) {
		assertThat(mav2.getViewName()).isEqualTo("editar-mis-preferencias");
		
	}

	private ModelAndView cuandoVoyAEditarMisPreferencias() {
		return controladorUsuario.editarMisPreferencias();
	}

	private void entoncesElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("login");

    }
	
	private ModelAndView cuandoSeRegistra(DatosRegistracion datosRegistro) {
        return controladorUsuario.registrarUsuario(datosRegistro);
    }
	
	private void dadoQueNoExisteUnUsuario(DatosRegistracion datosRegistro, boolean retorno) {
        when(servicioUsuario.validarMail(datosRegistro.getCorreo())).thenReturn(retorno);
        when(servicioUsuario.validarClave(datosRegistro.getClave())).thenReturn(retorno);
        doNothing().when(servicioUsuario).guardarUsuario(any());
    }
	
	

}
