package za.co.sanlam.model;

//import java.util.Date;

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
@Table(name = "health_tips")
public class Tip extends BaseData {

	private static final long serialVersionUID = 6813505710668531712L;
	private String message;
	private User createdBy;
	private Date createdDate;
	private User lastModifiedBy;
	private Date lastModifiedDate;
	
//	private Date date;
//	private AppClient client;

	/**
	 * @return the message
	 */
	@Column(name = "message", nullable = false)
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the message
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
	 * @return the message
	 */
    @Column(name="created_date", nullable=false)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the message
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
	 * @return the message
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

	/**
	 * @return the date
	 *//*
	@Column(name = "date", nullable = false)
	public Date getDate() {
		return date;
	}

	*//**
	 * @param date
	 *            the date to set
	 *//*
	public void setDate(Date date) {
		this.date = date;
	}*/

	/**
	 * @return the client
	 *//*
	@ManyToOne
	@JoinColumn(name="app_client_id", nullable=false)
	public AppClient getClient() {
		return client;
	}

	*//**
	 * @param client the client to set
	 *//*
	public void setClient(AppClient client) {
		this.client = client;
	}*/
	
	

}
