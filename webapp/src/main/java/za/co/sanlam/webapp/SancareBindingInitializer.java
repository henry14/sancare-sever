package za.co.sanlam.webapp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import za.co.sanlam.model.Client;
import za.co.sanlam.model.Role;
import za.co.sanlam.model.Town;
import za.co.sanlam.model.User;
import za.co.sanlam.webapp.propertyeditors.ClientPropertyEditor;
import za.co.sanlam.webapp.propertyeditors.DatePropertyEditor;
import za.co.sanlam.webapp.propertyeditors.RolePropertyEditor;
//import za.co.sanlam.webapp.propertyeditors.ClientPropertyEditor;
/*import za.co.sanlam.webapp.propertyeditors.ActivityPropertyEditor;
import za.co.sanlam.webapp.propertyeditors.ClientPropertyEditor;*/
import za.co.sanlam.webapp.propertyeditors.TownPropertyEditor;
import za.co.sanlam.webapp.propertyeditors.UserPropertyEditor;
//import za.co.sanlam.model.MobileClient;
/*import za.co.sanlam.model.Activity;
import za.co.sanlam.model.MobileClient;*/

public class SancareBindingInitializer implements WebBindingInitializer{
	
	@Autowired
	private RolePropertyEditor rolePropertyEditor;
	
	@Autowired
	private UserPropertyEditor userPropertyEditor;
	@Autowired
	private TownPropertyEditor townPropertyEditor;
	@Autowired
	private ClientPropertyEditor clientPropertyEditor;
	/*@Autowired
	private ActivityPropertyEditor activityPropertyEditor;*/
	/*@Autowired
	private ClientPropertyEditor clientPropertyEditor;*/

	/* (non-Javadoc)
	 * @see org.springframework.web.bind.support.WebBindingInitializer#initBinder(org.springframework.web.bind.WebDataBinder, org.springframework.web.context.request.WebRequest)
	 */
	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		//binder.registerCustomEditor(Date, propertyEditor)
		binder.registerCustomEditor(Role.class, rolePropertyEditor);
		binder.registerCustomEditor(User.class, userPropertyEditor);
		binder.registerCustomEditor(Town.class, townPropertyEditor);
		binder.registerCustomEditor(Client.class, clientPropertyEditor);
		binder.registerCustomEditor(Date.class, new DatePropertyEditor(new SimpleDateFormat("yyyy-mm-dd")));
//		binder.registerCustomEditor(Activity.class, activityPropertyEditor);
//		binder.registerCustomEditor(MobileClient.class, clientPropertyEditor);
		
	}
	
}