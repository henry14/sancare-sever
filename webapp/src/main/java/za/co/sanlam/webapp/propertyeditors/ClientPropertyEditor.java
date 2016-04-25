package za.co.sanlam.webapp.propertyeditors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.sanlam.model.Client;
import za.co.sanlam.server.service.ClientService;

@Component("clientPropertyEditor")
public class ClientPropertyEditor extends BasePropertyEditor {
	
	@Autowired
	private ClientService clientService;
	
	@Override
	public String getAsText() {
		if (super.getValue() != null && super.getValue() instanceof Client) {
			return ((Client) super.getValue()).getId();
		}

		return super.getAsText();
	}

	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.isNotBlank(text) && StringUtils.isNotEmpty(text)) {
			if (StringUtils.equalsIgnoreCase("none", text)) {
				super.setValue(null);
			} else {
				super.setValue(clientService.getById(text));
			}
		} else {
			super.setAsText(text);
		}
	}

}
