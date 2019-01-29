package pl.oskarpolak.weather.weather.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherDto {
    private TemperatureDto main;
    private CloudsDto clouds;

    @JsonProperty("name")
    private String cityName;

    @JsonProperty("dt_txt")
    private String date;

    @Data
    public static class TemperatureDto {
        private double temp;
        private double pressure;
    }

    @Data
    public static class CloudsDto {
        @JsonProperty(value = "all")
        private int clouds;
    }
}
