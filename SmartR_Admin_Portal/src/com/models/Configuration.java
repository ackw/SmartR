package com.models;

public class Configuration {
    public String grace_period;
    public String opening_hours;
    public String closing_hours;
    public String email;
    public String password;
    public String day;
    public String isClosed;
    
    public Configuration() {}
    
    public Configuration(String grace_period, String opening_hours, String day, String isClosed, String closing_hours, String email, String password) {
    super();
    this.grace_period = grace_period;
    this.opening_hours = opening_hours;
    this.closing_hours = closing_hours;
    this.email = email;
    this.password = password;
    this.day = day;
    this.isClosed = isClosed;
    }
    
    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getClosing_hours() {
        return closing_hours;
    }

    public void setClosing_hours(String closing_hours) {
        this.closing_hours = closing_hours;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getIsClosed() {
        return isClosed;
    }
    
    public void setIsClosed(String isClosed) {
        this.isClosed = isClosed;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrace_period() {
        return grace_period;
    }

    public void setGrace_period(String grace_period) {
        this.grace_period = grace_period;
    }
}





