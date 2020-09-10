package com.healthcare.enrolleetracker.vo;

public class DependentVO {
	private Long id;
    private String name;
    private String dob;
    private Long enrolleeId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Long getEnrolleeId() {
		return enrolleeId;
	}
	public void setEnrolleeId(Long enrolleeId) {
		this.enrolleeId = enrolleeId;
	}
	
    
}
