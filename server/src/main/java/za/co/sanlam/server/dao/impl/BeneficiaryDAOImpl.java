package za.co.sanlam.server.dao.impl;

import org.springframework.stereotype.Repository;

import za.co.sanlam.model.Beneficiary;
import za.co.sanlam.server.dao.BeneficiaryDAO;

/**
 * @author henry14
 *
 */
@Repository("beneficiaryDAO")
public class BeneficiaryDAOImpl extends BaseDAOImpl<Beneficiary> implements BeneficiaryDAO {

}
