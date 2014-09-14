package com.report.excel.Report4J.domain;

public class Student {
    private String name;
    
    private String major;
    
    private Integer age;
    
    public Student(String name, String major, Integer age){
    	this.name = name;
    	this.major = major;
    	this.age = age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
