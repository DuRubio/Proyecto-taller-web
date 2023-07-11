package ar.edu.unlam.tallerweb1.domain;



import ar.edu.unlam.tallerweb1.delivery.DatosPreferencias;
import ar.edu.unlam.tallerweb1.delivery.DatosRegistracion;


public interface UsuarioService {
	
    Boolean validarMail(String correo);

    Boolean validarClave(String clave);

    Boolean compararMail(String correo);

    Boolean compararClave(String correo, String clave);

    Usuario obtenerUsuarioPorCorreo(String correo);

    Usuario obtenerUsuarioPorID(Long id);

    void guardarUsuario(DatosRegistracion datosRegistracion);

    Long getId(String correo);

    void setAdmin(Usuario usuario, Boolean decision);

	void guardarPreferencias(Long id, DatosPreferencias datosPreferencias);

    void cambiarClave(Usuario usuario, String claveNueva);


}