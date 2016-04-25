package za.co.sanlam.server.service;

import java.util.List;

import za.co.sanlam.model.Beneficiary;
import za.co.sanlam.model.Claim;

/**
 * @author henry14
 * 
 */
public interface ClaimService extends BaseService<Claim> {

	List<Claim> getClaimByClient(Beneficiary beneficiary);

	List<Claim> getClaimByBeneficiary(Beneficiary client);

}
