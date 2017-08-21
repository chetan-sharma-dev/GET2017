package com.metacube.dao;

import java.util.List;

import com.metacube.model.BaseEntity;

/**
 * BaseDao interface for all general Dao operations
 * */
public interface BaseDao <T extends BaseEntity>{

	String addNew(String id,T t);
	String update(String id,T t);
	String delete(String id);
	List<T> getAllProductsList();
}
