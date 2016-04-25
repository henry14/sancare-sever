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
@Table(name="hospital_services")
public class Activity extends BaseData {
	
	private static final long serialVersionUID = -2956670706971083257L;
	private String action;
	private Integer cost;
	private Hospital hospital;
	
	
	/**
	 * @return the hospital
	 */
	@ManyToOne
	@JoinColumn(name="hospital_id", nullable=false)
	public Hospital getHospital() {
		return hospital;
	}
	/**
	 * @param hospital the hospital to set
	 */
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	/**
	 * @return the action
	 */
	@Column(name="activity", nullable=false)
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the cost
	 */
	@Column(name="fee", nullable=false)
	public Integer getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	public Activity(){
		
	}
	public Activity(Hospital hospital){
		this.hospital = hospital;
	}

}
