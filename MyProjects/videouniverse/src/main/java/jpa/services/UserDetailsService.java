package jpa.services;

import jpa.models.User;

import java.util.Optional;

public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {

    User save(UserRegistrationDto userDto);


}
