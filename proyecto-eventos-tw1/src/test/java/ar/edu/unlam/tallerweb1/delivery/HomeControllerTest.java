package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Evento;
import ar.edu.unlam.tallerweb1.domain.HomeService;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.mock;

public class HomeControllerTest { //NO USAR ESTA CLASE POR AHORA

    private HomeController homeController;
    private HomeService servicioHome;

    @Before
    public void inicializacion() {
        this.servicioHome = mock(HomeService.class);
        this.homeController = new HomeController(servicioHome);
    }

   @Test
    public void filtrarEventoPorFecha(){
       Date fechaEvento = new Date(2023, 6, 11);
       Integer cantidad = 2;
        dadoQueExistenEventos();
       List<Evento> eventosDeTalFecha = cuandoLosBuscoPorFecha(fechaEvento);
       entoncesEncuentroLaCantidad(cantidad);
    }

    private void entoncesEncuentroLaCantidad(Integer cantidad) {
    }

    private List<Evento> cuandoLosBuscoPorFecha(Date fechaEvento) {
     homeController.filtrarEventosPorFecha(fechaEvento);
        return null;
    }

    private void dadoQueExistenEventos() {
        Date fecha1 = new Date(2023, 6, 11);
        Date fecha2 = new Date(2023, 2, 11);
        Date fecha3 = new Date(2023, 4, 11);
        DatosEvento evento1 = new DatosEvento("final mundial sub20", fecha1 , "monumental" , "nuñez", TipoDeEvento.DEPORTIVO);
        DatosEvento evento2 = new DatosEvento("arjona", fecha1 , "gran rex" , "capital", TipoDeEvento.RECITAL);
        DatosEvento evento3 = new DatosEvento("simuladores", fecha1 , "plaza oeste" , "moron", TipoDeEvento.CINE);
        DatosEvento evento4 = new DatosEvento("2 + 2", fecha2 , "unicenter" , "haedo", TipoDeEvento.CINE);
        DatosEvento evento5 = new DatosEvento("Duki", fecha2 , "plaza roche" , "moron", TipoDeEvento.RECITAL);
        DatosEvento evento6 = new DatosEvento("Mellera", fecha3 , "teatro" , "moron", TipoDeEvento.TEATRO);


    }

    @Test
    public void filtrarEventosPorCategoria(){

    }

    @Test
    public void filtrarEventosPorCiudad(){

    }

    @Test
    public void queSePuedaComprarEntradas(){

    }
}
