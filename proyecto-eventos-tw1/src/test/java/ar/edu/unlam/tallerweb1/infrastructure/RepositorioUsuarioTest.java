package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.delivery.DatosRegistracion;
import ar.edu.unlam.tallerweb1.domain.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.*;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;

public class RepositorioUsuarioTest extends SpringTest {

    DatosRegistracion datosRegistracion = new DatosRegistracion("pepe@gmail.com", "Pepe123");

    @Autowired
    private RepositorioUsuario repoUsuario; //error de InteliJ, lo toma y funciona igual

    @Test
    @Transactional @Rollback
    public void guardarUsuarioYPersistirlo(){
        Usuario user = DadoQueExisteUnUsuario(datosRegistracion);
        Long id = cuandoGuardoUsuario(user);
        entoncesLoPuedoBuscarPorId(id);

    }
    @Test
    @Transactional @Rollback
    public void buscarUsuarioPorCorreo(){
        Usuario user = DadoQueExisteUnUsuario(datosRegistracion);
        Long id = cuandoGuardoUsuario(user);
        entoncesLoPuedoBuscarPorCorreo(datosRegistracion.getCorreo(), id);

    }

    private void entoncesLoPuedoBuscarPorCorreo(String correo, Long id) {
        Usuario usr = repoUsuario.buscarPorId(id);
        assertThat(usr.getCorreo()).isEqualTo(correo);
    }


    private void entoncesLoPuedoBuscarPorId(Long id) {
        assertThat(repoUsuario.buscarPorId(id)).isNotNull();
    }

    private Long cuandoGuardoUsuario(Usuario user) {
        repoUsuario.save(user);
        return user.getId();
    }

    private Usuario DadoQueExisteUnUsuario(DatosRegistracion datosRegistracion) {
        return new Usuario(datosRegistracion.getCorreo(), datosRegistracion.getClave());
    }


}