package za.co.sanlam.server.service;

import java.util.Date;
import java.util.List;

import za.co.sanlam.model.Beneficiary;
import za.co.sanlam.model.Client;
import za.co.sanlam.model.User;

public interface BeneficiaryService extends BaseService<Beneficiary>{

	Beneficiary getClientByUsername(String username);

	Beneficiary getBeneficiaryByMemberNumber(String memberNumber);

	User getCreatedBy(String id);

	Date getCreatedDate(String id);

	List<Beneficiary> getBeneficiarysByClient(Client client);

}
