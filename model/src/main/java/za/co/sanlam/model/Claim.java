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
import javax.persistence.Transient;

/**
 * @author henry14
 * 
 */
@Entity
@Table(name = "claims")
public class Claim extends BaseData {

	private static final long serialVersionUID = 2664754234134436917L;
//	private String medical;
	//amount used
//	private Integer amount;
//	private Integer amountUsed;
	private Beneficiary beneficiary;
	private Activity activity;
	private Integer total;
	private User createdBy;
	private Date createdDate;
	private User lastModifiedBy;
	private Date lastModifiedDate;

	/**
	 * @return the declare
	 *//*
	@Column(name = "medical", nullable = false)
	public String getMedical() {
		return medical;
	}

	*//**
	 * @param declare
	 *            the declare to set
	 *//*
	public void setMedical(String medical) {
		this.medical = medical;
	}*/

	/**
	 * @return the cost
	 *//*
	@Column(name = "contribution", nullable = false)
	public Integer getAmount() {
		return amount;
	}

	*//**
	 * @param cost
	 *            the cost to set
	 *//*
	public void setAmount(Integer amount) {
		this.amount = amount;
	}*/

	/**
	 * @return the amountUsed
	 */
	/*@Transient
	public Integer getAmountUsed(int cost) {
		
		return amount/4;
	}*/


	/**
	 * @return the client
	 */
	@ManyToOne
	@JoinColumn(name="beneficiary_id", nullable=false)
	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	/**
	 * @param client the client to set
	 */
	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	/**
	 * @return the activity
	 */
	@OneToOne
	@JoinColumn(name="activity_id", nullable=false)
	public Activity getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	/**
	 * @param total spent the total to set
	 */
	@Transient
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
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
