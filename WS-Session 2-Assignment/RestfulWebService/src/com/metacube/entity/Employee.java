
package com.metacube.entity;

import java.util.Objects;



/**
 * The Class Employee.
 * 
 * Employee Bean
 */
public class Employee implements BaseEntity{


	/** The Id. */
	private String id;

	/** The name. */
	private String name;


	/** The age. */
	private int age;

	/**
	 * Instantiates a new employee.
	 */
	public Employee() {

	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param Id the new id
	 */
	public void setId(String id) {
		this.id = id;
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
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**Use to print Employee in string forma
	 * @return t**/
	@Override
	public String toString() {
		return  "\t"+ id+ "\t\t\t"  + name + "\t\t\t"  + age;
	}

	/**For checking the equality of objects
	 * @param obj
	 * @return t**/
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Employee other = (Employee) obj;
		
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		
		return true;
	}

}
