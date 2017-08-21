package com.metacube.dao;

import com.metacube.enums.DBType;
import com.metacube.enums.EntityName;
/**
 * Dao Factory is used to get Object of Dao
 * */
public class DaoFactory {
	/**
	 * @method getDaoforEntity(EntityName entityName, DBType dBType)
	 * this method gives object of dedicated class
	 * */
	public static  BaseDao<?> getDaoforEntity(EntityName entityName, DBType dBType) {
		if(entityName == EntityName.Product) {
			if(dBType == DBType.InMemory) {
				 return InMemoryProductDao.getInstance();
				
			} 
		} 
		return null;
	}
}