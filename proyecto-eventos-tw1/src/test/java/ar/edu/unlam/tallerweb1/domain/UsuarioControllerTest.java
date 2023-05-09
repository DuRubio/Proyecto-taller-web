package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.DatosRegistracion;
import ar.edu.unlam.tallerweb1.delivery.UsuarioController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;

public class UsuarioControladorTest {


    public static final String CORREO_VALIDO="example@example.com";
    public static final String CORREO_INVALIDO="example.example.com";
    public static final String CLAVE_VALIDO="dadada";
    public static final String CLAVE_INVALIDO="Dada123";
    private UsuarioController registroUsuario;
    private DatosRegistracion datosRegistracion;
    @Before
    public void inicializacion(){

        registroUsuario = new UsuarioController();
        datosRegistracion = new DatosRegistracion(CORREO_VALIDO, CLAVE_VALIDO);
    }

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

    private void entoncesElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("login");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Registro exitoso");
    }

    private ModelAndView cuandoSeRegistra(DatosRegistracion datosRegistracion) {
       return registroUsuario.registrarUsuario(datosRegistracion);
    }

    @Test
    public void queNoSePuedaRegistrarUnUsuarioConMailIncorrectoYEnvieMensaje(){

    }
    @Test
    public void queNoSePuedaRegistrarUnUsuarioConClaveIncorrectoYEnvieMensaje(){

    }

    @Test
    public void queSePuedaLogearConDatosCorrectosYLoLleveAHome(){

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

    private void aparezcaVistaRegistro(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registro-usuario");
    }

    private ModelAndView cuandoQuiereRegistrarse() {
        return registroUsuario.getVistaRegistro();
    }

    private void dadoQueNoExisteUnUsuario() {

    }

}
