package ar.edu.unlam.tallerweb1.delivery;


import ar.edu.unlam.tallerweb1.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class UsuarioControllerTest {


    public static final String CORREO_VALIDO="example@example.com";
    public static final String CORREO_INVALIDO="example.example.com";
    public static final String CLAVE_VALIDO="Dada123";
    public static final String CLAVE_INVALIDO="dadada";
    private UsuarioController usuarioController;
    private DatosRegistracion datosRegistracion;
    private DatosRegistracion datosRegistracion2;
    private DatosRegistracion datosRegistracion3;
    private UsuarioService servicioRegistracion ;
    private EventoService eventoService;
    private EntradaService servicioEntrada;
    private DatosLogin usuarioValido;
    private HttpServletRequest request;
    private Long usuarioId = 1L;
    public static final int CANTIDAD_ENTRADAS = 3;


    @Before
    public void inicializacion(){
        this.datosRegistracion = new DatosRegistracion(CORREO_VALIDO, CLAVE_VALIDO);
        this.datosRegistracion2 = new DatosRegistracion(CORREO_INVALIDO, CLAVE_VALIDO);
        this.datosRegistracion3 = new DatosRegistracion(CORREO_VALIDO, CLAVE_INVALIDO);
        this.usuarioValido = new DatosLogin(CORREO_VALIDO, CLAVE_VALIDO);
        this.servicioRegistracion = mock(UsuarioServiceImpl.class);
        this.eventoService=mock(EventoServiceImpl.class);
        this.servicioEntrada=mock(EntradaServiceImpl.class);
        //this.request=mock(HttpServletRequest.class);
        this.request = new MockHttpServletRequest();
        this.usuarioController = new UsuarioController(servicioRegistracion,eventoService,servicioEntrada);
    }

    @Test
    public void queAlTocarRegistrarAparezcaLaPantallaRegistro(){

        ModelAndView mav = cuandoQuiereRegistrarse();
        aparezcaVistaRegistro(mav);
    }

    @Test
    public void queSePuedaRegistrarUnUsuarioConDatosCorrectosYLoLleveALogin(){
        dadoQueNoExisteUnUsuario(datosRegistracion, true);
        ModelAndView mav = cuandoSeRegistra(datosRegistracion);
        entoncesElRegistroEsExitoso(mav);
    }

    @Test
    public void queNoSePuedaRegistrarUnUsuarioConMailIncorrectoYEnvieMensaje(){
        dadoQueNoExisteUnUsuario(datosRegistracion2, false);
        ModelAndView mav = cuandoSeRegistra(datosRegistracion2);
        entoncesElRegistroNoEsExitoso(mav);

    }

    @Test
    public void queNoSePuedaRegistrarUnUsuarioConClaveIncorrectoYEnvieMensaje(){
        dadoQueNoExisteUnUsuario(datosRegistracion2, false);
        ModelAndView mav = cuandoSeRegistra(datosRegistracion2);
        entoncesElRegistroNoEsExitoso(mav);

    }

    @Test
    public void queNoSePuedaRegistrarUnMailYaRegistradoYEnvieMensaje(){
        dadoQueExisteUnUsuarioRegistrado(usuarioValido);
        ModelAndView mav = cuandoSeRegistra(datosRegistracion);
        entoncesLoLlevaALoginyRecibeMensaje(mav);
    }

    @Test
    public void queAccedaAlLogin(){
        ModelAndView mav = cuandoQuieroAcceder();
        entoncesAccedoAlLogin(mav);
    }

   /* @Test
    public void queSePuedaLogearConDatosCorrectosYLoLleveAHome(){
        dadoQueExisteUnUsuario(request, usuarioValido, true);
        ModelAndView mav = cuandoSeLogea(usuarioValido);
        entoncesLoLlevaAHome(mav);

    }
*/




    private void entoncesLoLlevaALoginyRecibeMensaje(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("login");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Usuario existente");
    }

    private void dadoQueExisteUnUsuario(HttpServletRequest request, DatosLogin usuarioValido, boolean retornoDeseado) {
        when(servicioRegistracion.compararMail(usuarioValido.getCorreo())).thenReturn(retornoDeseado);
        when(servicioRegistracion.compararClave(usuarioValido.getCorreo(),usuarioValido.getClave())).thenReturn(retornoDeseado);
        when(request.getParameter("usuario")).thenReturn(usuarioValido.getCorreo());
        when(request.getParameter("clave")).thenReturn(usuarioValido.getClave());
    }

    private void dadoQueExisteUnUsuarioRegistrado(DatosLogin usuarioValido) {
        Usuario usuario = new Usuario();
        when(servicioRegistracion.obtenerUsuarioPorCorreo(usuarioValido.getCorreo())).thenReturn(usuario);

    }

    private void dadoQueNoExisteUnUsuario(DatosRegistracion datosRegistracion, boolean retorno) {
        when(servicioRegistracion.validarMail(datosRegistracion.getCorreo())).thenReturn(retorno);
        when(servicioRegistracion.validarClave(datosRegistracion.getClave())).thenReturn(retorno);
        doNothing().when(servicioRegistracion).guardarUsuario(any());
    }

    private void entoncesElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("login");

    }

    private void entoncesLoLlevaAHome(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");

    }

    private ModelAndView cuandoQuieroAcceder() {
        return usuarioController.getVistaLogin();
    }

    private void entoncesAccedoAlLogin(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("login");
        assertThat(mav.getModel().get("datosLogin")).isNotNull();
        DatosLogin dl = (DatosLogin) mav.getModel().get("datosLogin");
        assertThat(dl.getCorreo()).isNull();
        assertThat(dl.getClave()).isNull();
    }

    private void entoncesElRegistroNoEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registrarse");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Registro fallido, mail o clave inválido");

    }

    private ModelAndView cuandoSeRegistra(DatosRegistracion datosRegistracion) {
        return usuarioController.registrarUsuario(datosRegistracion);
    }

    private ModelAndView cuandoSeLogea(DatosLogin usuarioValido) {
        return usuarioController.logearUsuario(request, usuarioValido.getCorreo(), usuarioValido.getClave());
    }



    private void aparezcaVistaRegistro(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registrarse");
    }

    private ModelAndView cuandoQuiereRegistrarse() {
        return usuarioController.getVistaRegistro();
    }

    
    /*@Test
    public void queAlIngresarAMisEntradasMeLlevaALaVistaMisEntradas() {
    	dadoQueTengoEntradas(usuarioId, CANTIDAD_ENTRADAS);
    	
    	ModelAndView mav = cuandoListoEntradas();
    	
    	entoncesEncuentro(mav, CANTIDAD_ENTRADAS);
    	
    	entoncesMeLlevaALaVista(mav, "mis-entradas");
    }*/

	private void entoncesMeLlevaALaVista(ModelAndView mav, String vistaEsperada) {
		assertThat(mav.getViewName()).isEqualTo(vistaEsperada);
	}

	private void entoncesEncuentro(ModelAndView mav, int cantidadEntradas) {
		assertThat((ArrayList<Entrada>)mav.getModel().get("entradas")).hasSize(cantidadEntradas);
	}

	/*private ModelAndView cuandoListoEntradas() {
		return usuarioController.misEntradas(usuarioId);
	}*/

	private void dadoQueTengoEntradas(Long usuarioId, int cantidadEntradas) {
		List<Entrada> entradas = new ArrayList<>();
		for(int i=0; i<cantidadEntradas; i++) 
			entradas.add(new Entrada());
		when(this.servicioEntrada.listarMisEntradas(usuarioId)).thenReturn(entradas);
		
	}


}