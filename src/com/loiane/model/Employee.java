package com.loiane.model;

/**
 * Employee POJO
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public abstract class Employee {

	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Employee ID = ").append(id);
		sb.append(" Name = ").append(name);
		return sb.toString();
	}
}
