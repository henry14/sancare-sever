package za.co.sanlam.server.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.sanlam.model.Client;
import za.co.sanlam.model.User;
import za.co.sanlam.model.exception.ValidationException;
import za.co.sanlam.server.dao.ClientDAO;
import za.co.sanlam.server.service.ClientService;
import za.co.sanlam.server.utils.Validate;

import com.googlecode.genericdao.search.Search;

@Transactional
@Service("clientService")
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDAO clientDAO;

	@Override
	public void save(Client t) {
		clientDAO.save(t);
		
	}

	@Override
	public Client getById(String id) {
		// TODO Auto-generated method stub
		return clientDAO.searchUniqueByPropertyEqual("id", id);
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return clientDAO.findAll();
	}

	@Override
	public void deleteByIds(String[] ids) {
		clientDAO.removeByIds(ids);
		
	}

	@Override
	public void validate(Client obj) throws ValidationException {
		Validate.isNotBlank(obj.getName(), "Client");
		Validate.isNotNull(obj.getPremium(), "Premium");
		
	}

	@Override
	public User getCreatedBy(String id) {
		Search search = new Search();
		search.addFilterEqual("id", id);
		Client client = clientDAO.searchUnique(search);
		return client.getCreatedBy();
	}

	@Override
	public Date getCreatedDate(String id) {
		Search search = new Search();
		search.addFilterEqual("id", id);
		Client client = clientDAO.searchUnique(search);
		return client.getCreatedDate();
	}

}
