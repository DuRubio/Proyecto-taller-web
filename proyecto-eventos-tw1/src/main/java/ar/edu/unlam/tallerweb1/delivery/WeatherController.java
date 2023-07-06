package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Evento;
import ar.edu.unlam.tallerweb1.domain.EventoService;
import ar.edu.unlam.tallerweb1.domain.WeatherData;
import ar.edu.unlam.tallerweb1.domain.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    @Autowired
    private EventoService eventoService;

    @RequestMapping(path = "weather", method = RequestMethod.GET)
    public ModelAndView detalleEvento(@RequestParam("cityId") String cityId, @RequestParam("eventoId") Long eventoId) {
        ModelMap model = new ModelMap();
        Evento evento = eventoService.buscarPorId(eventoId);
        WeatherData weatherData = weatherService.getWeatherDataByCityId(cityId);
        model.put("evento", evento);
        model.put("weatherData", weatherData);
        return new ModelAndView("info-evento", model);
    }

    @RequestMapping(path = "/weathers/{cityId}", method = RequestMethod.GET)
    @ResponseBody
    public WeatherData getWeatherData(@PathVariable String cityId) {
        return weatherService.getWeatherDataByCityId(cityId);
    }

//    @RequestMapping(path = "/weather", method = RequestMethod.GET)
//    public ModelAndView clima() {
//
//        return new ModelAndView("weather");
//
//    }
}

