package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.delivery.DatosPreferencias;
import ar.edu.unlam.tallerweb1.delivery.DatosRegistracion;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

    
    private RepositorioUsuario repoUsuario;
    
    private RepositorioCategoria repoCategoria;

    @Autowired
    public UsuarioServiceImpl(RepositorioUsuario repoUsuario, RepositorioCategoria repoCategoria){
        this.repoUsuario=repoUsuario;
        this.repoCategoria = repoCategoria;
    }

    public UsuarioServiceImpl(){

    }

    @Override
    public void guardarUsuario(DatosRegistracion datosRegistracion) {
        Usuario usuario = new Usuario(datosRegistracion.getNombre(), datosRegistracion.getApellido(), datosRegistracion.getLocalidad(), datosRegistracion.getCorreo(), datosRegistracion.getClave());
        repoUsuario.save(usuario);
        }

    @Override
    public Long getId(String correo) {
        Usuario usuario = repoUsuario.buscarPorCorreo(correo);
        return usuario.getId();
    }


    @Override
    public void setAdmin(Usuario usuario, Boolean decision) {
        usuario.isAdmin(decision);
        repoUsuario.hacerAdminEnBdd(usuario);
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
    public Usuario obtenerUsuarioPorID(Long id) {
        return repoUsuario.buscarPorId(id);
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
	public void guardarPreferencias(Long id, DatosPreferencias datosPreferencias) {
		Usuario usuario = new Usuario();
		usuario = this.repoUsuario.buscarPorId(id);
		List<Categoria> categoriasPreferidas = new ArrayList<>();
		List<Categoria> categorias = this.repoCategoria.findAll();
		Categoria categoria = new Categoria();
		
		if(datosPreferencias.getDeportivo() == Boolean.TRUE) {
			categoria = categorias.get(0);
			categoriasPreferidas.add(categoria);
		}
		if(datosPreferencias.getMusical() == Boolean.TRUE) {
			categoria = categorias.get(1);
			categoriasPreferidas.add(categoria);
		}
		if(datosPreferencias.getBailable() == Boolean.TRUE) {
			categoria = categorias.get(2);
			categoriasPreferidas.add(categoria);
		}
		if(datosPreferencias.getTeatral() == Boolean.TRUE) {
			categoria = categorias.get(3);
			categoriasPreferidas.add(categoria);
		}
		if(datosPreferencias.getRecital() == Boolean.TRUE) {
			categoria = categorias.get(4);
			categoriasPreferidas.add(categoria);
		}
		if(datosPreferencias.getCine() == Boolean.TRUE) {
			categoria = categorias.get(5);
			categoriasPreferidas.add(categoria);
		}
		if(datosPreferencias.getCultural() == Boolean.TRUE) {
			categoria = categorias.get(6);
			categoriasPreferidas.add(categoria);
		}
		if(datosPreferencias.getGastronomico() == Boolean.TRUE) {
			categoria = categorias.get(7);
			categoriasPreferidas.add(categoria);
		}
		if(datosPreferencias.getFeria() == Boolean.TRUE) {
			categoria = categorias.get(8);
			categoriasPreferidas.add(categoria);
		}
		if(datosPreferencias.getMarcha() == Boolean.TRUE) {
			categoria = categorias.get(9);
			categoriasPreferidas.add(categoria);
		}
		usuario.setCategoriasPreferidas(categoriasPreferidas);
		
        if(categoriasPreferidas.size() > 0) {
        	repoUsuario.update(usuario);
        }
		
	}


}
