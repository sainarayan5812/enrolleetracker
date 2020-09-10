package com.healthcare.enrolleetracker.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="enrollees")
public class Enrollee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;


    @Column
    private String status;


    @Column
    private Date dob;
    @Column(name="phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "enrollee",orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Dependent> dependentList=new ArrayList<Dependent>();

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@JsonManagedReference
	public List<Dependent> getDependentList() {
		return dependentList;
	}

	public void setDependentList(List<Dependent> dependentList) {
		this.dependentList = dependentList;
	}
    
    
    

}