package com.metacube.get.layarch.dao;

import java.io.Serializable;

/**
 * @interface
 * Abstruct Dao interface for dao 
 * */
public interface AbstractDao<T, ID extends Serializable>
{
	<S extends T> S save(S entity);
	T findOne(ID primaryKey);
	Iterable<T> findAll();
	Long count();
	void delete(T entity);
	boolean exists(ID primaryKey);
}
