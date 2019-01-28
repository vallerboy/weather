package pl.oskarpolak.weather.weather.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.weather.weather.entites.WeatherLogEntity;
import pl.oskarpolak.weather.weather.repositories.WeatherLogRepository;

@Service
public class WeatherLogService {

    final WeatherLogRepository weatherLogRepository;

    @Autowired
    public WeatherLogService(WeatherLogRepository weatherLogRepository) {
        this.weatherLogRepository = weatherLogRepository;
    }

    //będę ją wywoływal Controllera
//    public boolean saveWeatherLog(WeatherForm weatherForm){
//        return weatherLogRepository.save(new WeatherLogEntity(weatherForm)) != null;
//    }
}
