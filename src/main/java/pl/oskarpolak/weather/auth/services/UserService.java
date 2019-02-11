package pl.oskarpolak.weather.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.oskarpolak.weather.auth.entities.UserEntity;
import pl.oskarpolak.weather.auth.forms.LoginForm;
import pl.oskarpolak.weather.auth.forms.RegisterForm;
import pl.oskarpolak.weather.auth.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;

    final UserSession userSession;

    @Autowired
    public UserService(UserRepository userRepository, UserSession userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
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

    public boolean login(LoginForm loginForm) {
        Optional<UserEntity> userOptional = userRepository.findByLogin(loginForm.getLogin());
        if(!userOptional.isPresent()){
            return false;
        }

        if(!getBCrypt().matches(loginForm.getPassword(), userOptional.get().getPassword())){
            return false;
        }

        userSession.setLogin(true);
        userSession.setUserEntity(userOptional.get());
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
