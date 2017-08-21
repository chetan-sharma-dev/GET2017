package model;
/**
 * @class
 * class for holding product details 
 * */
public class Product extends BaseEntity {
	private String productCode;
	private String productName;
	private Double productCost;
	
	public Product() {
		
	}
	
	public Product(String ProductCode,String productName,Double productCost){
		this.productCode=ProductCode;
		this.productName=productName;
		this.productCost=productCost;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String ProductCode) {
		this.productCode = ProductCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductCost() {
		return productCost;
	}

	public void setProductCost(Double productCost) {
		this.productCost = productCost;
	}
	@Override
	public String toString() {
		
		return productCode+" "+productName+" "+productCost;
	}
		
	
}
