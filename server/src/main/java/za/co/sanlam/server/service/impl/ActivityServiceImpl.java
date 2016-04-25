package za.co.sanlam.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;

import za.co.sanlam.model.Activity;
import za.co.sanlam.model.Hospital;
import za.co.sanlam.model.exception.ValidationException;
import za.co.sanlam.server.dao.ActivityDAO;
import za.co.sanlam.server.service.ActivityService;

/**
 * @author henry14
 *
 */
@Transactional
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private ActivityDAO activityDAO;

	/* (non-Javadoc)
	 * @see za.co.sanlam.server.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public void save(Activity t) {
		activityDAO.save(t);
		
	}

	/* (non-Javadoc)
	 * @see za.co.sanlam.server.service.BaseService#getById(java.lang.String)
	 */
	@Override
	public Activity getById(String id) {
		// TODO Auto-generated method stub
		Activity activity = activityDAO.searchUniqueByPropertyEqual("id", id);
		return activity;
	}

	/* (non-Javadoc)
	 * @see za.co.sanlam.server.service.BaseService#getAll()
	 */
	@Override
	public List<Activity> getAll() {
		// TODO Auto-generated method stub
		return activityDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see za.co.sanlam.server.service.BaseService#deleteByIds(java.lang.String[])
	 */
	@Override
	public void deleteByIds(String[] ids) {
		activityDAO.removeByIds(ids);
		
	}

	/* (non-Javadoc)
	 * @see za.co.sanlam.server.service.ActivityService#getActivitysByHospital(za.co.sanlam.model.Hospital)
	 */
	@Override
	public List<Activity> getActivitysByHospital(Hospital hospital) {
		Search search = new Search();
		search.addFilterEqual("hospital", hospital);
		List<Activity> activities = activityDAO.search(search);
		return activities;
	}

	@Override
	public void validate(Activity obj) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
