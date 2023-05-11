package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.UsuarioService;
import ar.edu.unlam.tallerweb1.domain.UsuarioServiceImpl;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

   // private UsuarioService servicioRegistracion = new UsuarioServiceImpl();
   //private UsuarioService servicioRegistracion = new UsuarioServiceImpl();
   private UsuarioService servicioRegistracion;


   @Autowired //esto solo inyecta instancias, por eso el atributo debe ser una instancia de ese servicio
    public UsuarioController(UsuarioService servicioRegistracion){
        this.servicioRegistracion = servicioRegistracion; //va a recibir un servicio o su implementacion, depende lo que yo mockie en el inicializador en la clase de test
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView getVistaLogin() {
       ModelMap model = new ModelMap();
       model.put("datosLogin", new DatosLogin());
       return new ModelAndView("loguearse", model);
    }

    @RequestMapping(path = "/registrarme", method = RequestMethod.GET)
    public ModelAndView getVistaRegistro() {
        ModelMap model = new ModelMap();
        model.put("datosRegistracion", new DatosRegistracion());
        return new ModelAndView("registro-usuario", model);
    }

    @RequestMapping(path = "/registro-usuario", method = RequestMethod.POST)
    public ModelAndView registrarUsuario(@ModelAttribute DatosRegistracion datosRegistracion) {
        ModelMap model = new ModelMap();
        String viewName = "";


        if(this.servicioRegistracion.validarMail(datosRegistracion.getCorreo()) && this.servicioRegistracion.validarClave(datosRegistracion.getClave()) && !this.servicioRegistracion.buscarUsuarioPorCorreo(datosRegistracion.getCorreo())){
            model.put("mensaje", "Registro exitoso");
            model.put("datosLogin", new DatosLogin(datosRegistracion.getCorreo(), datosRegistracion.getClave()));
           // servicioRegistracion.registrarUsuario(datosRegistracion.getCorreo(), datosRegistracion.getClave());
            viewName = "login";
        } else {
            model.put("mensaje", "Registro fallido");
            viewName = "registro-usuario";
  }
        return new ModelAndView(viewName, model);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView logearUsuario(DatosLogin usuarioValido) {
        ModelMap model = new ModelMap();
        String viewName = "";
        model.put("datosLogin", new DatosLogin());

        if(this.servicioRegistracion.compararMail(usuarioValido.getCorreo()) && this.servicioRegistracion.compararClave(usuarioValido.getClave())){
            model.put("mensaje","Login exitoso");
            viewName = "index";
        }else{
            model.put("mensaje", "mail o clave incorrecta");
            viewName = "login";
        }
        return new ModelAndView(viewName, model);
    }

}
