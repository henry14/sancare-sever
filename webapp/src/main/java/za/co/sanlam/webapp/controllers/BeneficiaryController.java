package za.co.sanlam.webapp.controllers;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import za.co.sanlam.model.Beneficiary;
import za.co.sanlam.model.Client;
import za.co.sanlam.model.User;
import za.co.sanlam.security.util.SancareSecurityUtil;
import za.co.sanlam.server.service.BeneficiaryService;
import za.co.sanlam.server.service.ClientService;

@Controller
@RequestMapping("beneficiary")
public class BeneficiaryController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private BeneficiaryService beneficiaryService;
	
	private static final String DISPLAY_NAME = "Beneficiary";
//	private static final String DISPLAY_NAME_PLURAL = "Beneficiaries";
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("view/{clientId}")
	public ModelAndView beneficiaries(@PathVariable("clientId") String clientId, ModelMap model){
		Client client = clientService.getById(clientId);
		Beneficiary beneficiary = new Beneficiary();
		List<Beneficiary> beneficiaries = beneficiaryService.getBeneficiarysByClient(client);
		
		model.addAttribute("client", client);
		model.addAttribute("beneficiary", beneficiary);
		model.addAttribute("beneficiaries", beneficiaries);
		return new ModelAndView("beneficiaryView", model);
	}
	
	@RequestMapping("add/{clientId}")
	public ModelAndView addBeneficiary(@PathVariable("clientId") String clientId, ModelMap model){
			Client client = clientService.getById(clientId);
			Beneficiary beneficiary = new Beneficiary(client);
			model.put("beneficiary", beneficiary);
			model.put("client", client);
		
		return new ModelAndView("beneficiaryAdd", model);
	}
	
	@RequestMapping("edit/{id}")
	public ModelAndView editBeneficiary(@PathVariable("id") String id, ModelMap modelMap){
		Beneficiary beneficiary = beneficiaryService.getById(id);
		if(beneficiary != null){
			modelMap.put("beneficiary", beneficiary);
			
			return new ModelAndView("beneficiaryAdd", modelMap);
		}
		
		return new ModelAndView("beneficiaryAdd");//, model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "delete/{clientId}/{beneficiaryIds}")
	public ModelAndView delete(@PathVariable("clientId") String clientId, 
			@PathVariable("beneficiaryIds") String beneficiaryIds, ModelMap modelMap) {
		String[] idzToDelete = beneficiaryIds.split(",");
		try {
			beneficiaryService.deleteByIds(idzToDelete);

		} catch (Exception e) {
			/*log.error("Error", e);

			modelMap.put(WebConstants.MODEL_ATTRIBUTE_ERROR_MESSAGE,
					e.getMessage());*/
		}
		return beneficiaries(clientId, modelMap);
	}
	
	@RequestMapping("save")
	public ModelAndView save(@ModelAttribute("beneficiary") Beneficiary beneficiary, ModelMap model){
		Beneficiary existing = beneficiary;
		if (existing.getMobile() == null)
			existing.setMobile(false);
		
		try{
			User user = SancareSecurityUtil.getLoggedInUser();
//			beneficiaryService.validate(existing);
			if(StringUtils.isNotEmpty(existing.getId())){
				existing.setCreatedBy(beneficiaryService.getCreatedBy(existing.getId()));
				existing.setCreatedDate(beneficiaryService.getCreatedDate(existing.getId()));
				existing.setLastModifiedBy(user);
			}
			else{
				existing.setId(null);
				existing.setCreatedBy(user);
			}
			beneficiaryService.validate(existing);
			
			beneficiaryService.save(existing);
			
			model.put(WebConstants.SYSTEM_MESSAGE, DISPLAY_NAME+" saved successfully");
			
		} catch (Exception ex){
			log.error("Error", ex);
			ApplicationController.addErrorMessage(model, ex.getMessage());
			
			return addBeneficiary(existing.getClient().getId(), model);
		}
		return beneficiaries(existing.getClient().getId(), model);
	}	

}
