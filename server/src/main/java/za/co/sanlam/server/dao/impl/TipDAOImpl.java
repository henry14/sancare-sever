package za.co.sanlam.server.dao.impl;

import org.springframework.stereotype.Repository;

import za.co.sanlam.model.Tip;
import za.co.sanlam.server.dao.TipDAO;

/**
 * @author henry14
 * 
 */
@Repository("tipDAO")
public class TipDAOImpl extends BaseDAOImpl<Tip> implements TipDAO {

}
