package com.models;

import java.util.Date;

public class Leaves {
	public String employee_id;
	public String start_date;
	public String end_date;
	public String reason;
	
	public Leaves () {}
	
	public Leaves(String employee_id, String start_date, String end_date, String reason) {
		super();
		this.employee_id = employee_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.reason = reason;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
}
