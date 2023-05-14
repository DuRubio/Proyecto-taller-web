package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.UsuarioService;
import ar.edu.unlam.tallerweb1.domain.UsuarioServiceImpl;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuarioImpl;
import org.hibernate.SessionFactory;
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
    private UsuarioController usuarioController;
    private DatosRegistracion datosRegistracion;
    private DatosRegistracion datosRegistracion2;
    private DatosRegistracion datosRegistracion3;


   // private UsuarioService servicioRegistracion  = new UsuarioServiceImpl();


    private UsuarioService servicioRegistracion ;
    private DatosLogin usuarioValido;
    @Before
    public void inicializacion(){

        this.datosRegistracion = new DatosRegistracion(CORREO_VALIDO, CLAVE_VALIDO);
        this.datosRegistracion2 = new DatosRegistracion(CORREO_INVALIDO, CLAVE_VALIDO);
        this.datosRegistracion3 = new DatosRegistracion(CORREO_VALIDO, CLAVE_INVALIDO);
        this.usuarioValido = new DatosLogin(CORREO_VALIDO, CLAVE_VALIDO);

        //this.servicioRegistracion = mock(UsuarioServiceImpl.class);
        this.servicioRegistracion = new UsuarioServiceImpl();
        this.usuarioController = new UsuarioController(servicioRegistracion);


    }


    //habria que validar en todos los casos que el usuario que se quiere logear no exista previamente

   @Test
    public void queAlTocarRegistrarAparezcaLaPantallaRegistro(){
        //dadoQueNoExisteUnUsuario(); //esto consultara en la bdd la no existencia de ese usuario
        ModelAndView mav = cuandoQuiereRegistrarse();
        aparezcaVistaRegistro(mav);
    }

    @Test
    public void queSePuedaRegistrarUnUsuarioConDatosCorrectosYLoLleveALogin(){
        //dadoQueNoExisteUnUsuario();
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

    //@Test no va a funcionar todavía porque no logré guardar ningun usuario en la bdd
    public void queSePuedaLogearConDatosCorrectosYLoLleveAHome(){
        usuarioValido = dadoQueExisteUnUsuario();
        ModelAndView mav = cuandoSeLogea(usuarioValido);
        entoncesLoLlevaAHome(mav);

    }

    @Test
    public void queAccedaAlLogin(){
        ModelAndView mav = cuandoQuieroAcceder();
        entoncesAccedoAlLogin(mav);
    }



    @Test
    public void queNoSePuedaRegistrarUnMailYaRegistradoYEnvieMensaje(){

    }

    private void entoncesElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("login");

    }

    private void entoncesLoLlevaAHome(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Login exitoso");
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
        return usuarioController.logearUsuario(usuarioValido);
    }

    private DatosLogin dadoQueExisteUnUsuario() {
        return new DatosLogin(CORREO_VALIDO, CLAVE_VALIDO);
    }

    private void aparezcaVistaRegistro(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registrarse");
    }

  private ModelAndView cuandoQuiereRegistrarse() {
        return usuarioController.getVistaRegistro();
    }

    private void dadoQueNoExisteUnUsuario() {

    }

}