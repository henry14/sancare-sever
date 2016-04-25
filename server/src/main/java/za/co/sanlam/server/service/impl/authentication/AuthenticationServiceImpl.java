package za.co.sanlam.server.service.impl.authentication;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import za.co.sanlam.model.User;
import za.co.sanlam.security.SancareUserDetails;
import za.co.sanlam.security.util.SancareSecurityUtil;
import za.co.sanlam.server.dao.UserDAO;
import za.co.sanlam.server.service.authentication.AuthenticationService;
import za.co.sanlam.server.service.security.SancareUserDetailsService;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private SancareUserDetailsService userDetailsService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public User authenticate(String username, String password,
			boolean attachUserToSecurityContext) {
		User user = null;
		if(StringUtils.isNotBlank(username) 
				&& StringUtils.isNotBlank(password)) {
			user = userDAO.searchUniqueByPropertyEqual("username", username);
			user.getRole();
			if(user != null && isValidUserPassword(user, password)){
				if(attachUserToSecurityContext){
					SancareUserDetails userDetails = (SancareUserDetails)userDetailsService.getUserDetailsForUser(user);
					if(userDetails !=null){
						SancareSecurityUtil.setSecurityContext(userDetails);
					}
				}
				else {
					return user;
				}
			}
			else {
				log.error("Access denied for "+user.getUsername());
				throw new AccessDeniedException("password and username mismatch");
			}
			return user;
		}
			
		
		return null;
	}

	@Override
	public Boolean isValidUserPassword(User user, String loginPassword) {
		if (user == null || StringUtils.isBlank(loginPassword)
				|| StringUtils.isBlank(user.getSalt())) {
			// we don't accept empy passwords
			return false;
		}

		String hashedPassword = SancareSecurityUtil.encodeString(loginPassword
				+ user.getSalt());
		if (hashedPassword.equals(user.getPassword())) {
			return true;
		} else {
			// try legacy method for backward compatibilty
			hashedPassword = SancareSecurityUtil.encodeString2(loginPassword
					+ user.getSalt());
			if (hashedPassword.equals(user.getPassword())) {
				return true;
			}
		}

		return false;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public SancareUserDetailsService getRmsUserDetailsService() {
		return userDetailsService;
	}
	
	public void setRmsUserDetailsService(SancareUserDetailsService rmsUserDetailsService) {
		this.userDetailsService = rmsUserDetailsService;
	}

}
