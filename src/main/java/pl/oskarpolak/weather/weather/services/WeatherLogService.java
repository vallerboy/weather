package pl.oskarpolak.weather.weather.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.oskarpolak.weather.weather.dtos.ForecastWeatherDto;
import pl.oskarpolak.weather.weather.dtos.WeatherDto;
import pl.oskarpolak.weather.weather.repositories.WeatherLogRepository;

@Service
public class WeatherLogService {


    @Value("${api.openweathermap.key}")
    String apiKey;


    final WeatherLogRepository weatherLogRepository;

    @Autowired
    public WeatherLogService(WeatherLogRepository weatherLogRepository) {
        this.weatherLogRepository = weatherLogRepository;
    }


    // {
    // "klucz":"wartosc",
    // "klucz2": {
    //              "klucz1": "wartosc1"
    //           }
    // }";



    public boolean saveWeatherLog(WeatherDto weatherDto){

    }

    public WeatherDto getCurrentWeather(String cityName) {
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&units=metric&appid=" + apiKey, WeatherDto.class);
    }

    public ForecastWeatherDto getForecastWeather(String cityName) {
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&units=metric&appid=" + apiKey, ForecastWeatherDto.class);
    }


    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
