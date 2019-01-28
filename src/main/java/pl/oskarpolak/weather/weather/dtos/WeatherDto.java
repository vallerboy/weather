package pl.oskarpolak.weather.weather.dtos;

import lombok.Data;

@Data
public class WeatherDto {
    private TemperatureDto main;

    @Data
    public static class TemperatureDto {
        private double temp;
    }
}
