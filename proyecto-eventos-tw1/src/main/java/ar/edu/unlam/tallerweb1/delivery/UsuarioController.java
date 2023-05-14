package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Usuario;
import ar.edu.unlam.tallerweb1.domain.UsuarioService;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuarioImpl;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

   private UsuarioService servicioRegistracion;
    private RepositorioUsuario repositorioUsuario; //para que no sea Null tengo que meterlo en el constructor en el Autowired

   @Autowired //esto solo inyecta instancias, por eso el atributo debe ser una instancia de ese servicio
    public UsuarioController(UsuarioService servicioRegistracion ){
        this.servicioRegistracion = servicioRegistracion; //va a recibir un servicio o su implementacion, depende lo que yo mockie en el inicializador en la clase de test
   }


   @RequestMapping(path = "/registrarme", method = RequestMethod.GET) //muestra la vista registro-usuario
    public ModelAndView getVistaRegistro() {
        ModelMap model = new ModelMap();
        model.put("datosRegistracion", new DatosRegistracion());
        return new ModelAndView("registrarse", model);
    }

    @RequestMapping(path = "/registrar-usuario", method = RequestMethod.POST) //analiza  mail y contrasenia válidos
    public ModelAndView registrarUsuario(@ModelAttribute DatosRegistracion datosRegistracion) {
        ModelMap model = new ModelMap();
        String viewName = "";
        if(this.servicioRegistracion.validarMail(datosRegistracion.getCorreo()) && this.servicioRegistracion.validarClave(datosRegistracion.getClave())){
            model.put("mensaje", "Registro exitoso");
            model.put("datosLogin", new DatosLogin(datosRegistracion.getCorreo(), datosRegistracion.getClave()));
          //  repositorioUsuario.save(new Usuario(datosRegistracion.getCorreo(),datosRegistracion.getClave())); //guardo el usuario en el repositorio
            viewName = "login";
        } else {
            model.put("mensaje", "Registro fallido, mail o clave inválido");
            viewName = "registrarse";
  }
        return new ModelAndView(viewName, model);
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET) //muestra el login
    public ModelAndView getVistaLogin() {
        ModelMap model = new ModelMap();
        model.put("datosLogin", new DatosLogin());
        return new ModelAndView("login", model);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST) //compara mail y clave con el ya registrado para validar inicio sesion
    public ModelAndView logearUsuario(DatosLogin usuarioValido) {
        ModelMap model = new ModelMap();
        String viewName = "";
        model.put("datosLogin", new DatosLogin());
        if(this.servicioRegistracion.compararMail(usuarioValido.getCorreo()) && this.servicioRegistracion.compararClave(usuarioValido.getCorreo(),usuarioValido.getClave())){
            model.put("mensaje","Login exitoso");
            viewName = "home";
        }else{
            model.put("mensaje", "mail o clave incorrecta");
            viewName = "login";
        }
        return new ModelAndView(viewName, model);
    }



}
