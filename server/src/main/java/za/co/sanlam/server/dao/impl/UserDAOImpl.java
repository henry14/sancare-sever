package za.co.sanlam.server.dao.impl;

import org.springframework.stereotype.Repository;

import za.co.sanlam.model.User;
import za.co.sanlam.server.dao.UserDAO;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

}
