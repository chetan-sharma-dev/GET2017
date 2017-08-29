package com.metacube.entity;

public class College extends BaseEntity {
	private int availableSeats;
	private int totalSeats;
	
	
	public College(String id, String name, int rank,int totalSeats){
		this.setId(id);
		this.setName(name);
		this.setRank(rank);
		this.setTotalSeats(totalSeats);
		this.setAvailableSeats(totalSeats);
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	public String toString(){
		return this.getId()+"\t\t\t"+this.getName()+"\t\t"+this.getRank()+"\t\t"+this.getAvailableSeats()+"\t\t"+this.getTotalSeats();
	}
	

}
