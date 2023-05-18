package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.delivery.DatosRegistracion;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuarioImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

    @Autowired
    RepositorioUsuario repoUsuario;

    public UsuarioServiceImpl(RepositorioUsuario repoUsuario){
        this.repoUsuario=repoUsuario;
    }

    @Override
    public Boolean guardarUsuario(DatosRegistracion datosRegistracion) {
        Boolean pudoGuardar=false;
        Usuario usuario = new Usuario(datosRegistracion.getNombre(), datosRegistracion.getApellido(), datosRegistracion.getLocalidad(), datosRegistracion.getCorreo(), datosRegistracion.getClave());
        if(repoUsuario.save(usuario)){
            pudoGuardar=true;
        }
        return pudoGuardar;
        }



    @Override
    public Boolean validarMail(String correo) {
        return correo.contains("@") && correo.endsWith(".com");
    }
    @Override
    public Boolean validarClave(String clave) {
        return clave.length() >= 6 && clave.matches(".*[A-Z].*") && clave.matches(".*\\d.*");
    }

    /*@Override
    public boolean buscarUsuarioPorCorreo(String correo) {
        return repoUsuario.buscarPorCorreo(correo);

    }*/

    @Override
    public Usuario obtenerUsuarioPorCorreo(String correo) {

        return repoUsuario.buscarPorCorreo(correo);
    }

    @Override
    public void registrarUsuario(String correo, String clave) {
        //este cargara los datos del usuario en una BDD
    }


    @Override
    public Boolean compararMail(String correo) {
        Usuario usuario;
        usuario = obtenerUsuarioPorCorreo(correo);
        Boolean esValido=false;
        if(usuario.getCorreo().equals(correo)){
            esValido=true;
        }
        return esValido;

    }

    @Override
    public Boolean compararClave(String correo, String clave) {
        Usuario usuario;
        usuario = obtenerUsuarioPorCorreo(correo);
        Boolean esValido=false;
        if(usuario.getClave().equals(clave)){
            esValido=true;
        }
        return esValido;

    }


}
