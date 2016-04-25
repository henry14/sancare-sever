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

import za.co.sanlam.model.Hospital;
import za.co.sanlam.model.Town;
import za.co.sanlam.model.User;
import za.co.sanlam.security.util.SancareSecurityUtil;
import za.co.sanlam.server.service.HospitalService;
import za.co.sanlam.server.service.TownService;

/**
 * @author henry14
 *
 */
@Controller
@RequestMapping(value="hospital")
public class HospitalController {

	@Autowired
	private TownService townService;
	@Autowired
	private HospitalService hospitalService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private static final String DISPLAY_NAME = "Hospital";

	@RequestMapping("view/{townId}")
	public ModelAndView hospitals(@PathVariable("townId") String townId, ModelMap model){
		Town town = townService.getById(townId);
		Hospital hospital = new Hospital();
		List<Hospital> hospitals = hospitalService.getHospitalsByTown(town);
		
		model.addAttribute("town", town);
		model.addAttribute("hospital", hospital);
		model.addAttribute("hospitals", hospitals);
		return new ModelAndView("hospitalView", model);
	}
	
	@RequestMapping("add/{townId}")
	public ModelAndView addHospital(@PathVariable("townId") String townId, ModelMap model){
			Town town = townService.getById(townId);
			Hospital hospital = new Hospital(town);
			model.put("hospital", hospital);
			model.put("town", town);
		
		return new ModelAndView("hospitalAdd", model);
	}
	
	@RequestMapping("edit/{id}")
	public ModelAndView editActivity(@PathVariable("id") String id, ModelMap modelMap){
		Hospital hospital = hospitalService.getById(id);
		if(hospital != null){
			modelMap.put("hospital", hospital);
			
			return new ModelAndView("hospitalAdd", modelMap);
		}
		
		return new ModelAndView("hospitalAdd");//, model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "delete/{townId}/{hospitalIds}")
	public ModelAndView delete(@PathVariable("townId") String townId, 
			@PathVariable("hospitalIds") String hospitalIds, ModelMap modelMap) {
		String[] idzToDelete = hospitalIds.split(",");
		try {
			hospitalService.deleteByIds(idzToDelete);

		} catch (Exception e) {
			/*log.error("Error", e);

			modelMap.put(WebConstants.MODEL_ATTRIBUTE_ERROR_MESSAGE,
					e.getMessage());*/
		}
		return hospitals(townId, modelMap);
	}
	
	@RequestMapping("save")
	public ModelAndView save(@ModelAttribute("hospital") Hospital hospital, ModelMap model){
		Hospital existing = hospital;
		
		try{
			User user = SancareSecurityUtil.getLoggedInUser();
//			hospitalService.validate(existing);
			if(StringUtils.isNotEmpty(existing.getId())){
				existing.setCreatedBy(hospitalService.getCreatedBy(existing.getId()));
				existing.setCreatedDate(hospitalService.getCreatedDate(existing.getId()));
				existing.setLastModifiedBy(user);
			}
			else{
				existing.setId(null);
				existing.setCreatedBy(user);
			}
			hospitalService.validate(existing);
			hospitalService.save(existing);
			
			model.put(WebConstants.SYSTEM_MESSAGE, DISPLAY_NAME+" saved successfully");
			
		} catch (Exception ex){
			log.error("Error", ex);
			ApplicationController.addErrorMessage(model, ex.getMessage());
			
			return addHospital(existing.getTown().getId(), model);
			
		}
		return hospitals(existing.getTown().getId(), model);
	}

}
