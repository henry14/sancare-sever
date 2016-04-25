package za.co.sanlam.server.dao.impl;

import org.springframework.stereotype.Repository;

import za.co.sanlam.model.Activity;
import za.co.sanlam.server.dao.ActivityDAO;

/**
 * @author henry14
 *
 */
@Repository("activityDAO")
public class ActivityDAOImpl extends BaseDAOImpl<Activity> implements ActivityDAO {

}
