package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.EventoService;
import ar.edu.unlam.tallerweb1.domain.EventoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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


    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public ModelAndView getVistaHome() {
        return new ModelAndView("home");
    }

    @RequestMapping(path = "/home/filtrar", method = RequestMethod.GET)
    public ModelAndView filtrarEventos(
            @RequestParam(value = "filtro-fecha", required = false) String fecha,
            @RequestParam(value = "localidad", required = false) String localidad,
            @RequestParam(value = "categoria", required = false) String categoria) {
        // Lógica para filtrar los eventos según los parámetros proporcionados

        // Agrega los eventos filtrados al modelo para mostrarlos en la vista
        //model.addAttribute("events", filteredEvents);

        // Retorna el nombre de la vista que mostrará los eventos filtrados
        return new ModelAndView();
    }

}
