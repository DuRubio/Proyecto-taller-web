package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Evento;
import ar.edu.unlam.tallerweb1.domain.EventoService;
import ar.edu.unlam.tallerweb1.domain.Usuario;
import ar.edu.unlam.tallerweb1.domain.UsuarioService;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class EventoController {
	
	private Long id;

    private EventoService servicioEvento;
    private UsuarioService servicioUsuario;
    
    @Autowired
    public EventoController(EventoService servicioRegEvento, UsuarioService servicioUsuario) {
        this.servicioEvento=servicioRegEvento;
        this.servicioUsuario = servicioUsuario;
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

    @RequestMapping(path="filtrar", method = RequestMethod.POST)
    public ModelAndView filtrarEventos(
            @RequestParam(value = "fecha", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha,
            @RequestParam(value = "categoria", required = false) Integer categoria,
            @RequestParam(value = "localidad", required = false) String localidad) {
        String viewName = "";
        ModelMap model = new ModelMap();
        
        Set<Evento> eventosFiltrados = new HashSet<>();

        if (fecha != null) {
            eventosFiltrados.addAll(servicioEvento.buscarPorFecha(fecha));
        }

        if (categoria != null) {
            eventosFiltrados.addAll(servicioEvento.buscarPorTipoDeEvento(categoria));
        }

        if (localidad != null) {
            eventosFiltrados.addAll(servicioEvento.buscarPorCiudad(localidad));
        }

        if (eventosFiltrados.isEmpty()) {
            model.addAttribute("mostrarPopup", true);
            viewName = "home";
        } else {
            model.addAttribute("eventos", new ArrayList<>(eventosFiltrados));
            viewName = "eventos-filtrados";
        }

        return new ModelAndView(viewName, model);
    }
    
    @RequestMapping(path = "filtrar-preferencias", method = RequestMethod.GET)
    public ModelAndView filtrarEventosMisPreferencias(@RequestParam(value = "idUsuario", required = true) Long id) {
        String viewName = "";
        ModelMap model = new ModelMap();

        Set<Evento> eventosFiltrados = new HashSet<>();
        // Hacer filtrar preferencias
        Usuario usuario = servicioUsuario.obtenerUsuarioPorID(id);
        eventosFiltrados.addAll(servicioEvento.buscarEventosPorPreferencias(usuario));

        if (eventosFiltrados.isEmpty()) {
            model.addAttribute("mostrarPopup", true);
            viewName = "home";
        } else {
            model.addAttribute("eventos", new ArrayList<>(eventosFiltrados));
            viewName = "eventos-filtrados";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView inicio() {

        return new ModelAndView("redirect:/login");

    }

}
