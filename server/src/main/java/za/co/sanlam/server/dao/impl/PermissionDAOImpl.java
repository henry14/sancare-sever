package za.co.sanlam.server.dao.impl;

import org.springframework.stereotype.Repository;

import za.co.sanlam.model.Permission;
import za.co.sanlam.server.dao.PermissionDAO;

@Repository("permissionDAO")
public class PermissionDAOImpl extends BaseDAOImpl<Permission> implements PermissionDAO{

}
