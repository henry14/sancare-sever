package za.co.sanlam.server.service;

import java.util.List;

import za.co.sanlam.model.Activity;
import za.co.sanlam.model.Hospital;

/**
 * @author henry14
 *
 */
public interface ActivityService extends BaseService<Activity>{
	
	List<Activity> getActivitysByHospital(Hospital hospital);

}
