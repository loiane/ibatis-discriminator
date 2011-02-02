package com.loiane.model;

/**
 * Developer POJO
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class Developer extends Employee{

	private int developerId;
	private String project;
	
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append(" Developer ID = ").append(developerId);
		sb.append(" Project = ").append(project);
		return sb.toString();
	}
}
