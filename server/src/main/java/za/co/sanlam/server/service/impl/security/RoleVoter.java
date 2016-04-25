package za.co.sanlam.server.service.impl.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class RoleVoter extends Object implements AccessDecisionVoter<Object>{
	
	private String rolePrefix = "";

	@Override
	public boolean supports(ConfigAttribute attribute) {
		if((attribute.getAttribute() != null) && attribute.getAttribute().startsWith(getRolePrexix())){
			return true;
		}
		else {
			return false;
		}
	}

	private String getRolePrexix() {
		return rolePrefix;
	}


	private Collection<? extends GrantedAuthority> extractAuthorities(
			Authentication authentication) {
		return authentication.getAuthorities();
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int vote(Authentication authentication, Object arg1, Collection<ConfigAttribute> attributes) {
		if(authentication == null) {
			return ACCESS_DENIED;
		}
		int result = ACCESS_ABSTAIN;
		Collection<? extends GrantedAuthority> authorities = extractAuthorities(authentication);
		
		for(ConfigAttribute attribute : attributes) {
			if (this.supports(attribute)) {
				result =ACCESS_DENIED;
				
				//Attempt to find matching Granted Authority
				for (GrantedAuthority authority : authorities) {
					if (attribute.getAttribute().equals(authority)){
						return ACCESS_GRANTED;
					}
				}
			}
		}

		
		return result;
	}

}
