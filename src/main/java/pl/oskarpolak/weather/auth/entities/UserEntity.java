package pl.oskarpolak.weather.auth.entities;

import lombok.Data;
import pl.oskarpolak.weather.weather.entites.WeatherLogEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
    private @Id @GeneratedValue int id;
    private String login;
    private String password;
    private String email;
    //o czas rejestracji
    //status konta

    @OneToMany(mappedBy = "user")
    private List<WeatherLogEntity> weatherLog;
}
