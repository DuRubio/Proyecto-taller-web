package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Usuario;
import ar.edu.unlam.tallerweb1.domain.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UsuarioController {

	private UsuarioService usuarioService;
	private Long id;
	Usuario usuario;
	boolean isLogeado = false;

	@Autowired // esto solo inyecta instancias, por eso el atributo debe ser una instancia de
				// ese servicio
	public UsuarioController(UsuarioService servicioRegistracion) {
		this.usuarioService = servicioRegistracion; // va a recibir un servicio o su implementacion, depende lo que yo
													// mockie en el inicializador en la clase de test
	}

	@RequestMapping(path = "/registrarme", method = RequestMethod.GET) // muestra la vista registro-usuario
	public ModelAndView getVistaRegistro() {
		ModelMap model = new ModelMap();
		model.put("datosRegistracion", new DatosRegistracion());
		return new ModelAndView("registrarse", model);
	}

	@RequestMapping(path = "/registrarme", method = RequestMethod.POST) // analiza mail y contrasenia válidos
	public ModelAndView registrarUsuario(@ModelAttribute DatosRegistracion datosRegistracion) {
		ModelMap model = new ModelMap();
		String viewName = "";

		if (this.usuarioService.obtenerUsuarioPorCorreo(datosRegistracion.getCorreo()) == null) {
			if (this.usuarioService.validarMail(datosRegistracion.getCorreo())
					&& this.usuarioService.validarClave(datosRegistracion.getClave())) {
				model.put("mensaje", "Registro exitoso");
				model.put("datosLogin", new DatosLogin(datosRegistracion.getCorreo(), datosRegistracion.getClave()));
				viewName = "login";
				usuarioService.guardarUsuario(datosRegistracion);
			} else {
				model.put("mensaje", "Registro fallido, mail o clave inválido");
				viewName = "registrarse";
			}
		} else {
			model.put("mensaje", "Usuario existente");
			viewName = "login";
		}
		return new ModelAndView(viewName, model);
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET) // muestra el login
	public ModelAndView getVistaLogin() {
		ModelMap model = new ModelMap();
		model.put("datosLogin", new DatosLogin());
		return new ModelAndView("login", model);
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView logearUsuario(HttpServletRequest request,
			@RequestParam(value = "usuario", required = true) String correo,
			@RequestParam(value = "clave", required = true) String clave) {
		ModelMap model = new ModelMap();
		DatosLogin usuarioValido = new DatosLogin(correo, clave);
		model.put("datosLogin", new DatosLogin());
		String viewName = "";

		if (this.usuarioService.compararMail(usuarioValido.getCorreo())
				&& this.usuarioService.compararClave(usuarioValido.getCorreo(), usuarioValido.getClave())) {
			this.id = usuarioService.getId(correo);
			usuario = usuarioService.obtenerUsuarioPorID(this.id);
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", usuario);
			viewName = "redirect:/home";
		} else {
			this.id = null;
			model.put("mensaje", "mail o clave incorrecta");
			viewName = "login";
		}

		return new ModelAndView(viewName, model);
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public ModelAndView logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		String viewName = "redirect:/home";
		return new ModelAndView(viewName);

	}

	@RequestMapping(path = "/asistir", method = RequestMethod.GET)
	public ModelAndView asistir(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String viewName = "";
		ModelMap model = new ModelMap();
		if (session != null && session.getAttribute("usuario") != null) {
			viewName = "asistir";
		} else {
			model.put("mensaje", "Debe estar logeado para poder asistir a un evento");
			viewName = "login";
		}

		return new ModelAndView(viewName, model);
	}

	@RequestMapping(path = "/my-profile", method = RequestMethod.GET)
	public ModelAndView getVistaMiPerfil() {
		ModelMap model = new ModelMap();
		Usuario usuario = usuarioService.obtenerUsuarioPorID(this.id);
		model.put("usuario", usuario);
		return new ModelAndView("my-profile", model);

	}

	@RequestMapping(path = "/my-profile/admin", method = RequestMethod.GET)
	public ModelAndView userIsAdmin() {
		usuario = usuarioService.obtenerUsuarioPorID(this.id);
		usuarioService.setAdmin(usuario, true);
		ModelMap model = new ModelMap();
		model.put("mostrarPopup", true);
		return new ModelAndView("my-profile", model);
	}

	@RequestMapping(path = "/my-profile/notadmin", method = RequestMethod.GET)
	public ModelAndView notAdmin() {
		usuario = usuarioService.obtenerUsuarioPorID(this.id);
		usuarioService.setAdmin(usuario, false);
		String viewName = "redirect:/my-profile";
		return new ModelAndView(viewName);

	}

	@RequestMapping(path = "editar-mis-preferencias", method = RequestMethod.GET)
	public ModelAndView editarMisPreferencias() {
		ModelAndView modelAndView = new ModelAndView("editar-mis-preferencias");
		modelAndView.addObject("datosPreferencias", new DatosPreferencias());
		return modelAndView;
	}

	@RequestMapping(path = "/guardar-preferencias-usuario", method = RequestMethod.POST)
	public ModelAndView guardarPreferenciasUsuario(
			@ModelAttribute("datosPreferencias") DatosPreferencias datosPreferencias) {
		Long id = this.id;
		usuarioService.guardarPreferencias(id, datosPreferencias);
		return new ModelAndView("home");
	}

}
