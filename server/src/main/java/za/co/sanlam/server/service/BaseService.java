package za.co.sanlam.server.service;

import java.util.List;

import za.co.sanlam.model.exception.ValidationException;

/**
 * @author henry14
 * 
 */
public interface BaseService<ModelObject> {

	void save(ModelObject t);

	// void validate(ModelObject t) throws ValidationException
	// Create validationException
	ModelObject getById(String id);

	List<ModelObject> getAll();

	void deleteByIds(String[] ids);

	void validate(ModelObject obj) throws ValidationException;

}
