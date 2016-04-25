package za.co.sanlam.server.dao.impl;

import org.springframework.stereotype.Repository;

import za.co.sanlam.model.Claim;
import za.co.sanlam.server.dao.ClaimDAO;

/**
 * @author henry14
 * 
 */
@Repository("claimDAO")
public class ClaimDAOImpl extends BaseDAOImpl<Claim> implements ClaimDAO {

}
