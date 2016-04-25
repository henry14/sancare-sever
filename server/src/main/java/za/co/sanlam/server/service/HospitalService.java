package za.co.sanlam.server.service;

import java.util.Date;
import java.util.List;

import za.co.sanlam.model.Hospital;
import za.co.sanlam.model.Town;
import za.co.sanlam.model.User;

/**
 * @author henry14
 *
 */
public interface HospitalService extends BaseService<Hospital> {
	
	Hospital getHospitalByCode(String code);
	
	User getCreatedBy(String Id);
	
	Date getCreatedDate(String Id);

	List<Hospital> getHospitalsByTown(Town town);

}
