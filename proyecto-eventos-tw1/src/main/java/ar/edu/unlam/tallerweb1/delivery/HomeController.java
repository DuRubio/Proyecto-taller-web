package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Evento;
import ar.edu.unlam.tallerweb1.domain.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

//@Controller
public class HomeController { //NO USAR ESTA CLASE POR AHORA
    private HomeService servicioEvento;

    @Autowired
    public HomeController(HomeService servicioEvento) {
        this.servicioEvento = servicioEvento;
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public ModelAndView getVistaHome() {
        return new ModelAndView("home");
    }

    @RequestMapping(path = "/filtrar", method = RequestMethod.GET)
    public ModelAndView getVistaFiltrar() {
        return new ModelAndView("eventos-filtrados");
    }

    @RequestMapping(path ="/filtrar/fecha" , method = RequestMethod.GET)
    public ModelAndView filtrarEventosPorFecha(@RequestParam("date") Date fechaEvento) {
        List<Evento> eventosFiltradosPorFecha = servicioEvento.buscarPorFecha(fechaEvento);
        ModelMap model = new ModelMap();
        String viewName = "";

        if(eventosFiltradosPorFecha==null) {
            viewName = "home";
            model.put("mensaje","No existen eventos para la fecha seleccionada");
        } else {
            viewName = "eventos-filtrados";
        }
        return new ModelAndView(viewName, model);
    }

    @RequestMapping(path ="/filtrar" , method = RequestMethod.GET)
    public ModelAndView filtrarEventosPorCategoria(@RequestParam("tipo") TipoDeEvento tipo) {
        List<Evento> eventosFiltradosPorTipo = servicioEvento.buscarPorTipoDeEvento(tipo);
        ModelMap model = new ModelMap();
        String viewName = "";

        if(eventosFiltradosPorTipo==null) {
            viewName = "home";
            model.put("mensaje","No existen eventos que corresponden a " + tipo);
        } else {
            viewName = "eventos-filtrados";
        }
        return new ModelAndView(viewName, model);
    }

    @RequestMapping(path ="/filtrar/ciudad" , method = RequestMethod.GET)
    public ModelAndView filtrarEventosPorCiudad(@RequestParam("ciudad") String ciudad) {
        List<Evento> eventosFiltradosPorCiudad = servicioEvento.buscarPorCiudad(ciudad);
        ModelMap model = new ModelMap();
        String viewName = "";

        if(eventosFiltradosPorCiudad==null) {
            viewName = "home";
            model.put("mensaje","No existen eventos situados en " + ciudad);
        } else {
            viewName = "eventos-filtrados";
        }
        return new ModelAndView(viewName, model);
    }


}


