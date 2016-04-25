package za.co.sanlam.server.service;

import java.util.Date;

import za.co.sanlam.model.Client;
import za.co.sanlam.model.User;

public interface ClientService extends BaseService<Client>{

	User getCreatedBy(String id);

	Date getCreatedDate(String id);

}
