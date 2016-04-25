package za.co.sanlam.server.service.impl;

import java.util.Date;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.sanlam.model.Beneficiary;
import za.co.sanlam.model.Client;
import za.co.sanlam.model.User;
import za.co.sanlam.model.exception.ValidationException;
import za.co.sanlam.server.dao.BeneficiaryDAO;
import za.co.sanlam.server.service.BeneficiaryService;
import za.co.sanlam.server.utils.Validate;

import com.googlecode.genericdao.search.Search;

@Transactional
@Service("beneficiaryService")
public class BeneficiaryServiceImpl implements BeneficiaryService {
	
	@Autowired
	private BeneficiaryDAO beneficiaryDAO;
	
//	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void save(Beneficiary beneficiary) {
		beneficiaryDAO.save(beneficiary);
		
	}

	@Override
	public Beneficiary getById(String id) {
		// TODO Auto-generated method stub
		return beneficiaryDAO.searchUniqueByPropertyEqual("id", id);
	}

	@Override
	public List<Beneficiary> getAll() {
		// TODO Auto-generated method stub
		return beneficiaryDAO.findAll();
	}

	@Override
	public void deleteByIds(String[] ids) {
		beneficiaryDAO.removeByIds(ids);
		
	}

	@Override
	public void validate(Beneficiary b) throws ValidationException {
		
		Validate.isNotNull(b.getMemberNumber(), "Member number");
		Validate.isNotNull(b.getFirstName(), "First name");
		Validate.isNotNull(b.getLastName(), "Last name");
		Validate.isNotNull(b.getDateOfBirth(), "Date of Birth");
		Validate.isNotNull(b.getPrincipal(), "Principal");
		
		try {
			Beneficiary existing = getBeneficiaryByMemberNumber(b.getMemberNumber());
			
			if (null != existing && (b.idIsNOTBlankOrEmpty() || (!existing.equals(b))))
				throw new ValidationException("Beneficary with Customer number "+b.getMemberNumber()
						+" already exists");
			
		} catch (Exception e) {
			throw new ValidationException("Error " +e.getMessage());
		}
		
	}

	@Override
	public Beneficiary getClientByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Beneficiary getBeneficiaryByMemberNumber(String memberNumber) {
		// TODO Auto-generated method stub
		return beneficiaryDAO.searchUniqueByPropertyEqual("memberNumber", memberNumber);
	}

	@Override
	public User getCreatedBy(String id) {
		Search search = new Search();
		search.addFilterEqual("id", id);
		Beneficiary beneficiary = beneficiaryDAO.searchUnique(search);
		return beneficiary.getCreatedBy();
	}

	@Override
	public Date getCreatedDate(String id) {
		Search search = new Search();
		search.addFilterEqual("id", id);
		Beneficiary beneficiary = beneficiaryDAO.searchUnique(search);
		return beneficiary.getCreatedDate();
	}

	@Override
	public List<Beneficiary> getBeneficiarysByClient(Client client) {
		Search search = new Search();
		search.addFilterEqual("client", client);
		List<Beneficiary> beneficiaries = beneficiaryDAO.search(search);
		return beneficiaries;
	}

}
