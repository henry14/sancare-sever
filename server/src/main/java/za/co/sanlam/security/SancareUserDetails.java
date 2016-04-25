package za.co.sanlam.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import za.co.sanlam.model.User;

public class SancareUserDetails extends org.springframework.security.core.userdetails.User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User systemUser;

	public SancareUserDetails(User user, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(user.getUsername(), user.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				authorities);
		
		systemUser = user;
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * gets the System user
	 * 
	 * @return
	 */
	public User getSystemUser() {
		return systemUser;
	}

	/**
	 * gets the salt of the user
	 * 
	 * @return
	 */
	public String getSalt() {
		return systemUser.getSalt();
	}
	

}
