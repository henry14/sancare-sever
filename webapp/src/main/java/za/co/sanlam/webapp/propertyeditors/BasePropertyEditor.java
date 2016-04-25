package za.co.sanlam.webapp.propertyeditors;

import java.beans.PropertyEditorSupport;

import za.co.sanlam.model.BaseData;

/**
 * @author henry14
 *
 */
public class BasePropertyEditor extends PropertyEditorSupport {
	
	@Override
	public String getAsText() {
		if (super.getValue() != null && super.getValue() instanceof BaseData) {
			return ((BaseData) super.getValue()).getId();
		}

		return super.getAsText();
	}

}
