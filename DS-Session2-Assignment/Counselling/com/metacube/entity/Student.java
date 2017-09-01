package com.metacube.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @class 
 * class holding student details extending Base Entity
 * implementing Comparable Interface for defining comparing to method 
 * */

public class Student extends BaseEntity implements Comparable{
	private List<String> filledCoices;
	private College allotedCollege;

	public Student(String id, String name, int rank) {
		this.setId(id);
		this.setName(name);
		this.setRank(rank);
		filledCoices = new ArrayList<String>();
		allotedCollege = null;
	}

	public List<String> getFilledCoices() {
		return filledCoices;
	}

	public void setFilledCoices(List<String> filledCoices) {
		this.filledCoices = filledCoices;
	}

	public College getAllotedCollege() {
		return allotedCollege;
	}

	public void setAllotedCollege(College allotedCollege) {
		this.allotedCollege = allotedCollege;
	}

	public String toString(){
		String allotmentStringToPrint;
		if(allotedCollege!=null){
			allotmentStringToPrint=allotedCollege.getName();
		}else{
			allotmentStringToPrint="No College Alloted";
		}
		return this.getId()+"\t\t"+this.getName()+"\t\t"+this.getRank()+"\t\t  "+this.filledCoices.toString()+"\t\t\t\t"+allotmentStringToPrint;
		
	}

	@Override
	public int compareTo(Object obj) {		
		Student secondObject=(Student)obj;
		return this.getRank()-secondObject.getRank();
	}
}
