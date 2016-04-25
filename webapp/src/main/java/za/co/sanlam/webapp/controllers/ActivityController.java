package za.co.sanlam.webapp.controllers;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import za.co.sanlam.model.Activity;
import za.co.sanlam.model.Hospital;
import za.co.sanlam.server.service.ActivityService;
import za.co.sanlam.server.service.HospitalService;

/**
 * @author henry14
 * 
 */
@Controller
@RequestMapping(value = "service")
public class ActivityController {

	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private ActivityService activityService;

	@RequestMapping("view/{hospitalId}")
	public ModelAndView activitys(@PathVariable("hospitalId") String hospitalId, ModelMap model){
		Hospital hospital = hospitalService.getById(hospitalId);
		Activity activity = new Activity();
		List<Activity> activities = activityService.getActivitysByHospital(hospital);
		
		model.addAttribute("hospital", hospital);
		model.addAttribute("activity", activity);
		model.addAttribute("activitys", activities);
		return new ModelAndView("activityView", model);
	}
	
	@RequestMapping("add/{hospitalId}")
	public ModelAndView addActivity(@PathVariable("hospitalId") String hospitalId, ModelMap model){
			Hospital hospital = hospitalService.getById(hospitalId);
			Activity activity = new Activity(hospital);
			model.put("activity", activity);
			model.put("hospital", hospital);
		
		return new ModelAndView("activityAdd", model);
	}
	
	@RequestMapping("edit/{id}")
	public ModelAndView editActivity(@PathVariable("id") String id, ModelMap modelMap){
		Activity activity = activityService.getById(id);
		if(activity != null){
			modelMap.put("activity", activity);
			
			return new ModelAndView("activityAdd", modelMap);
		}
		
		return new ModelAndView("activityAdd");//, model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "delete/{hospitalId}/{activityIds}")
	public ModelAndView delete(@PathVariable("hospitalId") String hospitalId, 
			@PathVariable("activityIds") String activityIds, ModelMap modelMap) {
		String[] idzToDelete = activityIds.split(",");
		try {
			activityService.deleteByIds(idzToDelete);

		} catch (Exception e) {
			/*log.error("Error", e);

			modelMap.put(WebConstants.MODEL_ATTRIBUTE_ERROR_MESSAGE,
					e.getMessage());*/
		}
		return activitys(hospitalId, modelMap);
	}
	
	@RequestMapping("save")
	public ModelAndView save(@ModelAttribute("activity") Activity activity, ModelMap model){
		Activity existing = activity;
		
		try{
//			activityService.validate(existing);
			if(StringUtils.isNotEmpty(activity.getId()))
				activityService.save(activity);
			else{
				activity.setId(null);
			}
			activityService.save(existing);
		} catch (Exception ex){
			return new ModelAndView("activityAdd");
		}
		return activitys(activity.getHospital().getId(), model);
	}

}
