package dao;

import java.util.List;

import model.BaseEntity;
/**
 * Generic Interface for all DaoClasses which extends BaseEntity
 * */
public interface BaseDao <T extends BaseEntity>{

	void create(T t);
	void update(T t);
	void delete(T t);
	List<T> getAll();
}