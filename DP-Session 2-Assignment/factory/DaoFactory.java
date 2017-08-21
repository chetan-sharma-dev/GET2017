package factory;

import dao.BaseDao;
import dao.InMemoryProductDao;
import enums.DBType;
import enums.EntityName;
/**
 * @class
 * factory class for getting Object of Dao
 * */
public class DaoFactory {
	/**
	 * @method getDaoforEntity()
	 * returning object of dao of Base DaoType 
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
