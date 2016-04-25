package za.co.sanlam.server.dao.impl;

import org.springframework.stereotype.Repository;

import za.co.sanlam.model.Role;
import za.co.sanlam.server.dao.RoleDAO;

@Repository("roleDAO")
public class RoleDAOImpl extends BaseDAOImpl<Role> implements RoleDAO{

}
