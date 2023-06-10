package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Evento;
import ar.edu.unlam.tallerweb1.domain.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
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

    @RequestMapping(path = "/registrar-evento", method = RequestMethod.POST)
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
    	ModelMap model = new ModelMap();
    	List<Evento> eventos = this.servicioEvento.getPrimeros3Eventos();
    	//List<Evento> eventos = servicioEvento.getEventos();
    	model.put("eventos", eventos);
    	ModelAndView mav = new ModelAndView("home");
        return mav;
    }


    @RequestMapping(path="mostrar-eventos", method = RequestMethod.GET)
    public ModelAndView mostrarEventos() {
    	ModelMap model = new ModelMap();
        List<Evento> eventos = servicioEvento.getEventos();
        model.put("eventos", eventos);
        ModelAndView mav = new ModelAndView("mostrar-eventos", model);

        return mav;
    }

    @RequestMapping(path = "/home/filtrar", method = RequestMethod.GET)
    public ModelAndView filtrarEventos(
            @RequestParam(value = "filtro-fecha", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha,
            @RequestParam(value = "filtro-categoria", required = false) TipoDeEvento categoria,
            @RequestParam(value = "localidad", required = false) String localidad){
        String viewName="";
        ModelMap model = new ModelMap();
        List<Evento> eventosFiltrados=new ArrayList<>();
        List<Evento> eventosFiltradosFecha = servicioEvento.buscarPorFecha(fecha);
        List<Evento> eventosFiltradosLocalidad = servicioEvento.buscarPorCiudad(localidad);
        List<Evento> eventosFiltradosCategoria = servicioEvento.buscarPorTipoDeEvento(categoria);

        //eventosFiltrados= servicioEvento.buscarPorTipoDeEvento(categoria);

        if(eventosFiltradosFecha!=null) eventosFiltrados.addAll(eventosFiltradosFecha);
        if(eventosFiltradosLocalidad!=null) eventosFiltrados.addAll(eventosFiltradosLocalidad);
        if(eventosFiltradosCategoria!=null) eventosFiltrados.addAll(eventosFiltradosCategoria);

        if(eventosFiltradosFecha.isEmpty() && eventosFiltradosLocalidad.isEmpty() && eventosFiltradosCategoria.isEmpty()){
            viewName= "home";
            model.put("mensaje","No se encontraron eventos");

        } else {
            model.addAttribute("eventos", eventosFiltrados);
            viewName="eventos-filtrados";
        }
        return new ModelAndView(viewName, model);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView inicio() {

        return new ModelAndView("redirect:/login");

    }

}
