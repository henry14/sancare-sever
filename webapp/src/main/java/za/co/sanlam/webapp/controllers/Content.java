package za.co.sanlam.webapp.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author henry14
 *
 */
public class Content implements Serializable {

	 private static final long serialVersionUID = 4306931093789012238L;
	List<String> registration_ids;
	private Map<String, String> data;

	public void addRegId(String regId) {
		if (registration_ids == null)
			registration_ids = new LinkedList<String>();
		registration_ids.add(regId);
	}

	public void createDate(String operation, String name) {
		if (data == null)
			data = new HashMap<String, String>();
		
		data.put("operation", operation);
		data.put("notification_key_name", name);
	}

	public List<String> getRegistration_ids() {
		return registration_ids;
	}

	public void setRegistration_ids(List<String> registration_ids) {
		this.registration_ids = registration_ids;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}
}
