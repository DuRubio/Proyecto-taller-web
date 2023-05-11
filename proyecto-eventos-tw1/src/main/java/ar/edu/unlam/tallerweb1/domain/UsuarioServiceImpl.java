package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.DatosLogin;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements  UsuarioService{
    @Override
    public boolean validarMail(String correo) {
        return correo.contains("@") && correo.endsWith(".com");
    }
    @Override
    public boolean validarClave(String clave) {
        return clave.length() >= 6 && clave.matches(".*[A-Z].*") && clave.matches(".*\\d.*");
    }
    @Override
    public boolean buscarUsuarioPorCorreo(String correo) {
        //va a buscar el usuario en la bdd y como no existe, debería dar false
        Boolean usuarioExistente = false;
        return usuarioExistente;
    }
    @Override
    public DatosLogin obtenerUsuarioPorCorreo(String correo) {
        if(this.buscarUsuarioPorCorreo(correo)){
            /*logica para traer el usuario de ese correo*/
        }
        return null;
    }

    @Override
    public void registrarUsuario(String correo, String clave) {
        //este cargara los datos del usuario en una BDD
    }


    @Override
    public boolean compararMail(String correo) {
        /*DatosLogin usuario;
        usuario = obtenerUsuarioPorCorreo(correo);
        Boolean esValido=false;
        if(usuario.getCorreo().equals(correo)){
            esValido=true;
        }
        return esValido;*/
        return true;
    }

    @Override
    public boolean compararClave(String clave) {
        /*DatosLogin usuario;
        usuario = obtenerUsuarioPorCorreo(clave);
        Boolean esValido=false;
        if(usuario.getClave().equals(clave)){
            esValido=true;
        }
        return esValido;*/
        return true;
    }


}
