package za.co.sanlam.webapp.security.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import za.co.sanlam.security.SancareUserDetails;

public class SancareAuthenticationSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {

	private String administratorTargetUrl;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {

		if (authentication.getPrincipal() instanceof SancareUserDetails) {
			if (((SancareUserDetails) authentication.getPrincipal())
					.getSystemUser().hasAdministrativePrivileges()) {
				if (StringUtils.isNotBlank(getAdministratorTargetUrl())
						&& StringUtils.isNotEmpty(getAdministratorTargetUrl())) 
					super.setDefaultTargetUrl(getAdministratorTargetUrl());
				super.setAlwaysUseDefaultTargetUrl(true);
			} else {
				super.setAlwaysUseDefaultTargetUrl(false);
				super.setDefaultTargetUrl("/");
			}
		}
		super.onAuthenticationSuccess(request, response, authentication);
		
//		response.sendRedirect(request.getContextPath());
		
	}

	/**
	 * gets the administrator url that this SuccessHandler will redirect to if
	 * the logged in user is an administrator
	 * 
	 * @return the administratorTargetUrl
	 */
	public String getAdministratorTargetUrl() {
		return administratorTargetUrl;
	}

	/**
	 * sets the administrator url that this SuccessHandler will redirect to if
	 * the logged in user is an administrator
	 * 
	 * @param administratorTargetUrl
	 *            the administratorTargetUrl to set
	 */
	public void setAdministratorTargetUrl(String administratorTargetUrl) {
		this.administratorTargetUrl = administratorTargetUrl;
	}

}
