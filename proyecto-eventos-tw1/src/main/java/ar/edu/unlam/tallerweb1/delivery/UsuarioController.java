package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.UsuarioService;
import ar.edu.unlam.tallerweb1.domain.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

   // private UsuarioService servicioRegistracion = new UsuarioServiceImpl();
   private UsuarioService servicioRegistracion = new UsuarioServiceImpl();


   /*@Autowired //esto solo inyecta instancias, por eso el atributo debe ser una instancia de ese servicio
    public UsuarioController(UsuarioService servicioRegistracion){
        this.servicioRegistracion = servicioRegistracion; //va a recibir un servicio o su implementacion, depende lo que yo mockie en el inicializador en la clase de test
    }*/




    public ModelAndView getVistaRegistro() {
        return new ModelAndView("registro-usuario");
    }

    public ModelAndView registrarUsuario(DatosRegistracion datosRegistracion) {
        ModelMap model = new ModelMap();
        String viewName = "";


        if(this.servicioRegistracion.validarMail(datosRegistracion.getCorreo()) && this.servicioRegistracion.validarClave(datosRegistracion.getClave()) && !this.servicioRegistracion.buscarUsuarioPorCorreo(datosRegistracion.getCorreo())){
            model.put("mensaje", "Registro exitoso");
            model.put("datosLogin", new DatosLogin(datosRegistracion.getCorreo(), datosRegistracion.getClave()));
            servicioRegistracion.registrarUsuario(datosRegistracion.getCorreo(), datosRegistracion.getClave());
            viewName = "login";
        } else {
            model.put("mensaje", "Registro fallido");
            viewName = "registro-usuario";
  }
        return new ModelAndView(viewName, model);
    }

    public ModelAndView logearUsuario(DatosLogin usuarioValido) {
        ModelMap model = new ModelMap();
        String viewName = "";

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
