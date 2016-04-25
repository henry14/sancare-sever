package za.co.sanlam.server.service.authentication;

import za.co.sanlam.model.User;

/**
 * @author 
 * 
 */
public interface AuthenticationService {

	/**
	 * Authenticates a given <code>User</code>.
	 * 
	 * @param username
	 *            <code>User's</code> user name.
	 * @param password
	 *            <code>User's </code> password.
	 * @param attachUserToSecurityContext
	 *            value indicating whether the attached user should be added to
	 *            the security context
	 * 
	 * @return <code>User</code> only and only if <code>User</code> is
	 *         successfully authenticated.
	 */
	User authenticate(String username, String password,
			boolean attachUserToSecurityContext);

	/**
	 * Validates a user's password without authenticating them in the security
	 * context.
	 * 
	 * @param User
	 * @param loginPassword
	 * @return true if password matches user's password
	 */
	Boolean isValidUserPassword(User user, String loginPassword);
}
