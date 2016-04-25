package za.co.sanlam.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * @author henry14
 *
 */

//All clients --- Users(Need to group clients based on the organization) --- Add organization object and link it to this class
/*
 * 
 * Mobile is set to False is not a mobile user.
 * 
 * */



@Entity
@Table(name = "beneficiaries")
public class Beneficiary extends BaseData {
	
	private static final long serialVersionUID = -8834268385783687099L;
	private Client client;
	private String memberNumber;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String username;
	private String password;
	private Boolean principal;
	private Boolean mobile;
	private User createdBy;
	private Date createdDate;
	private User lastModifiedBy;
	private Date lastModifiedDate;
	
	public Beneficiary(){
		
	}
	
	public Beneficiary(Client client2) {
		this.client = client2;
	}

	/**
	 * @return the beneficiary
	 */
	@ManyToOne
	@JoinColumn(name="client_id", nullable=false)
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	/**
	 * @return the pin
	 */
	@Column(name = "pin", nullable = false)
	public String getMemberNumber() {
		return memberNumber;
	}
	
	/**
	 * @param pin the pin to set
	 */
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	/**
	 * @return the firstName
	 */
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param Date of birth the lastName to set
	 */
	@Column(name = "date_of_birth", nullable = false)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * @param Username to set
	 */
	@Column(name = "username", nullable = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @param password to set
	 */
	@Column(name = "password", nullable = true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @param Whether Principal or not to not
	 */
	@Column(name = "principal", nullable = false)
	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	/**
	 * @param Whether Mobile client or not to set
	 */
	@Column(name = "mobile_client", nullable = false)
	public Boolean getMobile() {
		return mobile;
	}

	public void setMobile(Boolean mobile) {
		this.mobile = mobile;
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
