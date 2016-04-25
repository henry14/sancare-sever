package za.co.sanlam.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.sanlam.model.Role;
import za.co.sanlam.model.exception.ValidationException;
import za.co.sanlam.server.dao.RoleDAO;
import za.co.sanlam.server.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDAO roleDAO;

	@Override
	public void save(Role t) {
		roleDAO.save(t);
		
	}

	@Override
	public Role getById(String id) {
		// TODO Auto-generated method stub
		return roleDAO.searchUniqueByPropertyEqual("id", id);
	}

	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return roleDAO.findAll();
	}

	@Override
	public void deleteByIds(String[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(Role obj) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public Role getRoleByPrivilage(String privilage) {
		Role role = roleDAO.searchUniqueByPropertyEqual("privilage", privilage);
		return role;
	}*/

}
