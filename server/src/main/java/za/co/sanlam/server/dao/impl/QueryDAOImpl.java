package za.co.sanlam.server.dao.impl;

import org.springframework.stereotype.Repository;

import za.co.sanlam.model.Query;
import za.co.sanlam.server.dao.QueryDAO;

/**
 * @author henry14
 * 
 */
@Repository("queryDAO")
public class QueryDAOImpl extends BaseDAOImpl<Query> implements QueryDAO {

}
