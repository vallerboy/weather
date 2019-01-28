package pl.oskarpolak.weather.weather.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ForecastWeatherDto {
    @JsonProperty("list")
    private List<WeatherDto> listOfWeather;
}
