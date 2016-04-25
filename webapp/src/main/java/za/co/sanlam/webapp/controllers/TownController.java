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

import za.co.sanlam.model.Town;
import za.co.sanlam.model.User;
import za.co.sanlam.security.util.SancareSecurityUtil;
import za.co.sanlam.server.service.TownService;

@Controller
@RequestMapping("town")
public class TownController {
	
	@Autowired
	private TownService townService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private static final String DISPLAY_NAME = "Town";
	
	@RequestMapping(value = "view")
	public ModelAndView viewTowns(ModelMap modelMap) {
		Town town = new Town();
		List<Town> towns = townService.getAll();
		modelMap.put("town", town);
		modelMap.put("towns", towns);
		return new ModelAndView("townView", modelMap);
	}
	
	@RequestMapping(value = "add")
	public ModelAndView addTown(ModelMap modelMap) {
		Town town = new Town();
		modelMap.put("town", town);
		return new ModelAndView("townAdd");
	}
	
	@RequestMapping("edit/{townId}")
	public ModelAndView editTown(@PathVariable("townId") String townId, ModelMap modelMap){
		Town town = townService.getById(townId);
		if(town != null){
			modelMap.put("town", town);
			
			return new ModelAndView("townAdd", modelMap);
		}
		
		return new ModelAndView("townAdd");//, model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "delete/{townIds}")
	public ModelAndView delete(	@PathVariable("townIds") String townIds, 
			ModelMap modelMap) {
		String[] idzToDelete = townIds.split(",");
		try {
			townService.deleteByIds(idzToDelete);

		} catch (Exception e) {
			/*log.error("Error", e);

			modelMap.put(WebConstants.MODEL_ATTRIBUTE_ERROR_MESSAGE,
					e.getMessage());*/
		}
		return viewTowns(modelMap);
	}
	
	@RequestMapping("save")
	public ModelAndView save(@ModelAttribute("town") Town town, ModelMap model){
		Town exisiting = town;
		
		try{
			User user = SancareSecurityUtil.getLoggedInUser();
			if(StringUtils.isNotEmpty(exisiting.getId())){
				exisiting.setCreatedBy(townService.getCreatedBy(exisiting.getId()));
				exisiting.setCreatedDate(townService.getCreatedDate(exisiting.getId()));
				exisiting.setLastModifiedBy(user);
			} else{
				exisiting.setId(null);
				exisiting.setCreatedBy(user);
//				sendJson();
			}
			
			townService.validate(exisiting);
			townService.save(exisiting);
			model.put(WebConstants.SYSTEM_MESSAGE, DISPLAY_NAME+" saved successfully");
			
		} catch (Exception ex){
			log.error("Error", ex);
			ApplicationController.addErrorMessage(model, ex.getMessage());
			return addTown(model);
			
		}
		return viewTowns(model);
	}
	
	@RequestMapping(value = "api/get", method = RequestMethod.GET)
	public @ResponseBody List<Town> getTowns() {
		List<Town> towns = townService.getAll();
		return towns;
	}	

}
