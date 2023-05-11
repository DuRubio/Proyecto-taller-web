package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.EventoService;
import ar.edu.unlam.tallerweb1.domain.EventoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EventoController {

    private EventoService servicioEvento = new EventoServiceImpl();
    @RequestMapping(path = "/registrar-evento", method = RequestMethod.GET)
    public ModelAndView getVistaRegistro() {
        return new ModelAndView("registro-evento");

    }

    @RequestMapping(path = "/registro-evento", method = RequestMethod.POST)
    public ModelAndView registrarEvento(@ModelAttribute DatosEvento eventoEjemplo) {
        ModelMap model = new ModelMap();
        String viewName = "";

          if(this.servicioEvento.validarNombre(eventoEjemplo.getNombre()) && this.servicioEvento.validarLocalidad(eventoEjemplo.getLocalidad())){
                model.put("mensaje","Evento registrado");
                model.put("datosEvento", eventoEjemplo);
                viewName = "home";
          } else {
                model.put("mensaje", "Registro fallido");
                viewName = "registro-evento";
          }
            return new ModelAndView(viewName, model);
        }

}
