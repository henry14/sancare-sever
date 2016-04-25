package za.co.sanlam.server.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.sanlam.model.Scheme;
import za.co.sanlam.model.User;
import za.co.sanlam.model.exception.ValidationException;
import za.co.sanlam.server.dao.SchemeDAO;
import za.co.sanlam.server.service.SchemeService;
import za.co.sanlam.server.utils.Validate;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

/**
 * @author henry14
 * 
 */
@Transactional
@Service("schemeService")
public class SchemeServiceImpl implements SchemeService {

	@Autowired
	private SchemeDAO schemeDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public void save(Scheme t) {
		schemeDAO.save(t);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#getById(java.lang.String)
	 */
	@Override
	public Scheme getById(String id) {
		// TODO Auto-generated method stub
		return schemeDAO.searchUniqueByPropertyEqual("id", id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#getAll()
	 */
	@Override
	public List<Scheme> getAll() {
		List<Scheme> schemes = schemeDAO.findAll();
		return schemes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#deleteByIds(java.lang.String[])
	 */
	@Override
	public void deleteByIds(String[] ids) {
		schemeDAO.removeByIds(ids);

	}

	@Override
	public void validate(Scheme scheme) throws ValidationException {
		Validate.isNotNull(scheme.getName(), "Plan");
		Validate.isNotNull(scheme.getDescription(), "Description");
		
		Scheme existing = getSchemeByName(scheme.getName());
		
		if(null != existing && (StringUtils.isBlank(existing.getId()) || (!existing.equals(scheme))))
			throw new ValidationException("Scheme Named " + existing.getName()
					+ " already exists, " + existing.getName());
		
	}

	@Override
	public Scheme getSchemeByName(String plan) {
		Search search = new Search();
		search.addFilter(new Filter("plan", plan, Filter.OP_EQUAL));
		return schemeDAO.searchUnique(search);
	}

	@Override
	public User getCreatedBy(String id) {
		Search search = new Search();
		search.addFilterEqual("id", id);
		Scheme scheme = schemeDAO.searchUnique(search);
		return scheme.getCreatedBy();
	}

	@Override
	public Date getCreatedDate(String id) {
		Search search = new Search();
		search.addFilterEqual("id", id);
		Scheme scheme = schemeDAO.searchUnique(search);
		return scheme.getCreatedDate();
	}

}
