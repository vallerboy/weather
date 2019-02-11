package pl.oskarpolak.weather.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.oskarpolak.weather.auth.entities.UserEntity;
import pl.oskarpolak.weather.auth.forms.RegisterForm;
import pl.oskarpolak.weather.auth.repositories.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(RegisterForm registerForm){
        if(!isLoginFree(registerForm.getLogin())){
            return false;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(registerForm.getEmail());
        userEntity.setLogin(registerForm.getLogin());
        userEntity.setPassword(getBCrypt().encode(registerForm.getPassword()));

        userRepository.save(userEntity);
        return true;
    }

    private boolean isLoginFree(String login) {
        return !userRepository.existsByLogin(login);
    }

    @Bean
    public BCryptPasswordEncoder getBCrypt(){
        return new BCryptPasswordEncoder();
    }
}
