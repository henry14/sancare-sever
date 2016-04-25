package za.co.sanlam.server.dao.impl;

import org.springframework.stereotype.Repository;

import za.co.sanlam.model.Hospital;
import za.co.sanlam.server.dao.HospitalDAO;

/**
 * @author henry14
 *
 */
@Repository("hospitalDAO")
public class HospitalDAOImpl extends BaseDAOImpl<Hospital> implements HospitalDAO {

}
