package za.co.sanlam.webapp.security.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class SancareAuthenticationFailureHandler implements AuthenticationFailureHandler{
	
	private String username;
	private String password;
	private static final Logger log = LoggerFactory.getLogger(SancareAuthenticationFailureHandler.class);
	
	public SancareAuthenticationFailureHandler() {
		log.debug("I am a hero");
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		username = request.getParameter("j_username");
		password = request.getParameter("j_password");
		log.debug("username is :"+username);
		log.debug("password is: "+password);
		
		
		
		
	}

}
