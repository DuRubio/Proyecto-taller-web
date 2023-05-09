package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.DatosLogin;
import ar.edu.unlam.tallerweb1.delivery.DatosRegistracion;
import ar.edu.unlam.tallerweb1.delivery.UsuarioController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioControllerTest {


    public static final String CORREO_VALIDO="example@example.com";
    public static final String CORREO_INVALIDO="example.example.com";
    public static final String CLAVE_VALIDO="Dada123";
    public static final String CLAVE_INVALIDO="dadada";
    private UsuarioController registroUsuario;
    private DatosRegistracion datosRegistracion;
    private DatosRegistracion datosRegistracion2;
    private DatosRegistracion datosRegistracion3;
    private UsuarioService servicioRegistracion;

    private DatosLogin usuarioValido;
    @Before
    public void inicializacion(){
        this.datosRegistracion = new DatosRegistracion(CORREO_VALIDO, CLAVE_VALIDO);
        this.datosRegistracion2 = new DatosRegistracion(CORREO_INVALIDO, CLAVE_VALIDO);
        this.datosRegistracion3 = new DatosRegistracion(CORREO_VALIDO, CLAVE_INVALIDO);
        //this.servicioRegistracion = mock(UsuarioServiceImpl.class);
       // this.registroUsuario = new UsuarioController(servicioRegistracion);
        this.registroUsuario = new UsuarioController();
        this.servicioRegistracion = new UsuarioServiceImpl();
        //this.usuarioValido = new DatosLogin(CORREO_VALIDO, CLAVE_VALIDO);
    }


    //habria que validar en todos los casos que el usuario que se quiere logear no exista previamente

    @Test
    public void queAlTocarRegistrarAparezcaLaPantallaRegistro(){
        dadoQueNoExisteUnUsuario(); //esto consultara en la bdd la no existencia de ese usuario
        ModelAndView mav = cuandoQuiereRegistrarse();
        aparezcaVistaRegistro(mav);
    }

    @Test
    public void queSePuedaRegistrarUnUsuarioConDatosCorrectosYLoLleveALogin(){
        dadoQueNoExisteUnUsuario();
        ModelAndView mav = cuandoSeRegistra(datosRegistracion);
        entoncesElRegistroEsExitoso(mav);
    }

    @Test
    public void queNoSePuedaRegistrarUnUsuarioConMailIncorrectoYEnvieMensaje(){
        dadoQueNoExisteUnUsuario();
        ModelAndView mav = cuandoSeRegistra(datosRegistracion2);
        entoncesElRegistroNoEsExitoso(mav);

    }

    @Test
    public void queNoSePuedaRegistrarUnUsuarioConClaveIncorrectoYEnvieMensaje(){
        dadoQueNoExisteUnUsuario();
        ModelAndView mav = cuandoSeRegistra(datosRegistracion2);
        entoncesElRegistroNoEsExitoso(mav);

    }

    @Test
    public void queSePuedaLogearConDatosCorrectosYLoLleveAHome(){
        usuarioValido = dadoQueExisteUnUsuario();
        ModelAndView mav = cuandoSeLogea(usuarioValido);
        entoncesLoLlevaAHome(mav);

    }


    @Test
    public void queNoSePuedaLogearConDatosIncorrectosYLoLleveARegistrarse(){

    }

    @Test
    public void queNoPuedaLogearseSiIntroduceMalLaContrasenia(){

    }

    @Test
    public void queNoSePuedaRegistrarUnMailYaRegistradoYEnvieMensaje(){

    }

    private void entoncesElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("login");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Registro exitoso");
    }

    private void entoncesLoLlevaAHome(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("index");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Login exitoso");
    }

    private void entoncesElRegistroNoEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registro-usuario");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Registro fallido");

    }

    private ModelAndView cuandoSeRegistra(DatosRegistracion datosRegistracion) {
        return registroUsuario.registrarUsuario(datosRegistracion);
    }

    private ModelAndView cuandoSeLogea(DatosLogin usuarioValido) {
        return registroUsuario.logearUsuario(usuarioValido);
    }

    private DatosLogin dadoQueExisteUnUsuario() {
        return new DatosLogin(CORREO_VALIDO, CLAVE_VALIDO);
    }

    private void aparezcaVistaRegistro(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registro-usuario");
    }

    private ModelAndView cuandoQuiereRegistrarse() {
        return registroUsuario.getVistaRegistro();
    }

    private void dadoQueNoExisteUnUsuario() {

    }

}
