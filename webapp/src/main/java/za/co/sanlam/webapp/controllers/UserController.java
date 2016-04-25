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

import za.co.sanlam.model.User;
import za.co.sanlam.security.util.SancareSecurityUtil;
import za.co.sanlam.server.service.RoleService;
import za.co.sanlam.server.service.UserService;

@Controller
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	private static final String DISPLAY_NAME = "User";
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "view")
	public ModelAndView viewUsers(ModelMap modelMap) {
		User user = new User();
		List<User> users = userService.getAll();
		modelMap.put("user", user);
		modelMap.put("users", users);
		return new ModelAndView("userView", modelMap);
	}
	
	@RequestMapping(value = "add")
	public ModelAndView addUser(ModelMap modelMap) {
		User user = new User();
		modelMap.put("user", user);		
		modelMap.put("roles", roleService.getAll());
		return new ModelAndView("userAdd");
	}
	
	@RequestMapping("edit/{userId}")
	public ModelAndView editUser(@PathVariable("userId") String userId, ModelMap modelMap){
		User user = userService.getById(userId);
		
		if(user != null){
			user.setPassword("");
			modelMap.put("roles", roleService.getAll());
			modelMap.put("user", user);
			
			return new ModelAndView("userAdd", modelMap);
		}
		
		return new ModelAndView("userAdd");//, model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "delete/{userIds}")
	public ModelAndView delete(	@PathVariable("userIds") String userIds, 
			ModelMap modelMap) {
		String[] idzToDelete = userIds.split(",");
		try {
			userService.deleteByIds(idzToDelete);

		} catch (Exception e) {
			/*log.error("Error", e);

			modelMap.put(WebConstants.MODEL_ATTRIBUTE_ERROR_MESSAGE,
					e.getMessage());*/
		}
		return viewUsers(modelMap);
	}
	
	@RequestMapping("save")
	public ModelAndView save(@ModelAttribute("user") User user, ModelMap model){
		User exisiting = user;
		String hashedPassword = SancareSecurityUtil.encodeString(exisiting.getPassword()
				+ exisiting.getSalt());
		exisiting.setPassword(hashedPassword);
		try{
			if(StringUtils.isNotEmpty(user.getId())){
				
			}
			else{
				user.setId(null);
			}
			userService.validate(exisiting);
			userService.save(exisiting);
			model.put(WebConstants.SYSTEM_MESSAGE, DISPLAY_NAME+" saved successfully");
			
		} catch (Exception ex){
			log.error("Error", ex);
			ApplicationController.addErrorMessage(model, ex.getMessage());
			
			return addUser(model);
			
		}
		return viewUsers(model);
	}
	
}
