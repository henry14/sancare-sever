package za.co.sanlam.server.service.impl.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import za.co.sanlam.model.Permission;
import za.co.sanlam.model.User;
import za.co.sanlam.security.SancareUserDetails;
import za.co.sanlam.server.dao.PermissionDAO;
import za.co.sanlam.server.dao.UserDAO;
import za.co.sanlam.server.service.security.SancareUserDetailsService;

public class SancareUserDetailsServiceImpl implements SancareUserDetailsService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PermissionDAO permissionDAO;
	
	private Logger log = LoggerFactory.getLogger(SancareUserDetailsServiceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		try {
			User user = userDAO.searchUniqueByPropertyEqual("username", username);
			
			if (user != null){
				return getUserDetailsForUser(user);
			} 
			} catch (Exception ex){
				log.error("Error", ex);
				throw new UsernameNotFoundException(ex.getMessage(), ex);
		}
		return null;
	}

	@Override
	public SancareUserDetails getUserDetailsForUser(User user) {
		SancareUserDetails userDetails = null;
		if(user != null){
			List<GrantedAuthority> authorities = getUserAuthorities(user);
			if(authorities == null){
				
				authorities = new ArrayList<GrantedAuthority>();
				
			}
			userDetails = new SancareUserDetails(user, true, true, true, true, authorities);
			
		}
		
		return userDetails;
	}

	protected List<GrantedAuthority> getUserAuthorities(User user) {
		List<GrantedAuthority> authorities = null;
		if(user != null){
			authorities = new ArrayList<GrantedAuthority>();
			List<Permission> permissions = null;
			
			if (user.hasAdministrativePrivileges()){
				permissions = permissionDAO.findAll();
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
				authorities.add(grantedAuthority);
			}
			else {
				permissions = user.findPermissions();
				
				if (permissions != null && permissions.size() > 0){
					for (Permission permission : permissions){
						GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());// GrantedAuthorityImpl(permission.getName());
						authorities.add(grantedAuthority);
					}
				}
			}
			
		}
		return authorities;
	}

}
