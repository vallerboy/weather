package pl.oskarpolak.weather.weather.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.oskarpolak.weather.auth.services.UserSession;
import pl.oskarpolak.weather.weather.services.WeatherLogService;

@Controller
public class HistoryController {

    final WeatherLogService weatherLogService;

    @Autowired
    public HistoryController(WeatherLogService weatherLogService) {
        this.weatherLogService = weatherLogService;
    }

    @GetMapping("/history")
    public  String history(Model model){
        //to nie zadziala :)
        model.addAttribute("logs", weatherLogService.getWeatherLogForLoginUser());
        return "history";
    }

}
