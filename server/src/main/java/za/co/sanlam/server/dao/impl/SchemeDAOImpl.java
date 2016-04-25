package za.co.sanlam.server.dao.impl;

import org.springframework.stereotype.Repository;

import za.co.sanlam.model.Scheme;
import za.co.sanlam.server.dao.SchemeDAO;

/**
 * @author henry14
 * 
 */
@Repository("schemeDAO")
public class SchemeDAOImpl extends BaseDAOImpl<Scheme> implements SchemeDAO {

}
