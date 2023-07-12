package ar.edu.unlam.tallerweb1.delivery;


import ar.edu.unlam.tallerweb1.domain.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/*
public class EventoControllerTest {
    EventoController controladorEvento;
    DatosEvento eventoEjemplo;
    Evento eventoEjemplo1;
    Evento eventoEjemplo2;
    DatosEvento eventoEjemploErroneo1;
    DatosEvento eventoEjemploErroneo2;
    EventoService servicioRegEvento;
    UsuarioService servicioUsuario;

    WeatherService weatherService;

    LocalDate fechaEvento = LocalDate.of(2023, 5, 7);

    @Before
    public void inicializacion() {
        //eventoEjemplo = new DatosEvento("superclasico", "Deportivo", "monumental", 25, "2023-05-05");

       /* eventoEjemplo1=new Evento();
        eventoEjemplo1.setTipo(TipoDeEvento.MUSICAL.getValor());
        eventoEjemplo2=new Evento();
        eventoEjemplo2.setTipo(TipoDeEvento.MUSICAL);

        eventoEjemploErroneo1 = new DatosEvento("", fechaEvento , "monumental" , "nuñez", 50);
        eventoEjemploErroneo2 = new DatosEvento("superclasico", fechaEvento , "monumental" , "", 50);

        this.servicioRegEvento = mock(EventoServiceImpl.class);
        this.servicioUsuario = mock(UsuarioServiceImpl.class);
        this.weatherService = mock(WeatherService.class);
        this.controladorEvento = new EventoController(servicioRegEvento, servicioUsuario, weatherService);
    }

    @Test
    public void queAlTocarRegistrarEventoAparezcaLaPantallaRegistro() {
        ModelAndView mav = cuandoQuiereRegistrarEvento();
        aparezcaVistaRegistro(mav);
    }

    @Test
    public void queSePuedaRegistrarUnEvento() {
        // eventoEjemplo = dadoQueExisteUnEvento();
        ModelAndView mav = cuandoSeRegistra(eventoEjemplo, true);
        entoncesElRegistroEsExitoso(mav);
    }

    @Test
    public void queNoSePuedaRegistrarUnEventoConNombreNulo() {
        ModelAndView mav = cuandoSeRegistra(eventoEjemploErroneo1, false);
        entoncesElRegistroFalla(mav);
    }

    @Test
    public void queNoSePuedaRegistrarUnEventoConLocalidadNula() {
        ModelAndView mav = cuandoSeRegistra(eventoEjemploErroneo2, false);
        entoncesElRegistroFalla(mav);
    }

    //Test para verificar filtrado
    @Test
    public void queSePuedaFiltrarPorCategoria() {
        Integer tipoEvento = TipoDeEvento.MUSICAL.getValor();
        String localidad = null;
        LocalDate fecha = null;
        dadoQueNoExistenEventos(tipoEvento);
        ModelAndView mav = cuandoLosFiltro(fecha, localidad, tipoEvento);
        entoncesObtengoFiltrados(mav);
    }

    @Test
    public void queAlFiltrarNoEncuentreNadaDevuelvaPopup() {
        Integer tipoEvento = null;
        String localidad = null;
        LocalDate fecha = null;
        dadoQueFiltroPorValoresNulos();
        ModelAndView mav = cuandoLosFiltro(fecha, localidad, tipoEvento);
        entoncesObtengoMavYMensaje(mav);
    }


    @Test
    public void crearEventoConFechaString() {
        DatosEvento eventoEjemplo1 = new DatosEvento("superclasico", "Deportivo", "monumental", 25, "2020-05-23");
        LocalDate fechaEsperada = LocalDate.of(2020, 5, 23);
        Assert.assertEquals(fechaEsperada, eventoEjemplo1.getFecha());
    }






    private void entoncesObtengoMavYMensaje(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("mostrarPopup"));

    }

    private ModelAndView cuandoLosFiltro(LocalDate fecha, String localidad, Integer tipoEvento) {
        return controladorEvento.filtrarEventos(fecha, tipoEvento, localidad);
    }

    private void dadoQueFiltroPorValoresNulos() {
        List<Evento> listaVacia = new ArrayList<>();
        when(servicioRegEvento.buscarPorTipoDeEvento(null)).thenReturn(listaVacia);
        when(servicioRegEvento.buscarPorCiudad(null)).thenReturn(listaVacia);
        when(servicioRegEvento.buscarPorFecha(null)).thenReturn(listaVacia);
    }


    private void entoncesObtengoFiltrados(ModelAndView mav) {
        List<Evento> eventosFiltrados = new ArrayList<>();
        eventosFiltrados = (List<Evento>) mav.getModel().get("eventos");
        assertThat(eventosFiltrados).isNotNull();
        assertThat(eventosFiltrados).hasSize(2);
        assertThat(mav.getViewName().equals("eventos-filtrados"));
    }

    private void dadoQueNoExistenEventos(Integer tipoEvento) {
        List<Evento> eventosInventados = new ArrayList<>();
        eventosInventados.add(eventoEjemplo1);
        eventosInventados.add(eventoEjemplo2);
        when(servicioRegEvento.buscarPorTipoDeEvento(tipoEvento)).thenReturn(eventosInventados);

    }

    // metodos de los test anteriores a los filtros
    private void entoncesElRegistroFalla(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registro-evento");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Registro fallido");
    }

    private void entoncesElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Evento registrado");

    }

    private ModelAndView cuandoSeRegistra(DatosEvento eventoEjemplo, boolean esperado) {
        when(servicioRegEvento.validarNombre(eventoEjemplo.getNombre())).thenReturn(esperado);
        when(servicioRegEvento.validarLocalidad(eventoEjemplo.getLocalidad())).thenReturn(esperado);
        return controladorEvento.registrarEvento(eventoEjemplo);
    }

    private DatosEvento dadoQueExisteUnEvento() {
        return eventoEjemplo;
    }


    private void aparezcaVistaRegistro(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registro-evento");

    }

    private ModelAndView cuandoQuiereRegistrarEvento() {
        return controladorEvento.getVistaRegistro();
    }

}*/
