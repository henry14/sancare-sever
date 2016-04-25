package za.co.sanlam.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * @author henry14
 *
 */
@Entity
@Table(name="hospitals")
public class Hospital extends BaseData {
	
	private static final long serialVersionUID = -1114140272902382180L;
//	private String code;
	private String name;
	private Town town;
	private User createdBy;
	private Date createdDate;
	private User lastModifiedBy;
	private Date lastModifiedDate;

	public Hospital(Town town2) {
		this.town = town2;
	}

	public Hospital() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the hospital
	 */
	@Column(name="name", nullable=false)
	public String getName() {
		return name;
	}

	/**
	 * @param hospital the hospital to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*@Column(name="code", nullable=false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}*/
   
	@Column(name="town_id", nullable=true)
	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	/**
	 * @return the createdBy
	 */
	@OneToOne
    @JoinColumn(name="created_user_id", nullable=false)
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	@Column(name="created_date", nullable=false)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastModifiedBy
	 */
	@OneToOne
    @JoinColumn(name="last_modified_user_id", nullable=true)
	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * @return the lastModifiedDate
	 */
	@Column(name="last_modified_date", nullable=true)
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}	
	
	@PrePersist
	public void created() {
		//setCreatedBy(createdBy);
		setCreatedDate(Calendar.getInstance().getTime());
	}
	
	@PostUpdate
	public void modifiedDate() {
		setLastModifiedDate(Calendar.getInstance().getTime());
	}
	

}
