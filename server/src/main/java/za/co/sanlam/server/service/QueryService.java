package za.co.sanlam.server.service;

import java.util.List;

import za.co.sanlam.model.Beneficiary;
//import za.co.sanlam.model.Claim;
import za.co.sanlam.model.Query;
//import za.co.sanlam.model.search.QuerySearchParams;

/**
 * @author henry14
 * 
 */
public interface QueryService extends BaseService<Query> {

//	List<Query> searchQueriesWithParams(String deviceId);

//	Query searchUniqueWithParams(QuerySearchParams params);
	
	List<Query> getQueryByClient(Beneficiary beneficiary);

}
