package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;

public abstract class GenericHibernateDao<T, ID extends Serializable> implements AbstractDao<T, ID> {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Class<T> modelClass;

	public Class<T> getModelClass() {
		return modelClass;
	}

	public GenericHibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	@Override
	public <S extends T> Status save(final S entity) {
		Status result = Status.Success;
		try {
			Session session = this.sessionFactory.getCurrentSession();

			/* saving the product */
			session.save(entity);
			System.out.println("Inserted Successfully");

		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	@Override
	public T findOne(ID primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass()).add(Restrictions.eq("id", primaryKey));
		Product product = (Product) cr.uniqueResult();
		return (T) product;
	}

	@Override
	public Iterable<T> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		List<T> personsList = cr.list();
		return personsList;
	}

	@Override
	public Status delete(final ID primaryKey) {
		Status result = Status.Success;
		try {

			// getting transaction object from session object
			Session session = this.sessionFactory.getCurrentSession();

			/* loading the object using session */
			Product product = (Product) session.get(Product.class, primaryKey);

			/* deleting the object */
			session.delete(product);

		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	@Override
	public <S extends T> Status edit(S entity, ID primaryKey) {
		// TODO Auto-generated method stub
		Status result = Status.Added;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			// session.beginTransaction();

			/* casting the entity into product */
			Product update = (Product) entity;

			/* loading the object using session */
			Product product = (Product) session.get(Product.class, primaryKey);

			/* updating the values */
			product.setName(update.getName());
			product.setPrice(update.getPrice());
			session.update(product);

		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

}
