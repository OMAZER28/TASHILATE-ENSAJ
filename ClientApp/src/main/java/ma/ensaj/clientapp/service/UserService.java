package ma.ensaj.clientapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import ma.ensaj.clientapp.model.User;
import ma.ensaj.clientapp.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
