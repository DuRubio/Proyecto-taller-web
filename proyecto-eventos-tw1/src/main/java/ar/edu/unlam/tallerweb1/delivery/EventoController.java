package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Evento;
import ar.edu.unlam.tallerweb1.domain.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public ModelAndView registrarEvento(@ModelAttribute DatosEvento datosEvento) {
        ModelMap model = new ModelMap();
        String viewName = "";

          if(this.servicioEvento.validarNombre(datosEvento.getNombre()) && this.servicioEvento.validarLocalidad(datosEvento.getLocalidad())){
                model.put("mensaje","Evento registrado");
                model.put("datosEvento", datosEvento);
                servicioEvento.save(datosEvento);
                viewName = "home";
          } else {
                model.put("mensaje", "Registro fallido");
                viewName = "registro-evento";
          }
            return new ModelAndView(viewName, model);
        }





    @RequestMapping(path = "/comprar-entrada", method = RequestMethod.GET)
    public ModelAndView getVistaComprar() {
        return new ModelAndView("comprar-entrada");
    }


    @RequestMapping(path="mostrar-eventos", method = RequestMethod.GET)
    public ModelAndView mostrarEventos() {
    	ModelMap model = new ModelMap();
        List<Evento> eventos = servicioEvento.getEventos();
        model.put("eventos", eventos);
        ModelAndView mav = new ModelAndView("mostrar-eventos", model);

        return mav;
    }

    @RequestMapping(path = "/filtrar", method = RequestMethod.POST)
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
           // model.put("mensaje","No se encontraron eventos");
            model.addAttribute("mostrarPopup", true);
            viewName= "home";

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
