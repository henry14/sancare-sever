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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import za.co.sanlam.model.Activity;
import za.co.sanlam.model.Beneficiary;
import za.co.sanlam.model.Claim;
import za.co.sanlam.server.service.ActivityService;
import za.co.sanlam.server.service.BeneficiaryService;
import za.co.sanlam.server.service.ClaimService;

/**
 * @author henry14
 * 
 */
//statements
@Controller
@RequestMapping(value="statement")
public class StatementController {
	
	@Autowired
	private ClaimService claimService;
	@Autowired
	private BeneficiaryService beneficiaryService;
	@Autowired
	private ActivityService activityService;
	
	private static final String DISPLAY_NAME = "Statement";
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "view")
	public ModelAndView viewClaims(ModelMap modelMap) {
		Claim claim = new Claim();
		List<Claim> claims = claimService.getAll();
		modelMap.put("claim", claim);
		modelMap.put("claims", claims);
		return new ModelAndView("claimView", modelMap);
	}
	
	@RequestMapping(value = "add")
	public ModelAndView addClaim(ModelMap modelMap) {
		Claim claim = new Claim();
		List<Activity> activities = activityService.getAll();
		List<Beneficiary> clients = beneficiaryService.getAll();
		modelMap.put("claim", claim);
		modelMap.put("activities", activities);
		modelMap.put("clients", clients);
		return new ModelAndView("claimAdd");
	}
	
	@RequestMapping("edit/{claimId}")
	public ModelAndView editTip(@PathVariable("claimId") String claimId, ModelMap modelMap){
		Claim claim = claimService.getById(claimId);
		if(claim != null){
			modelMap.put("claim", claim);
			
			return new ModelAndView("claimAdd", modelMap);
		}
		
		return new ModelAndView("claimAdd");//, model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "delete/{claimIds}")
	public ModelAndView delete(	@PathVariable("claimIds") String claimIds, 
			ModelMap modelMap) {
		String[] idzToDelete = claimIds.split(",");
		try {
			claimService.deleteByIds(idzToDelete);

		} catch (Exception e) {
			/*log.error("Error", e);

			modelMap.put(WebConstants.MODEL_ATTRIBUTE_ERROR_MESSAGE,
					e.getMessage());*/
		}
		return viewClaims(modelMap);
	}
	
	@RequestMapping("save")
	public ModelAndView save(@ModelAttribute("claim") Claim claim, ModelMap model){
		Claim exisiting = claim;
		
		try{
			if(StringUtils.isNotEmpty(exisiting.getId())){
				
			}
			else{
				exisiting.setId(null);
				
			}
			claimService.validate(exisiting);
			claimService.save(exisiting);
			model.put(WebConstants.SYSTEM_MESSAGE, DISPLAY_NAME+" saved successfully");
			
		} catch (Exception ex){
			log.error("Error", ex);
			ApplicationController.addErrorMessage(model, ex.getMessage());
			return addClaim(model);
		}
		return viewClaims(model);
	}
	
	@RequestMapping(value = "api/get", method = RequestMethod.GET)
	public @ResponseBody List<Claim> getClaims() {
		List<Claim> claims = claimService.getAll();
		return claims;
	}
	
	@RequestMapping(value = "api/get/{username}", method = RequestMethod.GET)
	public @ResponseBody
	List<Claim> getClaims(@PathVariable("username") String username) {
		Beneficiary beneficiary = beneficiaryService.getClientByUsername(username);
		List<Claim> claims = claimService.getClaimByBeneficiary(beneficiary);
		return claims;
	}

}
