package com.models;

import java.io.InputStream;

public class Employees {
	public String employee_id;
	public String name;
	public String email;
	public String employment_type;
	public int salary;
	public InputStream bufferedImage;
	
	public Employees() {}
	
	public Employees(String employee_id, String name, String email, String employment_type, int salary) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.email = email;
		this.employment_type = employment_type;
		this.salary = salary;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployment_type() {
		return employment_type;
	}

	public void setEmployment_type(String employment_type) {
		this.employment_type = employment_type;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public InputStream getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(InputStream bufferedImage) {
		this.bufferedImage = bufferedImage;
	}	
}
