package pl.oskarpolak.weather.weather.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.oskarpolak.weather.auth.services.UserSession;

@Controller
public class HistoryController {

    final UserSession userSession;

    @Autowired
    public HistoryController(UserSession userSession) {
        this.userSession = userSession;
    }

    @GetMapping("/history")
    public  String history(Model model){
        //to nie zadziala :)
        model.addAttribute("logs", userSession.getUserEntity().getWeatherLog());
        return "history";
    }

}
