package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.delivery.DatosPreferencias;
import ar.edu.unlam.tallerweb1.delivery.DatosRegistracion;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

    @Autowired
    RepositorioUsuario repoUsuario;

    public UsuarioServiceImpl(RepositorioUsuario repoUsuario){
        this.repoUsuario=repoUsuario;
    }

    public UsuarioServiceImpl(){

    }

    @Override
    public void guardarUsuario(DatosRegistracion datosRegistracion) {
        Usuario usuario = new Usuario(datosRegistracion.getNombre(), datosRegistracion.getApellido(), datosRegistracion.getLocalidad(), datosRegistracion.getCorreo(), datosRegistracion.getClave());
        repoUsuario.save(usuario);
        }



    @Override
    public Boolean validarMail(String correo) {
        return correo.contains("@") && correo.endsWith(".com");
    }
    @Override
    public Boolean validarClave(String clave) {
        return clave.length() >= 6 && clave.matches(".*[A-Z].*") && clave.matches(".*\\d.*");
    }

    @Override
    public Usuario obtenerUsuarioPorCorreo(String correo) {

        return repoUsuario.buscarPorCorreo(correo);
    }

    @Override
    public Boolean compararMail(String correo) {
        Usuario usuario;
        usuario = obtenerUsuarioPorCorreo(correo);
        Boolean esValido=false;
        if(usuario!= null) {
            if (usuario.getCorreo().equals(correo)) {
                esValido = true;
            }
        }
        return esValido;

    }

    @Override
    public Boolean compararClave(String correo, String clave) {
        Usuario usuario;
        usuario = obtenerUsuarioPorCorreo(correo);
        Boolean esValido=false;
        if(usuario!= null) {
            if (usuario.getClave().equals(clave)) {
                esValido = true;
            }
        }
        return esValido;

    }

	@Override
	public void guardarPreferencias(DatosPreferencias datosPreferencias) {
		Usuario usuario = new Usuario();
		usuario = this.repoUsuario.buscarPorId(1L);
		usuario.setMusical(datosPreferencias.getMusical());
		//, datosPreferencias.getDeportivo(),datosPreferencias.getBailable(),datosPreferencias.getTeatral(),datosPreferencias.getRecital(),datosPreferencias.getCine(),datosPreferencias.getCultural(),datosPreferencias.getGastronomico(),datosPreferencias.getFeria(),datosPreferencias.getMarcha(),datosPreferencias.getInfantil(),datosPreferencias.getJuvenil(),datosPreferencias.getAdultos(),datosPreferencias.getJubilados(),datosPreferencias.getTodasLasEdades(),datosPreferencias.getAireLibre(),datosPreferencias.getTeatro(),datosPreferencias.getEstadio(),datosPreferencias.getCentroCultural(),datosPreferencias.getMatutino(),datosPreferencias.getVespertino(),datosPreferencias.getNocturno());
        repoUsuario.update(usuario);
		
	}


}
