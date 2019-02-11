package pl.oskarpolak.weather.weather.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.oskarpolak.weather.auth.services.UserSession;
import pl.oskarpolak.weather.weather.services.WeatherLogService;

@Controller
public class WelcomeController {

    final private WeatherLogService weatherLogService;

    final private UserSession userSession;

    @Autowired
    public WelcomeController(WeatherLogService weatherLogService, UserSession userSession) {
        this.weatherLogService = weatherLogService;
        this.userSession = userSession;
    }

    @GetMapping("/")
    public String index(){
        if(!userSession.isLogin()){
            return "redirect:/login";
        }

        return "index";
    }

    @PostMapping("/")
    public String index(@RequestParam("cityName") String cityName,
                        Model model) {
        if(!userSession.isLogin()){
            return "redirect:/login";
        }
        model.addAttribute("weather", weatherLogService.getCurrentWeather(cityName));
        model.addAttribute("forecast", weatherLogService.getForecastWeather(cityName));
        return "index";
    }
}
