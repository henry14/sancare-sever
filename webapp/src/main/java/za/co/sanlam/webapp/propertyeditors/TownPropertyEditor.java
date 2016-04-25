package za.co.sanlam.webapp.propertyeditors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.sanlam.model.Town;
import za.co.sanlam.server.service.TownService;


/**
 * @author henry14
 *
 */
@Component("townPropertyEditor")
public class TownPropertyEditor extends BasePropertyEditor {
	
	@Autowired
	private TownService townService;
	
	@Override
	public String getAsText() {
		if (super.getValue() != null && super.getValue() instanceof Town) {
			return ((Town) super.getValue()).getId();
		}

		return super.getAsText();
	}

	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.isNotBlank(text) && StringUtils.isNotEmpty(text)) {
			if (StringUtils.equalsIgnoreCase("none", text)) {
				super.setValue(null);
			} else {
				super.setValue(townService.getById(text));
			}
		} else {
			super.setAsText(text);
		}
	}

}
