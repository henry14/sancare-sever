package za.co.sanlam.server.service;

import java.util.Date;

import za.co.sanlam.model.Scheme;
import za.co.sanlam.model.User;

/**
 * @author henry14
 * 
 */
public interface SchemeService extends BaseService<Scheme> {
	
	Scheme getSchemeByName(String t);

	User getCreatedBy(String id);

	Date getCreatedDate(String id);

}
