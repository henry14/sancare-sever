package za.co.sanlam.webapp.propertyeditors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.sanlam.model.Activity;
import za.co.sanlam.server.service.ActivityService;

/**
 * @author henry14
 *
 */
@Component("activityPropertyEditor")
public class ActivityPropertyEditor extends BasePropertyEditor {
	
	@Autowired
	private ActivityService activityService;
	
	@Override
	public String getAsText() {
		if (super.getValue() != null && super.getValue() instanceof Activity) {
			return ((Activity) super.getValue()).getId();
		}

		return super.getAsText();
	}

	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.isNotBlank(text) && StringUtils.isNotEmpty(text)) {
			if (StringUtils.equalsIgnoreCase("none", text)) {
				super.setValue(null);
			} else {
				super.setValue(activityService.getById(text));
			}
		} else {
			super.setAsText(text);
		}
	}
}
