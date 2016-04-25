package za.co.sanlam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author henry14
 * 
 */
@Entity
@Table(name = "queries")
public class Query extends BaseData {

	private static final long serialVersionUID = 1529492969434602660L;

	private String complaint;
    private String feedback;
	private Beneficiary beneficiary;

	@Column(name = "complaint", nullable = false)
	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	/**
	 * @return the deviceId
	 */
	/*@Column(name = "deviceId", nullable = false)
	public String getDeviceId() {
		return deviceId;
	}

	*//**
	 * @param deviceId
	 *            the deviceId to set
	 *//*
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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
	 * @return the feedback
	 */
	@Column(name = "response", nullable = false)
	public String getFeedback() {
		return feedback;
	}

	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	

}
