package za.co.sanlam.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("error")
public class ErrorController {

	@RequestMapping(method = RequestMethod.GET, value = "404")
	public ModelAndView handler404(ModelMap modelMap) {
		modelMap.put(WebConstants.ERROR_MESSAGE,
				"This Path does not Exit on the system");
		return new ModelAndView("home", modelMap);

	}

	@RequestMapping(method = RequestMethod.POST, value = "404")
	public ModelAndView handler404Post(ModelMap modelMap) {
		modelMap.put(WebConstants.ERROR_MESSAGE,
				"This Path does not Exit on the system");
		return new ModelAndView("home", modelMap);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/405")
	public ModelAndView handler405(ModelMap modelMap) {
		modelMap.put(WebConstants.ERROR_MESSAGE,
				"This Path requires post-data to process!. "
						+ "HTTP ERROR: 405, Request method 'GET' not supported");
		return new ModelAndView("home", modelMap);

	}

	@RequestMapping(method = RequestMethod.GET, value = "accessDenied")
	public ModelAndView handlerAcessDenied(ModelMap modelMap) {
		if (!modelMap
				.containsAttribute(WebConstants.ERROR_MESSAGE))
			modelMap.put(WebConstants.ERROR_MESSAGE,
					"You don't have sufficient rights to access this resource.");
		return new ModelAndView("errorPage", modelMap);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/custom")
	public ModelAndView error(ModelMap modelMap, String error) {
		modelMap.put(WebConstants.ERROR_MESSAGE, error);
		return new ModelAndView("home", modelMap);

	}
}

