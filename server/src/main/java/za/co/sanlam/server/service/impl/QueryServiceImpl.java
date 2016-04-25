package za.co.sanlam.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.sanlam.model.Beneficiary;
import za.co.sanlam.model.Query;
import za.co.sanlam.model.exception.ValidationException;
//import za.co.sanlam.model.search.QuerySearchParams;
import za.co.sanlam.server.dao.QueryDAO;
import za.co.sanlam.server.service.QueryService;

/**
 * @author henry14
 * 
 */
@Service("queryService")
@Transactional
public class QueryServiceImpl implements QueryService {

	@Autowired
	private QueryDAO queryDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public void save(Query t) {
		queryDAO.save(t);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#getById(java.lang.String)
	 */
	@Override
	public Query getById(String id) {
		// TODO Auto-generated method stub
		return queryDAO.searchUniqueByPropertyEqual("id", id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#getAll()
	 */
	@Override
	public List<Query> getAll() {
		List<Query> queries = queryDAO.findAll();
		return queries;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#deleteByIds(java.lang.String[])
	 */
	@Override
	public void deleteByIds(String[] ids) {
		queryDAO.removeByIds(ids);

	}

	/* (non-Javadoc)
	 * @see za.co.sanlam.server.service.QueryService#getQueryByClient(za.co.sanlam.model.AppClient)
	 */
	@Override
	public List<Query> getQueryByClient(Beneficiary beneficiary) {
		List<Query> queries = queryDAO.searchByPropertyEqual("beneficiary",
				beneficiary);
		return queries;
	}

	@Override
	public void validate(Query obj) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * za.co.sanlam.service.QueryService#searchQueriesWithParams(java.lang.String
	 * )
	 */
/*	@Override
	@Transactional(readOnly = true)
	public List<Query> searchQueriesWithParams(String deviceId) {
		List<Query> queries = queryDAO.searchByPropertyEqual("deviceId",
				deviceId);
		return queries;
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * za.co.sanlam.server.service.QueryService#searchUniqueWithParams(za.co
	 * .sanlam.server.service.QuerySearchParams)
	 */
	/*@Override
	public Query searchUniqueWithParams(QuerySearchParams params) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
