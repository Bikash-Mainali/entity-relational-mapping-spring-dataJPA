package com.sync.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="laptop")
public class Laptop {
	
	@Id
	private int lid;
	private String name;	
	private String laptopUser;
	
	public String getLaptopUser() {
		return laptopUser;
	}
	public void setLaptopUser(String laptopUser) {
		this.laptopUser = laptopUser;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
