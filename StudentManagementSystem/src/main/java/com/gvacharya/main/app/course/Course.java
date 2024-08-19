package com.gvacharya.main.app.course;

public class Course {

	private int id;
	
	private String name;
	
	private int credits;

	public Course() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", credits=" + credits + "]";
	}
	
	
}
