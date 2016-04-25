package za.co.sanlam.server.service;

import java.util.Date;

import za.co.sanlam.model.Town;
import za.co.sanlam.model.User;

public interface TownService extends BaseService<Town> {

	User getCreatedBy(String id);

	Date getCreatedDate(String id);

}
