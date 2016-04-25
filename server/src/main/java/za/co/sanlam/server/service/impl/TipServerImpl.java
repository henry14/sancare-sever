package za.co.sanlam.server.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;

import za.co.sanlam.model.Beneficiary;
import za.co.sanlam.model.Tip;
import za.co.sanlam.model.User;
import za.co.sanlam.model.exception.ValidationException;
import za.co.sanlam.server.dao.TipDAO;
import za.co.sanlam.server.dao.UserDAO;
import za.co.sanlam.server.service.TipService;
import za.co.sanlam.server.utils.Validate;

/**
 * @author henry14
 * 
 */
@Transactional
@Service("tipService")
public class TipServerImpl implements TipService {

	@Autowired
	private TipDAO tipDAO;
	@Autowired
	private UserDAO userDAO; 

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public void save(Tip t) {
		tipDAO.save(t);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#getById(java.lang.String)
	 */
	@Override
	public Tip getById(String id) {
		// TODO Auto-generated method stub
		return tipDAO.searchUniqueByPropertyEqual("id", id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#getAll()
	 */
	@Override
	public List<Tip> getAll() {
		// TODO Auto-generated method stub
		List<Tip> tips = tipDAO.findAll();
		return tips;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#deleteByIds(java.lang.String[])
	 */
	@Override
	public void deleteByIds(String[] ids) {
		tipDAO.removeByIds(ids);

	}

	/* (non-Javadoc)
	 * @see za.co.sanlam.server.service.TipService#getTipByClient(za.co.sanlam.model.AppClient)
	 */
	@Override
	public List<Tip> getTipByClient(Beneficiary beneficiary) {
		List<Tip> tips = tipDAO.searchByPropertyEqual("beneficiary",
				beneficiary);
		return tips;
	}

	@Override
	public void validate(Tip obj) throws ValidationException {
		Validate.isNull(obj.getMessage(), "Message");
		
	}

	@Override
	public User getCreatedBy(String Id) {
		Search search = new Search();
		search.addFilterEqual("id", Id);
		Tip tip = tipDAO.searchUnique(search);
		return tip.getCreatedBy();
	}

	@Override
	public Date getCreatedDate(String Id) {
		Search search = new Search();
		search.addFilterEqual("id", Id);
		Tip tip = tipDAO.searchUnique(search);
		return tip.getCreatedDate();
	}

}
