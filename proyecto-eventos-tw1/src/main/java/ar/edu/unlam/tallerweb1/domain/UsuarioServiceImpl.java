package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.delivery.DatosPreferencias;
import ar.edu.unlam.tallerweb1.delivery.DatosRegistracion;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

    
    private RepositorioUsuario repoUsuario;
    
    private RepositorioCategoria repoCategoria;
    
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(RepositorioUsuario repoUsuario, RepositorioCategoria repoCategoria, BCryptPasswordEncoder passwordEncoder) {
        this.repoUsuario = repoUsuario;
        this.repoCategoria = repoCategoria;
        this.passwordEncoder = passwordEncoder;
    }


	@Override
	public void guardarUsuario(DatosRegistracion datosRegistracion) {
		Usuario usuario = new Usuario(datosRegistracion.getNombre(), datosRegistracion.getApellido(), datosRegistracion.getLocalidad(), datosRegistracion.getCorreo(), datosRegistracion.getClave());
		List<Categoria> categoriasPreferidas = new ArrayList<>();
		List<Categoria> categorias = this.repoCategoria.findAll();
		for (Categoria c: categorias
			 ) { categoriasPreferidas.add(c);}
		usuario.setCategoriasPreferidas(categoriasPreferidas);
		hashearPassword(usuario);
		repoUsuario.save(usuario);
	}

	public void hashearPassword(Usuario usuario) {
		String p = usuario.getClave();
		String passwordHash = passwordEncoder.encode(p);
		usuario.setClave(passwordHash);
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
    //Regex validador de mail
    @Override
    public Boolean validarMail(String correo) {
		String regexEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regexEmail);
		Matcher matcher= pattern.matcher(correo);
		return matcher.matches();
    }
    //M�nimo 8 caracteres, incluyendo al menos 1 s�mbolo, may�scila, min�scula y n�mero
    @Override
    public Boolean validarClave(String clave) {
		String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()�[{}]:;',?/*~$^+=<>]).{8,20}$";
		Pattern pattern = Pattern.compile(regexPassword);
		Matcher matcher= pattern.matcher(clave);
		return matcher.matches();
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
		Usuario usuario = obtenerUsuarioPorCorreo(correo);
        return usuario != null && usuario.getCorreo().equals(correo);
    }

    @Override
    public Boolean compararClave(String correo, String clave) {
		Usuario usuario = obtenerUsuarioPorCorreo(correo);
        return usuario != null && passwordEncoder.matches(clave, usuario.getClave());
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

	@Override
	public void cambiarClave(Usuario usuario, String claveNueva) {
		usuario.setClave(claveNueva);
		this.hashearPassword(usuario);
		repoUsuario.update(usuario);
	}


	@Override
	public List<Categoria> obtenerMisCategoriasPreferidas(Long id) {
		return repoUsuario.obtenerMisCategoriasPreferidas(id);
	}


}
