package za.co.sanlam.webapp.propertyeditors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.sanlam.model.User;
import za.co.sanlam.server.service.UserService;

@Component("userPropertyEditor")
public class UserPropertyEditor extends BasePropertyEditor{
	
	@Autowired
	private UserService userService;
	
	@Override
	public String getAsText() {
		if (super.getValue() != null && super.getValue() instanceof User) {
			return ((User) super.getValue()).getId();
		}

		return super.getAsText();
	}

	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.isNotBlank(text) && StringUtils.isNotEmpty(text)) {
			if (StringUtils.equalsIgnoreCase("none", text)) {
				super.setValue(null);
			} else {
				super.setValue(userService.getById(text));
			}
		} else {
			super.setAsText(text);
		}
	}

}
