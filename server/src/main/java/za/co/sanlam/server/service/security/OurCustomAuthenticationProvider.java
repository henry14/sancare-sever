package za.co.sanlam.server.service.security;

import za.co.sanlam.server.service.authentication.AuthenticationService;
import za.co.sanlam.security.SancareUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Extends the spring framework {@link AuthenticationProvider} interface so as
 * to provide a custom authentication mechanism
 * 
 * @author 
 * 
 */
public class OurCustomAuthenticationProvider implements AuthenticationProvider {

	private SancareUserDetailsService userDetailsService;

	@Autowired
	private AuthenticationService authenticationService;

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.authentication.AuthenticationProvider#
	 * authenticate(org.springframework.security.core.Authentication)
	 */
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		UserDetails userDetails = getUserDetailsService().loadUserByUsername(
				(String) authentication.getPrincipal());
		if (userDetails != null) {
			if (authenticationService.isValidUserPassword(
					((SancareUserDetails) userDetails).getSystemUser(),
					(String) authentication.getCredentials())) {
				return new UsernamePasswordAuthenticationToken(userDetails,
						authentication.getCredentials(),
						userDetails.getAuthorities());
			} else {
				throw new AuthenticationServiceException("passwords don't match");
			}
		} else {
			throw new AuthenticationCredentialsNotFoundException("");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.authentication.AuthenticationProvider#supports
	 * (java.lang.Class)
	 */
	@Override
	public boolean supports(Class<? extends Object> supportedClass) {
		if (supportedClass
				.getName()
				.equalsIgnoreCase(
						"org.springframework.security.authentication.UsernamePasswordAuthenticationToken")) {
			return true;
		}

		return false;
	}

	/**
	 * @return the userDetailsService
	 */
	public SancareUserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	/**
	 * @param userDetailsService
	 *            the userDetailsService to set
	 */
	@Autowired
	public void setUserDetailsService(SancareUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	/**
	 * @return the authenticationService
	 */
	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	/**
	 * @param authenticationService
	 *            the authenticationService to set
	 */
	public void setAuthenticationService(
			AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
}
