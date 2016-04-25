package za.co.sanlam.webapp.propertyeditors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.sanlam.model.Beneficiary;
import za.co.sanlam.server.service.BeneficiaryService;


/**
 * @author henry14
 *
 */
@Component("benefiaryPropertyEditor")
public class BeneficiaryPropertyEditor extends BasePropertyEditor {
	
	@Autowired
	private BeneficiaryService benefiaryService;
	
	@Override
	public String getAsText() {
		if (super.getValue() != null && super.getValue() instanceof Beneficiary) {
			return ((Beneficiary) super.getValue()).getId();
		}

		return super.getAsText();
	}

	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.isNotBlank(text) && StringUtils.isNotEmpty(text)) {
			if (StringUtils.equalsIgnoreCase("none", text)) {
				super.setValue(null);
			} else {
				super.setValue(benefiaryService.getById(text));
			}
		} else {
			super.setAsText(text);
		}
	}

}
