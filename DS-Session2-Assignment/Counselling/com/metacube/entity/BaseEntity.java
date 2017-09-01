package com.metacube.entity;
/**
 *@class abstract class for entities 
 */

public abstract class BaseEntity {
	private String name;
	private String id;
	private int rank;
	/**
	 * all getter and setter methods 
	 * */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	
}
