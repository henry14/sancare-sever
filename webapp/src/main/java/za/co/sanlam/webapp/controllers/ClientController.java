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

import za.co.sanlam.model.Client;
import za.co.sanlam.model.User;
import za.co.sanlam.security.util.SancareSecurityUtil;
import za.co.sanlam.server.service.ClientService;

@Controller
@RequestMapping("client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private static final String DISPLAY_NAME = "Client";
	
	@RequestMapping(value = "view")
	public ModelAndView viewClients(ModelMap modelMap) {
		Client client = new Client();
		List<Client> clients = clientService.getAll();
		modelMap.put("client", client);
		modelMap.put("clients", clients);
		return new ModelAndView("clientView", modelMap);
	}
	
	@RequestMapping(value = "add")
	public ModelAndView addClient(ModelMap modelMap) {
		Client client = new Client();
		modelMap.put("client", client);
		return new ModelAndView("clientAdd");
	}
	
	@RequestMapping("edit/{clientId}")
	public ModelAndView editClient(@PathVariable("clientId") String clientId, ModelMap modelMap){
		Client client = clientService.getById(clientId);
		if(client != null){
			modelMap.put("client", client);
			
			return new ModelAndView("clientAdd", modelMap);
		}
		
		return new ModelAndView("clientAdd");//, model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "delete/{clientIds}")
	public ModelAndView delete(	@PathVariable("clientIds") String clientIds, 
			ModelMap modelMap) {
		String[] idzToDelete = clientIds.split(",");
		try {
			clientService.deleteByIds(idzToDelete);

		} catch (Exception e) {
			/*log.error("Error", e);

			modelMap.put(WebConfstants.MODEL_ATTRIBUTE_ERROR_MESSAGE,
					e.getMessage());*/
		}
		return viewClients(modelMap);
	}
	
	@RequestMapping("save")
	public ModelAndView save(@ModelAttribute("client") Client client, ModelMap model){
		Client existing = client;
		
		try{
			User user = SancareSecurityUtil.getLoggedInUser();
			if(StringUtils.isNotEmpty(existing.getId())){
				existing.setCreatedBy(clientService.getCreatedBy(existing.getId()));
				existing.setCreatedDate(clientService.getCreatedDate(existing.getId()));
				existing.setLastModifiedBy(user);
			} else{
				existing.setId(null);
				existing.setCreatedBy(user);
//				sendJson();
			}
			
			clientService.validate(existing);
			clientService.save(existing);
			model.put(WebConstants.SYSTEM_MESSAGE, DISPLAY_NAME+" saved successfully");
			
		} catch (Exception ex){
			log.error("Error", ex);
			ApplicationController.addErrorMessage(model, ex.getMessage());
			
			return addClient(model);
		}
		return viewClients(model);
	}

}
