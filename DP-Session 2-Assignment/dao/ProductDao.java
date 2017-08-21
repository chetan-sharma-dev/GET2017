package dao;

import model.Product;
/**
 * @interface ProductDao
 * 	interface for ProductDao 
 * */
public interface ProductDao extends BaseDao<Product> {
	Product getProductObjectByProductCode(String productCode);
}
