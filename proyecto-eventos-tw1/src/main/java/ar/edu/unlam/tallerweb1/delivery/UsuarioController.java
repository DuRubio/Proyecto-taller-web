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

import java.security.Principal;

@Controller
public class UsuarioController {

    private UsuarioService usuarioService;
    private Long id;

    @Autowired //esto solo inyecta instancias, por eso el atributo debe ser una instancia de ese servicio
    public UsuarioController(UsuarioService servicioRegistracion) {
        this.usuarioService = servicioRegistracion; //va a recibir un servicio o su implementacion, depende lo que yo mockie en el inicializador en la clase de test
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

        @RequestMapping(path = "/login", method = RequestMethod.POST) //compara mail y clave con el ya registrado para validar inicio sesion
        public ModelAndView logearUsuario(@RequestParam(value = "usuario", required = true) String correo,
                                          @RequestParam(value = "clave", required = true) String clave){
            ModelMap model = new ModelMap();
            DatosLogin usuarioValido = new DatosLogin(correo, clave);
            model.put("datosLogin", new DatosLogin());
            String viewName = "";
            if (this.usuarioService.compararMail(usuarioValido.getCorreo()) && this.usuarioService.compararClave(usuarioValido.getCorreo(), usuarioValido.getClave())) {
                this.id = usuarioService.getId(correo);
                viewName="redirect:/home";
                //usuarioValido.isLogeado(true);
            } else {
                this.id = null;
                model.put("mensaje", "mail o clave incorrecta");
                viewName="login";
            }
            return new ModelAndView(viewName, model);
        }

        @RequestMapping(path = "/my-profile", method = RequestMethod.GET)
        public ModelAndView getVistaMiPerfil() {
            ModelMap model = new ModelMap();

            Usuario usuario = usuarioService.obtenerUsuarioPorID(this.id);

            if (usuario != null) {
                model.put("usuario", usuario);
                return new ModelAndView("my-profile", model);
            } else {
                model.put("mensaje", "El usuario no existe");
                return new ModelAndView("login", model);
            }
        }
        
        @RequestMapping(path="editar-mis-preferencias", method = RequestMethod.GET)
		public ModelAndView editarMisPreferencias() {
        	ModelAndView modelAndView = new ModelAndView("editar-mis-preferencias");
            modelAndView.addObject("datosPreferencias", new DatosPreferencias());
            return modelAndView;
		}
        
        @RequestMapping(path = "/guardar-preferencias-usuario", method = RequestMethod.POST)
        public ModelAndView guardarPreferenciasUsuario(@ModelAttribute("datosPreferencias") DatosPreferencias datosPreferencias) {
            usuarioService.guardarPreferencias(datosPreferencias);
            return new ModelAndView("home");
        }


    }
