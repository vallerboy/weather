package pl.oskarpolak.weather.weather.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.weather.weather.entites.WeatherLogEntity;

@Repository
public interface WeatherLogRepository extends CrudRepository<WeatherLogEntity, Integer> {
}
