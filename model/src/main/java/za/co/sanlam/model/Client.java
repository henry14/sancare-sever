/**
 * @author henry
 *
 */
//All organizations that insure with Sanlam
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


@Entity
@Table(name = "clients")
public class Client  extends BaseData {

	private static final long serialVersionUID = 1838957812758221489L;
	
	private String name;
	private Integer premium;
	private User createdBy;
	private Date createdDate;
	private User lastModifiedBy;
	private Date lastModifiedDate;
	
	/**
	 * @return the name
	 */
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the premium
	 */
	@Column(name = "premium", nullable = false)
	public Integer getPremium() {
		return premium;
	}
	
	public void setPremium(Integer premium) {
		this.premium = premium;
	}

	/**
	 * @param createdBy
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
	 * @param createdDate
	 */
	@Column(name="created_date", nullable=false)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @param lastModifiedBy
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
	 * @param lastModifiedDate
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
