package pl.oskarpolak.weather.auth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.weather.auth.entities.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    boolean existsByLogin(String login);
    Optional<UserEntity> findByLogin(String login);
}
