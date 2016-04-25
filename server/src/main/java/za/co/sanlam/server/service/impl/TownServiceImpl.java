package za.co.sanlam.server.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.sanlam.model.Town;
import za.co.sanlam.model.User;
import za.co.sanlam.model.exception.ValidationException;
import za.co.sanlam.server.dao.TownDAO;
import za.co.sanlam.server.service.TownService;
import za.co.sanlam.server.utils.Validate;

import com.googlecode.genericdao.search.Search;

@Transactional
@Service("townService")
public class TownServiceImpl implements TownService {
	
	@Autowired
	private TownDAO townDAO;

	@Override
	public void save(Town t) {
		townDAO.save(t);
		
	}

	@Override
	public Town getById(String id) {
		// TODO Auto-generated method stub
		return townDAO.searchUniqueByPropertyEqual("id", id);
	}

	@Override
	public List<Town> getAll() {
		// TODO Auto-generated method stub
		return townDAO.findAll();
	}

	@Override
	public void deleteByIds(String[] ids) {
		townDAO.removeByIds(ids);
		
	}

	@Override
	public void validate(Town t) throws ValidationException {
		Validate.isNotNull(t.getName(), "Town");
		Validate.isNotBlank(t.getName(), "Town");
		
	}

	@Override
	public User getCreatedBy(String id) {
		Search search = new Search();
		search.addFilterEqual("id", id);
		Town town = townDAO.searchUnique(search);
		return town.getCreatedBy();
	}

	@Override
	public Date getCreatedDate(String id) {
		Search search = new Search();
		search.addFilterEqual("id", id);
		Town town = townDAO.searchUnique(search);
		return town.getCreatedDate();
	}

}
