package za.co.sanlam.server.service.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import za.co.sanlam.model.User;
import za.co.sanlam.security.SancareUserDetails;

public interface SancareUserDetailsService extends UserDetailsService{
	
	SancareUserDetails getUserDetailsForUser(User user);

}
