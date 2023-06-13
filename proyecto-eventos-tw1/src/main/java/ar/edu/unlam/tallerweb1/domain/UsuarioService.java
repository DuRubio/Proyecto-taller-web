package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.delivery.DatosPreferencias;
import ar.edu.unlam.tallerweb1.delivery.DatosRegistracion;


public interface UsuarioService {
    Boolean validarMail(String correo);


    Boolean validarClave(String clave);


    //boolean buscarUsuarioPorCorreo(String correo);


    Boolean compararMail(String correo);

    Boolean compararClave(String correo, String clave);

    Usuario obtenerUsuarioPorCorreo(String correo);

    void guardarUsuario(DatosRegistracion datosRegistracion);


	void guardarPreferencias(DatosPreferencias usuario);
}