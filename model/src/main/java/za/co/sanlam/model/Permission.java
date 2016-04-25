package za.co.sanlam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

@Entity
@Table(name = "permissions")
public class Permission extends BaseData implements Comparable<Permission> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	
	public Permission(){
		super();
	}
	
	public Permission(String id){
		this.setId(id);
	}
	
	public Permission(String name, String description){
		this.setName(name);
		this.setDescription(description);
	}
	
	public Permission(String id, String name, String description){
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
	}
	
    @Column(name = "permission_name", nullable=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    @Column(name = "description", nullable=true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int compareTo(Permission o) {
		
		return getObjectFromPermissionName(this)
				.compareToIgnoreCase(getObjectFromPermissionName(o));
	}
	
	public static String getObjectFromPermissionName(Permission p) {
		String substring = "";
		if (p.getName().indexOf('_') != -1)
			substring = p.getName().substring(p.getName().indexOf('_') + 1);
		
		else
			return p.getName();
		
		if (substring.indexOf('_') != -1)
			return substring.substring(substring.indexOf('_') +1 );
		else
			return substring;
	}
	
	@Override
	public String toString() {
		String str = "";
		if (StringUtils.isNotBlank(getId()))
			str += getId();
		
		if(StringUtils.isNotBlank(getName()))
			str += " "+ getName();
		
		if(StringUtils.isNotBlank(getDescription()))
			str += " " + getDescription();
		
		return str;
	}

}
