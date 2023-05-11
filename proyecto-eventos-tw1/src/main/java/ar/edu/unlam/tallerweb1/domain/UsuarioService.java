package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.delivery.DatosLogin;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
    boolean validarMail(String correo);


    boolean validarClave(String clave);


    boolean buscarUsuarioPorCorreo(String correo);

    void registrarUsuario(String correo, String clave);

    boolean compararMail(String correo);

    boolean compararClave(String clave);

    DatosLogin obtenerUsuarioPorCorreo(String correo);
}