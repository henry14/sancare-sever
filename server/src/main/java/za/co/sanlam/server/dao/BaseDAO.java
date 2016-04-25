package za.co.sanlam.server.dao;

import java.util.List;

import com.googlecode.genericdao.dao.jpa.GenericDAO;

/**
 * @author henry14
 * 
 */
public interface BaseDAO<T> extends GenericDAO<T, String> {

	void add(T entity);

	void update(T entity);

	void delete(T entity);

	List<T> searchByPropertyEqual(String property, Object value);

	T searchUniqueByPropertyEqual(String property, Object value);
}
