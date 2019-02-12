package pl.oskarpolak.weather.weather.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.weather.auth.entities.UserEntity;
import pl.oskarpolak.weather.weather.entites.WeatherLogEntity;

import java.util.List;

@Repository
public interface WeatherLogRepository extends CrudRepository<WeatherLogEntity, Integer> {
    List<WeatherLogEntity> findAllByUser(UserEntity userEntity);
}
