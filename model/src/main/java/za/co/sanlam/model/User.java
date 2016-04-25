package za.co.sanlam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author henry14
 * 
 */
@Entity
@Table(name = "users")
public class User extends BaseData{

	private static final long serialVersionUID = -2870705557307995811L;
	private String firstName;
	private String lastName;
//	private String gender;
	private String username;
	private String password;
	private Role role;
	private String salt;
	private String clearTextPassword;
	private String fullName;
	
	/*public User(String firstName, String lastName, String username, String password, Role role, String salt, String clearTextPassword){
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.role = role;
		this.salt = salt;
		this.clearTextPassword = clearTextPassword;
	}*/

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}*/

	@OneToOne
	@JoinColumn(name="role_id", nullable=false)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getClearTextPassword() {
		return clearTextPassword;
	}

	public void setClearTextPassword(String clearTextPassword) {
		this.clearTextPassword = clearTextPassword;
	}

	@Column(name = "salt", nullable = false)
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean hasAdministrativePrivileges() {
		if (role != null){
			if(role.checkIfDefaultAdminRole()) {
				return true;
			}
		}
		return false;
	}
	
	public List<Permission> findPermissions() {
		List<Permission> permissions = null;
		if (role !=null ){
			permissions = new ArrayList<Permission>();
			if (role.getPermissions() !=null && role.getPermissions().size() > 0){
				for (Permission permission : role.getPermissions()){
					permissions.add(permission);
				}
			}
		}
		return permissions;
	}

	@Transient
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String firstName, String lastName) {
		this.fullName = firstName +' '+lastName;
	}
	
	

}
