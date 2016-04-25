package za.co.sanlam.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.sanlam.model.Beneficiary;
import za.co.sanlam.model.Claim;
import za.co.sanlam.model.exception.ValidationException;
import za.co.sanlam.server.dao.ClaimDAO;
import za.co.sanlam.server.service.ClaimService;
import za.co.sanlam.server.utils.Validate;

/**
 * @author henry14
 * 
 */
@Transactional
@Service("claimService")
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimDAO claimDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public void save(Claim t) {
		claimDAO.save(t);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#getById(java.lang.String)
	 */
	@Override
	public Claim getById(String id) {
		// TODO Auto-generated method stub
		return claimDAO.searchUniqueByPropertyEqual("id", id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#getAll()
	 */
	@Override
	public List<Claim> getAll() {
		List<Claim> claims = claimDAO.findAll();
		return claims;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.sanlam.service.BaseService#deleteByIds(java.lang.String[])
	 */
	@Override
	public void deleteByIds(String[] ids) {
		claimDAO.removeByIds(ids);

	}

	/* (non-Javadoc)
	 * @see za.co.sanlam.server.service.ClaimService#getClaimByClient(za.co.sanlam.model.AppClient)
	 */
	@Override
	public List<Claim> getClaimByClient(Beneficiary beneficiary) {
		List<Claim> claims = claimDAO.searchByPropertyEqual("beneficiary",
				beneficiary);
		return claims;
	}

	@Override
	public void validate(Claim obj) throws ValidationException {
		Validate.isNotNull(obj.getBeneficiary(), "Beneficiary");
		Validate.isNotNull(obj.getActivity(), "Activity");
		
	}

	@Override
	public List<Claim> getClaimByBeneficiary(Beneficiary client) {
		// TODO Auto-generated method stub
		return null;
	}

}
