package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.WriterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class UsuarioController {

    private UsuarioService usuarioService;
    private EventoService eventoService;
    private EntradaService servicioEntrada;
    private Long id;
    Usuario usuario;

    boolean isLogeado=false;

    @Autowired //esto solo inyecta instancias, por eso el atributo debe ser una instancia de ese servicio
    public UsuarioController(UsuarioService servicioRegistracion, EventoService eventoService, EntradaService servicioEntrada) {
        this.usuarioService = servicioRegistracion; //va a recibir un servicio o su implementacion, depende lo que yo mockie en el inicializador en la clase de test
        this.eventoService = eventoService;
        this.servicioEntrada=servicioEntrada;
    }


    @RequestMapping(path = "/registrarme", method = RequestMethod.GET) //muestra la vista registro-usuario
    public ModelAndView getVistaRegistro() {
        ModelMap model = new ModelMap();
        model.put("datosRegistracion", new DatosRegistracion());
        return new ModelAndView("registrarse", model);
    }

    @RequestMapping(path = "/registrarme", method = RequestMethod.POST) //analiza  mail y contrasenia válidos
    public ModelAndView registrarUsuario(@ModelAttribute DatosRegistracion datosRegistracion) {
        ModelMap model = new ModelMap();
        String viewName = "";

        if (this.usuarioService.obtenerUsuarioPorCorreo(datosRegistracion.getCorreo()) == null) {
            if (this.usuarioService.validarMail(datosRegistracion.getCorreo()) && this.usuarioService.validarClave(datosRegistracion.getClave())) {
                model.put("mensaje", "Registro exitoso");
                model.put("datosLogin", new DatosLogin(datosRegistracion.getCorreo(), datosRegistracion.getClave()));
                viewName = "login";
                usuarioService.guardarUsuario(datosRegistracion);
            } else {
                model.put("mensaje", "Registro fallido, mail o clave inválido");
                viewName = "registrarse";
            }
        }else{
                model.put("mensaje", "Usuario existente");
                viewName = "login";
            }
            return new ModelAndView(viewName, model);
        }

        @RequestMapping(path = "/login", method = RequestMethod.GET) //muestra el login
        public ModelAndView getVistaLogin () {
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

        if (this.usuarioService.compararMail(usuarioValido.getCorreo()) && this.usuarioService.compararClave(usuarioValido.getCorreo(), usuarioValido.getClave())) {
            this.id = usuarioService.getId(correo);
            usuario = usuarioService.obtenerUsuarioPorID(this.id);
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", usuario);
            viewName = "redirect:/home";
        } else {
            this.id = null;
            model.put("mensaje", "Mail o clave incorrecta");
            viewName = "login";
        }

        return new ModelAndView(viewName, model);
    }




         @RequestMapping(path = "/logout", method = RequestMethod.GET)
         public ModelAndView logOut(HttpServletRequest request) {
            request.getSession().invalidate();
            this.id=null;
             String viewName = "redirect:/login";
             return new ModelAndView(viewName);

         }
    @Transactional
    @RequestMapping(path = "/asistir", method = RequestMethod.GET)
    public ModelAndView asistir(HttpServletRequest request , @RequestParam("eventoId") Long eventoId) {
        Entrada entrada = new Entrada();
        List<Entrada> entradas;
        HttpSession session = request.getSession(false);
        String viewName = "";
        ModelMap model = new ModelMap();
        if (session != null && session.getAttribute("usuario") != null) {
            Evento evento = eventoService.buscarPorId(eventoId);
            servicioEntrada.asignarEntrada(usuario, evento);
            entradas = this.usuario.getEntradas();
            model.put("entradas",entradas);
            viewName = "asistir";
        } else {
            model.put("mensaje", "Debe estar logeado para poder asistir a un evento");
            viewName= "login";
        }

        return new ModelAndView(viewName, model);
    }



        @RequestMapping(path = "my-profile", method = RequestMethod.GET)
        public ModelAndView getVistaMiPerfil() {
            ModelMap model = new ModelMap();
            Usuario usuario = usuarioService.obtenerUsuarioPorID(this.id);
            model.put("usuario", usuario);
            return new ModelAndView("my-profile", model);

        }

    @RequestMapping(path = "/my-profile/admin", method = RequestMethod.POST)
    public ModelAndView userIsAdmin(@RequestParam(value="claveAdmin", required= true) String claveAdmin) {
        usuario = usuarioService.obtenerUsuarioPorID(this.id);
        ModelMap model = new ModelMap();
        if(claveAdmin.equals("eventos1234")) {
            usuarioService.setAdmin(usuario, true);
            model.put("mostrarPopup", true);
        } else {
            model.put("mostrarPopup2", true);
        }

        return new ModelAndView("my-profile", model);
    }


    @RequestMapping(path = "/my-profile/notadmin", method = RequestMethod.GET)
    public ModelAndView notAdmin() {
        usuario = usuarioService.obtenerUsuarioPorID(this.id);
        usuarioService.setAdmin(usuario, false);
        String viewName="redirect:/my-profile";
        return new ModelAndView(viewName);

    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public ModelAndView getVistaHome() {
        ModelMap model = new ModelMap();
        List<Evento> eventos = this.eventoService.getPrimeros4Eventos();
        List<Evento> eventosSegunPreferencias = this.eventoService.buscarEventosPorPreferenciasHome(usuario);
        model.put("eventos", eventos);
        model.put("eventosSegunPreferencias", eventosSegunPreferencias);
        if(this.id!=null) {
            usuario = usuarioService.obtenerUsuarioPorID(this.id);
            model.put("usuario", usuario);
        }
        ModelAndView mav = new ModelAndView("home", model);
        return mav;
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
		String viewName = "redirect:/home";
        return new ModelAndView(viewName);
	}


	@RequestMapping(path = "mis-entradas", method = RequestMethod.GET )
	public ModelAndView misEntradas() {
		Long id = this.id;
		ModelMap model = new ModelMap();
		List<Entrada> entradas = this.servicioEntrada.listarMisEntradas(id);
		model.put("entradas", entradas);
		ModelAndView mav = new ModelAndView("mis-entradas", model);
		return mav;
	}
	
	@RequestMapping(path = "/entrada", method = RequestMethod.GET)
    public ModelAndView generarQR(@RequestParam("entradaId") Long id) {
        ModelMap model = new ModelMap();
        
        Entrada entrada = obtenerEntradaPorId(id);
        model.put("datosEntrada", entrada);

        String qrCodeText = "https://localhost:8080/proyecto-limpio-spring/entrada/" + entrada.getId();
        int qrCodeSize = 200;
        try {
            BufferedImage qrCodeImage = QRCodeGenerator.generateQRCodeImage(qrCodeText, qrCodeSize);
            byte[] qrCodeBytes = QRCodeGenerator.convertImageToByteArray(qrCodeImage, "png");
            String qrCodeBase64 = Base64.getEncoder().encodeToString(qrCodeBytes);

            model.put("qrCodeBase64", qrCodeBase64);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        
        return new ModelAndView("entrada", model);
    }

    private Entrada obtenerEntradaPorId(Long id) {
        return servicioEntrada.buscarPorId(id);
    }


    @Transactional //que aparezca un popup seguro queres eliminar? aceptar | cancelar
    @RequestMapping(path = "/eliminar", method = RequestMethod.GET)
    public ModelAndView eliminarEvento(HttpServletRequest request , @RequestParam("eventoId") Long eventoId) {
        HttpSession session = request.getSession(false);
        String viewName = "";
        ModelMap model = new ModelMap();
        if (session != null && session.getAttribute("usuario")!= null && usuario.getIsAdmin()) {
            eventoService.setInactivo(eventoId);
            viewName= "redirect:/home";  //que aparezca un popup con eevento eliminado con exito
        } else {
            model.put("mensaje", "Debe ser admin para eliminar un evento");
            viewName= "redirect:/my-profile";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping(path="mostrar-eventos", method = RequestMethod.GET)
    public ModelAndView mostrarEventos() {
        ModelMap model = new ModelMap();
        List<Evento> eventos = eventoService.getEventos();
        model.put("eventos", eventos);
        if(this.id!=null) {
            usuario = usuarioService.obtenerUsuarioPorID(this.id);
            model.put("usuario", usuario);
        }
        ModelAndView mav = new ModelAndView("mostrar-eventos", model);

        return mav;
    }



    @RequestMapping(path = "/my-profile/cambiar-clave", method = RequestMethod.GET)
    public ModelAndView cambiarClave(@RequestParam("usuarioId") Long usuarioId) {
        usuario = usuarioService.obtenerUsuarioPorID(usuarioId);
        ModelMap model = new ModelMap();
        model.put("usuario",usuario);
        String viewName="cambiar-clave";
        return new ModelAndView(viewName,model);

    }

    @RequestMapping(path = "/my-profile/cambiarclave", method = RequestMethod.POST)
    public ModelAndView cambiarClave(
                                     @RequestParam("claveVieja") String claveVieja,
                                     @RequestParam("claveNueva1") String claveNueva1,
                                     @RequestParam("claveNueva") String claveNueva) {
        //usuario = usuarioService.obtenerUsuarioPorID(usuarioId);
        ModelMap model = new ModelMap();
        String viewName;
        viewName = "cambiar-clave";

        if(!usuarioService.compararClave(usuario.getCorreo(), claveVieja)){
            model.put("errorClave1", "La clave es incorrecta");
        }
        if(!claveNueva1.equals(claveNueva)){
            model.put("errorClave2", "Las claves no son iguales");
        }
        if(!usuarioService.validarClave(claveNueva)){
            model.put("errorClave2", "La clave es inválida");
        }
        if(usuarioService.compararClave(usuario.getCorreo(), claveVieja) && claveNueva1.equals(claveNueva) && usuarioService.validarClave(claveNueva)){
            usuarioService.cambiarClave(usuario, claveNueva);
            viewName = "redirect:/logout";
                    }
        return new ModelAndView(viewName,model);

    }


}

