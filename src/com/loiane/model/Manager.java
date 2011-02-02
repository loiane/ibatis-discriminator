package com.loiane.model;

/**
 * Manager POJO
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class Manager extends Employee {

	private int managerId;
	private String info;
	
	
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append(" Manager ID = ").append(managerId);
		sb.append(" Info = ").append(info);
		return sb.toString();
	}
}
