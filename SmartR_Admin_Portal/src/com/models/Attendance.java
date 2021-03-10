package com.models;

public class Attendance {
	public int id;
	public String employee_id;
	public String time_check_in;
	public String time_check_out;
	public String date;
	public boolean is_late;
	public String reason;
	
	public Attendance() {}
	
	public Attendance(int id, String employee_id, String time_check_in, String time_check_out, String date,
			boolean is_late, String reason) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.time_check_in = time_check_in;
		this.time_check_out = time_check_out;
		this.date = date;
		this.is_late = is_late;
		this.reason = reason;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getTime_check_in() {
		return time_check_in;
	}

	public void setTime_check_in(String time_check_in) {
		this.time_check_in = time_check_in;
	}

	public String getTime_check_out() {
		return time_check_out;
	}

	public void setTime_check_out(String time_check_out) {
		this.time_check_out = time_check_out;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isIs_late() {
		return is_late;
	}

	public void setIs_late(boolean is_late) {
		this.is_late = is_late;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
}