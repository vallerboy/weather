package pl.oskarpolak.weather.weather.mappers;

import pl.oskarpolak.weather.weather.dtos.WeatherDto;
import pl.oskarpolak.weather.weather.entites.WeatherLogEntity;

import java.time.LocalDateTime;

public class WeatherDtoToWeatherEntityMapper {
    public static WeatherLogEntity convert(WeatherDto weatherDto){
        WeatherLogEntity weatherLogEntity = new WeatherLogEntity();
        weatherLogEntity.setCityName(weatherDto.getCityName());
        weatherLogEntity.setQueryTime(LocalDateTime.now()); // czas aktualny
        weatherLogEntity.setCityTemp(weatherDto.getMain().getTemp());

        return weatherLogEntity;
    }
}
