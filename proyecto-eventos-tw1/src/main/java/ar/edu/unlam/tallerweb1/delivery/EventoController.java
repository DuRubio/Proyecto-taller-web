package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Evento;
import ar.edu.unlam.tallerweb1.domain.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class EventoController {

    private EventoService servicioEvento;
    @Autowired

    public EventoController(EventoService servicioRegEvento) {
        this.servicioEvento=servicioRegEvento;
    }


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


    /*@RequestMapping(path = "/mostrar-eventos", method = RequestMethod.GET)
    public ModelAndView getVistaEventos() {
        return new ModelAndView("mostrar-eventos");
    }*/

    @RequestMapping("/mostrar-eventos")
    public String mostrarEventos(Model model) {
        List<Evento> eventos = servicioEvento.getEventos();
        model.addAttribute("eventos", eventos);
        return "mostrar-eventos.jsp";
    }

    @RequestMapping(path = "/home/filtrar", method = RequestMethod.GET)
    public ModelAndView filtrarEventos(
            @RequestParam(value = "filtro-fecha", required = false) Date fecha,
            @RequestParam(value = "localidad", required = false) String localidad,
            @RequestParam(value = "categoria", required = false) TipoDeEvento categoria) {

        List<Evento> eventosFiltrados = new ArrayList<>();
        ModelMap model = new ModelMap();
        String mensaje = "";

        //filtros
        List<Evento> eventosFiltradosPorFecha = servicioEvento.buscarPorFecha(fecha);
        List<Evento> eventosFiltradosPorCategoria = servicioEvento.buscarPorTipoDeEvento(categoria);
        List<Evento> eventosFiltradosPorLocalidad= servicioEvento.buscarPorCiudad(localidad);

        if(eventosFiltradosPorFecha!=null) eventosFiltrados.addAll(eventosFiltradosPorFecha);
        if(eventosFiltradosPorCategoria!=null) eventosFiltrados.addAll(eventosFiltradosPorCategoria);
        if(eventosFiltradosPorLocalidad!=null) eventosFiltrados.addAll(eventosFiltradosPorLocalidad);
        //filtro general
        if(eventosFiltradosPorFecha==null && eventosFiltradosPorCategoria==null && eventosFiltradosPorLocalidad==null){
            mensaje="No existen eventos con las condiciones solicitadas";
            model.put("mensaje", mensaje);
        }

        model.addAttribute("fecha", fecha);
        model.addAttribute("localidad", localidad);
        model.addAttribute("categoria", categoria);
        model.addAttribute("eventos", eventosFiltrados);
        String viewName="eventos-filtrados";

        return new ModelAndView(viewName, model);
    }

}
