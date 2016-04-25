package za.co.sanlam.server.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.sanlam.model.Hospital;
import za.co.sanlam.model.Town;
import za.co.sanlam.model.User;
import za.co.sanlam.model.exception.ValidationException;
import za.co.sanlam.server.dao.HospitalDAO;
import za.co.sanlam.server.service.HospitalService;
import za.co.sanlam.server.utils.Validate;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

/**
 * @author henry14
 *
 */
@Transactional
@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalDAO hospitalDAO;

	/* (non-Javadoc)
	 * @see za.co.sanlam.server.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public void save(Hospital t) {
		hospitalDAO.save(t);
		
	}

	/* (non-Javadoc)
	 * @see za.co.sanlam.server.service.BaseService#getById(java.lang.String)
	 */
	@Override
	public Hospital getById(String id) {
		Hospital hospital = hospitalDAO.searchUniqueByPropertyEqual("id", id);
		return hospital;
	}

	/* (non-Javadoc)
	 * @see za.co.sanlam.server.service.BaseService#getAll()
	 */
	@Override
	public List<Hospital> getAll() {
		
		return hospitalDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see za.co.sanlam.server.service.BaseService#deleteByIds(java.lang.String[])
	 */
	@Override
	public void deleteByIds(String[] ids) {
		hospitalDAO.removeByIds(ids);
		
	}

	@Override
	public void validate(Hospital hosp) throws ValidationException {
		Validate.isNotNull(hosp.getName(), "Hospital");
		Validate.isNotBlank(hosp.getName(), "Hospital");
		// Check if the hospital already exists
//		Hospital existing = getHospitalByCode(hosp.getName());
		
		/*if(null != existing && (StringUtils.isBlank(existing.getId()) || (!existing.equals(hosp))))
			throw new ValidationException("Hospital Name " + existing.getName()
					+ " already exists, " + existing.getName());*/
			
		
	}

	@Override
	public Hospital getHospitalByCode(String code) {
		// TODO Auto-generated method stub
		Search search = new Search();
		search.addFilter(new Filter("code", code, Filter.OP_EQUAL));
		return hospitalDAO.searchUnique(search);
	}
	
	@Override
	public User getCreatedBy(String Id) {
		Search search = new Search();
		search.addFilterEqual("id", Id);
		Hospital hospital = hospitalDAO.searchUnique(search);
		return hospital.getCreatedBy();
	}

	@Override
	public Date getCreatedDate(String Id) {
		Search search = new Search();
		search.addFilterEqual("id", Id);
		Hospital hospital = hospitalDAO.searchUnique(search);
		return hospital.getCreatedDate();
	}

	@Override
	public List<Hospital> getHospitalsByTown(Town town) {
		Search search = new Search();
		search.addFilterEqual("town", town);
		List<Hospital> hospitals = hospitalDAO.search(search);
		return hospitals;
	}

}
