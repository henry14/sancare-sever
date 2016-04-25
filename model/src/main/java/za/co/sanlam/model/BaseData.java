package za.co.sanlam.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author henry14
 * 
 */
@MappedSuperclass
public class BaseData implements Serializable {

	private static final long serialVersionUID = 5352195704396282202L;

	private String id = null;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEmptyIdNull() {
		if (StringUtils.isEmpty(this.getId()))
			this.setId(null);

	}

	public Boolean idIsBlankOrEmpty() {
		if (StringUtils.isEmpty(this.getId())
				|| StringUtils.isBlank(this.getId()))
			return true;

		return false;
	}

	public Boolean idIsNOTBlankOrEmpty() {
		return !idIsBlankOrEmpty();
	}

}
