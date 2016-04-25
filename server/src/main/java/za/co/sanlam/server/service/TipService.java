package za.co.sanlam.server.service;

import java.util.Date;
import java.util.List;

import za.co.sanlam.model.Beneficiary;
import za.co.sanlam.model.Tip;
import za.co.sanlam.model.User;

/**
 * @author henry14
 * 
 */
public interface TipService extends BaseService<Tip> {
	
	List<Tip> getTipByClient(Beneficiary client);
	
	User getCreatedBy(String Id);
	
	Date getCreatedDate(String Id);

}
