package za.co.sanlam.server.service;

import za.co.sanlam.model.User;

public interface UserService extends BaseService<User>{
	
	User getUserByUsername(String username);

}
