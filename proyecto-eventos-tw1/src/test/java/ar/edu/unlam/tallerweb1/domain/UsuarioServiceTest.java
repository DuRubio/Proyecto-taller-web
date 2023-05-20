package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.DatosLogin;
import ar.edu.unlam.tallerweb1.delivery.DatosRegistracion;
import ar.edu.unlam.tallerweb1.delivery.UsuarioController;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    public static final String CORREO_VALIDO="example@example.com";
    public static final String CORREO_INVALIDO="example.example.com";
    public static final String CLAVE_VALIDO="Dada123";
    public static final String CLAVE_INVALIDO="dadada";
    private RepositorioUsuario repositorioUsuario;
    private DatosRegistracion datosRegistracion;
    private DatosRegistracion datosRegistracion2;
    private DatosRegistracion datosRegistracion3;
    private UsuarioService servicioRegistracion ;
    private Usuario usuarioValido;


    @Before
    public void inicializacion(){
        this.datosRegistracion = new DatosRegistracion(CORREO_VALIDO, CLAVE_VALIDO);
        this.datosRegistracion2 = new DatosRegistracion(CORREO_INVALIDO, CLAVE_VALIDO);
        this.datosRegistracion3 = new DatosRegistracion(CORREO_VALIDO, CLAVE_INVALIDO);
        this.usuarioValido = new Usuario(CORREO_VALIDO, CLAVE_VALIDO);
        this.repositorioUsuario = mock(RepositorioUsuario.class);
        this.servicioRegistracion = new UsuarioServiceImpl(repositorioUsuario);
    }
    @Test
    public void queGuardeUsuarioEnRepo(){
        dadoQueNoExisteUsuario(datosRegistracion , usuarioValido);
        cuandoGuardoUsuario(datosRegistracion);
        entoncesSeGuardaCorrectamente(datosRegistracion, usuarioValido);

    }
    private void entoncesSeGuardaCorrectamente(DatosRegistracion datosRegistracion, Usuario usuarioValido) {
        Usuario vo = servicioRegistracion.obtenerUsuarioPorCorreo(datosRegistracion.getCorreo());
        assertThat(vo.getCorreo()).isEqualTo(usuarioValido.getCorreo());
    }
    private void cuandoGuardoUsuario(DatosRegistracion datosRegistracion) {
        servicioRegistracion.guardarUsuario(datosRegistracion);
    }
    private void dadoQueNoExisteUsuario(DatosRegistracion datosRegistracion , Usuario usuarioValido) {
        doNothing().when(repositorioUsuario).save(any());
        when(repositorioUsuario.buscarPorCorreo(datosRegistracion.getCorreo())).thenReturn(usuarioValido);

    }
}
