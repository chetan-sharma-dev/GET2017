package com.metacube.shoppingcart.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;
    
    /** The name. */
	@Column(name="name")
    private String name;
    
    /** The price. */
	@Column(name="price")
    private double price;

   

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return Id;
    }

    /**
     * Sets the id.
     *
     * @param Id the new id
     */
    public void setId(final int Id) {
        this.Id = Id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

 
}
