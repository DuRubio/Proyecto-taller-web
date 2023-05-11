package ar.edu.unlam.tallerweb1.delivery;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import static org.assertj.core.api.Assertions.*;

public class EventoControllerTest {
    EventoController controladorEvento;
    DatosEvento eventoEjemplo;
    DatosEvento eventoEjemploErroneo1;
    DatosEvento eventoEjemploErroneo2;

    Date fechaEvento = new Date(2023, 5, 7);

    @Before
    public void inicializacion(){
        this.controladorEvento = new EventoController();
        eventoEjemplo = new DatosEvento("superclasico", fechaEvento , "monumental" , "nuñez", TipoDeEvento.DEPORTIVO);
        eventoEjemploErroneo1 = new DatosEvento("", fechaEvento , "monumental" , "nuñez", TipoDeEvento.DEPORTIVO);
        eventoEjemploErroneo2 = new DatosEvento("superclasico", fechaEvento , "monumental" , "", TipoDeEvento.DEPORTIVO);

    }

    @Test
    public void queAlTocarRegistrarEventoAparezcaLaPantallaRegistro(){
        ModelAndView mav = cuandoQuiereRegistrarEvento();
        aparezcaVistaRegistro(mav);
    }

    @Test
    public void queSePuedaRegistrarUnEvento(){
       // eventoEjemplo = dadoQueExisteUnEvento();
        ModelAndView mav = cuandoSeRegistra(eventoEjemplo);
        entoncesElRegistroEsExitoso(mav);
    }

    @Test
    public void queNoSePuedaRegistrarUnEventoConNombreNulo(){
        ModelAndView mav = cuandoSeRegistra(eventoEjemploErroneo1);
        entoncesElRegistroFalla(mav);
    }

    @Test
    public void queNoSePuedaRegistrarUnEventoConLocalidadNula(){
        ModelAndView mav = cuandoSeRegistra(eventoEjemploErroneo2);
        entoncesElRegistroFalla(mav);
    }





    private void entoncesElRegistroFalla(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registro-evento");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Registro fallido");
    }

    private void entoncesElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Evento registrado");

    }

    private ModelAndView cuandoSeRegistra(DatosEvento eventoEjemplo) {
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
}
