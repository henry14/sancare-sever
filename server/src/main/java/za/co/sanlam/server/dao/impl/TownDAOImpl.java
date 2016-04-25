package za.co.sanlam.server.dao.impl;

import org.springframework.stereotype.Repository;

import za.co.sanlam.model.Town;
import za.co.sanlam.server.dao.TownDAO;

@Repository("townDAO")
public class TownDAOImpl extends BaseDAOImpl<Town> implements TownDAO {

}
