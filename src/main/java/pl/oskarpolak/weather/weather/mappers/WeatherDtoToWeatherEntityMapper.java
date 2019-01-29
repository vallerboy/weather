package pl.oskarpolak.weather.weather.mappers;

import pl.oskarpolak.weather.weather.dtos.WeatherDto;
import pl.oskarpolak.weather.weather.entites.WeatherLogEntity;

public class WeatherDtoToWeatherEntityMapper {
    public WeatherLogEntity convert(WeatherDto weatherDto){
        WeatherLogEntity weatherLogEntity = new WeatherLogEntity();
        weatherLogEntity.setCityName(weatherDto.);
    }
}
