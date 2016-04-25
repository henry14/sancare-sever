package za.co.sanlam.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author henry14
 * 
 */
@Entity
@Table(name = "roles")
public class Role extends BaseData implements Comparable<Role> {

	private static final long serialVersionUID = -8747583626679629232L;
	
	public static final String DEFAULT_ADMIN_ROLE = "ROLE_ADMIN";
	
	private String name;
	private String description;
	private List<Permission> permissions;
	
	public Role(){
		
	}
	
	public Role(String id){
		this.setId(id);
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "role_permissions", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
	public List<Permission> getPermissions() {
		return permissions;
	}*/
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "role_id", nullable = false)
	public List<Permission> getPermissions() {
		return permissions;
	}
	
	public boolean checkIfDefaultAdminRole() {
		return this.getName().equals(Role.DEFAULT_ADMIN_ROLE);
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public int compareTo(Role o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
