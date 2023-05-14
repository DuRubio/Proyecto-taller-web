package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.delivery.DatosLogin;
import org.springframework.stereotype.Service;


public interface UsuarioService {
    Boolean validarMail(String correo);


    Boolean validarClave(String clave);


    //boolean buscarUsuarioPorCorreo(String correo);

    void registrarUsuario(String correo, String clave);

    Boolean compararMail(String correo);

    Boolean compararClave(String correo, String clave);

    Usuario obtenerUsuarioPorCorreo(String correo);
}