package za.co.sanlam.server.dao.impl;

import org.springframework.stereotype.Repository;

import za.co.sanlam.model.Client;
import za.co.sanlam.server.dao.ClientDAO;

@Repository("clientDAO")
public class ClientDAOImpl extends BaseDAOImpl<Client> implements ClientDAO {

}
