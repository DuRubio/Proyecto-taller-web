package ar.edu.unlam.tallerweb1.delivery;


import ar.edu.unlam.tallerweb1.domain.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class UsuarioController {

    private UsuarioService servicioRegistracion;

    @Autowired //esto solo inyecta instancias, por eso el atributo debe ser una instancia de ese servicio
    public UsuarioController(UsuarioService servicioRegistracion) {
        this.servicioRegistracion = servicioRegistracion; //va a recibir un servicio o su implementacion, depende lo que yo mockie en el inicializador en la clase de test
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

        if (this.servicioRegistracion.obtenerUsuarioPorCorreo(datosRegistracion.getCorreo()) == null) {
            if (this.servicioRegistracion.validarMail(datosRegistracion.getCorreo()) && this.servicioRegistracion.validarClave(datosRegistracion.getClave())) {
                model.put("mensaje", "Registro exitoso");
                model.put("datosLogin", new DatosLogin(datosRegistracion.getCorreo(), datosRegistracion.getClave()));
                viewName = "login";
                servicioRegistracion.guardarUsuario(datosRegistracion);
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
            if (this.servicioRegistracion.compararMail(usuarioValido.getCorreo()) && this.servicioRegistracion.compararClave(usuarioValido.getCorreo(), usuarioValido.getClave())) {
                viewName="home";
            } else {
                model.put("mensaje", "mail o clave incorrecta");
                viewName="login";
            }
            return new ModelAndView(viewName, model);
        }

        @RequestMapping(path="editar-mis-preferencias", method = RequestMethod.GET)
		public ModelAndView editarMisPreferencias() {
			ModelMap model = new ModelMap();
            model.put("datosPreferencias", new DatosPreferencias());
            return new ModelAndView("editar-mis-preferencias", model);
		}
        
        @RequestMapping(path = "/guardar-preferencias-usuario", method = RequestMethod.POST) //compara mail y clave con el ya registrado para validar inicio sesion
        public ModelAndView logearUsuario(@RequestParam(value = "musical", required = true) Boolean musical, 
        		@RequestParam(value = "deportivo", required = true) Boolean deportivo, @RequestParam(value = "bailable", required = true) Boolean bailable, 
        		@RequestParam(value = "teatral", required = true) Boolean teatral,@RequestParam(value = "recital", required = true) Boolean recital,
        		@RequestParam(value = "cine", required = true) Boolean cine,@RequestParam(value = "cultural", required = true) Boolean cultural,@RequestParam(value = "gastronomico", required = true) Boolean gastronomico,
        		@RequestParam(value = "feria", required = true) Boolean feria,@RequestParam(value = "marcha", required = true) Boolean marcha,@RequestParam(value = "infantil", required = true) Boolean infantil,
        		@RequestParam(value = "juvenil", required = true) Boolean juvenil,@RequestParam(value = "adultos", required = true) Boolean adultos,@RequestParam(value = "jubilados", required = true) Boolean jubilados,
        		@RequestParam(value = "todasLasEdades", required = true) Boolean todasLasEdades,@RequestParam(value = "aireLibre", required = true) Boolean aireLibre,@RequestParam(value = "teatro", required = true) Boolean teatro,
        		@RequestParam(value = "estadio", required = true) Boolean estadio,@RequestParam(value = "centroCultural", required = true) Boolean centroCultural,
        		@RequestParam(value = "matutino", required = true) Boolean matutino,@RequestParam(value = "vespertino", required = true) Boolean vespertino,@RequestParam(value = "nocturno", required = true) Boolean nocturno	){
            ModelMap model = new ModelMap();
            DatosPreferencias usuario = new DatosPreferencias(musical, deportivo, bailable, teatral, recital, cine, cultural, gastronomico, feria, marcha, infantil, juvenil, adultos, jubilados, todasLasEdades, aireLibre, teatro, estadio, centroCultural, matutino, vespertino, nocturno);
            model.put("datosPreferencias", new DatosPreferencias());
            String viewName = "home";
            this.servicioRegistracion.guardarPreferencias(usuario); {
                viewName="home";
            return new ModelAndView(viewName, model);
        }

    /*public ModelAndView logearUsuario (@ModelAttribute DatosLogin usuarioValido){
            ModelMap model = new ModelMap();
            String viewName = "";
            model.put("datosLogin", new DatosLogin());
            if (this.servicioRegistracion.compararMail(usuarioValido.getCorreo()) && this.servicioRegistracion.compararClave(usuarioValido.getCorreo(), usuarioValido.getClave())) {
                model.put("mensaje", "Login exitoso");
                viewName = "home";
            } else {
                model.put("mensaje", "mail o clave incorrecta");
                viewName = "login";
            }
            return new ModelAndView(viewName, model);
        }*/


    }
}
