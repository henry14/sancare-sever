package za.co.sanlam.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.sanlam.model.User;
import za.co.sanlam.model.exception.ValidationException;
import za.co.sanlam.server.dao.UserDAO;
import za.co.sanlam.server.service.UserService;
import za.co.sanlam.server.utils.Validate;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void save(User t) {
		userDAO.save(t);
		
	}

	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return userDAO.searchUniqueByPropertyEqual("id", id);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	public void deleteByIds(String[] ids) {
		userDAO.removeByIds(ids);
		
	}

	@Override
	public void validate(User obj) throws ValidationException {
		Validate.isNotBlank(obj.getFirstName(), "First name");
		Validate.isNotBlank(obj.getLastName(), "Last name");
		Validate.isNotBlank(obj.getUsername(), "Username");
		Validate.isNotBlank(obj.getPassword(), "Password");
		Validate.isNotNull(obj.getRole(), "Role");
		
		try {
			User existing = getUserByUsername(obj.getUsername());
			
			if (null != existing && (obj.idIsNOTBlankOrEmpty() || (!existing.equals(obj))))
				throw new ValidationException("Username "+obj.getUsername()
						+" already exists");
			
		} catch (Exception e) {
			throw new ValidationException("Error " +e.getMessage());
		}
		
	}

	@Override
	public User getUserByUsername(String username) {
		//User user = userDAO.s
		return null;
	}

}
