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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import za.co.sanlam.model.Scheme;
import za.co.sanlam.model.User;
import za.co.sanlam.security.util.SancareSecurityUtil;
import za.co.sanlam.server.service.SchemeService;

/**
 * @author henry14
 * 
 */
@Controller
@RequestMapping(value="policy")
public class PolicyController {
	
	@Autowired
	private SchemeService schemeService;
	
	@RequestMapping(value = "view")
	public ModelAndView viewSchemes(ModelMap modelMap) {
		Scheme scheme = new Scheme();
		List<Scheme> schemes = schemeService.getAll();
		modelMap.put("scheme", scheme);
		modelMap.put("schemes", schemes);
		return new ModelAndView("schemeView", modelMap);
	}
	
	@RequestMapping(value = "add")
	public ModelAndView addScheme(ModelMap modelMap) {
		Scheme scheme = new Scheme();
		modelMap.put("scheme", scheme);
		return new ModelAndView("schemeAdd");
	}
	
	@RequestMapping("edit/{schemeId}")
	public ModelAndView editScheme(@PathVariable("schemeId") String schemeId, ModelMap modelMap){
		Scheme scheme = schemeService.getById(schemeId);
		if(scheme != null){
			modelMap.put("scheme", scheme);
			
			return new ModelAndView("schemeAdd", modelMap);
		}
		
		return new ModelAndView("schemeAdd");//, model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "delete/{schemeIds}")
	public ModelAndView delete(	@PathVariable("schemeIds") String schemeIds, 
			ModelMap modelMap) {
		String[] idzToDelete = schemeIds.split(",");
		try {
			schemeService.deleteByIds(idzToDelete);

		} catch (Exception e) {
			/*log.error("Error", e);

			modelMap.put(WebConstants.MODEL_ATTRIBUTE_ERROR_MESSAGE,
					e.getMessage());*/
		}
		return viewSchemes(modelMap);
	}
	
	@RequestMapping("save")
	public ModelAndView save(@ModelAttribute("scheme") Scheme scheme, ModelMap model){
		
		try{
			User user = SancareSecurityUtil.getLoggedInUser();
//			schemeService.validate(scheme);
			Scheme exisiting = scheme;
			
			if(StringUtils.isNotEmpty(scheme.getId())){
				scheme.setCreatedBy(schemeService.getCreatedBy(scheme.getId()));
				scheme.setCreatedDate(schemeService.getCreatedDate(scheme.getId()));
				scheme.setLastModifiedBy(user);
				schemeService.save(scheme);
			}
			else{
				exisiting.setId(null);
				exisiting.setCreatedBy(user);
				schemeService.save(exisiting);
			}
		} catch (Exception ex){
			
		}
		return viewSchemes(model);
	}
	
	@RequestMapping(value = "api/get", method = RequestMethod.GET)
	public @ResponseBody List<Scheme> getSchemes() {
		List<Scheme> schemes = schemeService.getAll();
		return schemes;
	}

}
