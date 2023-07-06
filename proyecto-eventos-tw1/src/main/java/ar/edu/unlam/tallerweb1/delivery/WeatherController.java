package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.WeatherData;
import ar.edu.unlam.tallerweb1.domain.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(path = "/weather/{cityId}", method = RequestMethod.GET)
    @ResponseBody
    public WeatherData getWeatherData(@PathVariable String cityId) {
        return weatherService.getWeatherDataByCityId(cityId);
    }

    @RequestMapping(path = "/weather", method = RequestMethod.GET)
    public ModelAndView clima() {

        return new ModelAndView("weather");

    }
}

