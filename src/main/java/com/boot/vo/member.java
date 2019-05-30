package com.boot.vo;

public class member {
	private String id;
	private String password;
	private String name;
	private String grade;
	
	public member() {}
	
	public member(String id, String password, String name, String grade) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.grade = grade;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "member [id=" + id + ", password=" + password + ", name=" + name + ", grade=" + grade + "]";
	}
	
}
