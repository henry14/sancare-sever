package za.co.sanlam.server.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import za.co.sanlam.model.BaseData;
import za.co.sanlam.server.dao.BaseDAO;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;

/**
 * @author henry14
 * @param <T>
 * 
 */
public abstract class BaseDAOImpl<T> extends GenericDAOImpl<T, String>
		implements BaseDAO<T> {

	protected EntityManager entityManager;

	@PersistenceContext
	@Override
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		this.entityManager = entityManager;
	}

	@Autowired
	@Override
	public void setSearchProcessor(JPASearchProcessor searchProcessor) {
		super.setSearchProcessor(searchProcessor);
	}

	@Override
	public List<T> searchByPropertyEqual(String property, Object value) {
		Search search = new Search();
		search.addFilterEqual(property, value);
		return search(search);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T searchUniqueByPropertyEqual(String property, Object value) {
		Search search = new Search();
		search.addFilterEqual(property, value);
		return (T) searchUnique(search);
	}

	@Override
	public void delete(T entity) {
		if (entity != null)
			super.save(entity);

	}

	@Override
	public void update(T entity) {
		super.save(entity);

	}

	@Override
	public void add(T entity) {
		super.save(entity);

	}

	@Override
	public T save(T entity) {
		if (entity == null) {
			return null;
		}

		if (entity instanceof BaseData) {
			if (StringUtils.isBlank(((BaseData) entity).getId())) {
				((BaseData) entity).setId(null);
			}
		}

		return super.save(entity);
	}

	@Override
	public void flush() {
		super.flush();
	}

}
