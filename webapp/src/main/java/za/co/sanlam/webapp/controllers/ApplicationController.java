package za.co.sanlam.webapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import za.co.sanlam.model.BaseData;

/**
 * @author henry14
 *
 */
@Controller
public class ApplicationController {
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView mainPanel(){
		return new ModelAndView("mainPanel");
	}
	
	@RequestMapping(value = "/ServiceLogin", method = RequestMethod.GET)
	public String loginHandler(HttpServletRequest request, Model model){
		String referer = request.getHeader("Referer");
		request.getSession().setAttribute("url_prior_login", referer);
		return "loginPage";
	}
	
	@RequestMapping("ServiceLoginFailure")
	public ModelAndView loginFailureHander(ModelMap model) {
		model.put("errorMessage", "Wrong username | password.");
		return new ModelAndView("loginPage", model);
	}
	
	@RequestMapping("ServiceLogout")
	public ModelAndView logout(){
		return new ModelAndView("loginPage");
	}
	
	public static void addErrorMessage(ModelMap modelMap, String str) {
        modelMap.put(WebConstants.ERROR_MESSAGE, str);
    }

    public static void addLongResponseMessage(ModelMap modelMap, String str) {
        modelMap.put(WebConstants.LONG_RESPONSE_TEXT, str);
    }

    public static void logExceptionAndAddErrorMessage(ModelMap modelMap, Exception e) {
        modelMap.put(WebConstants.ERROR_MESSAGE, e.getMessage());
    }
    
    public static void checkAndThrowIdNotFoundException(String objectName, BaseData object) throws Exception {
        if (object == null) {
            throw new Exception(objectName + " with given id not found in database");
        }
    }

}
