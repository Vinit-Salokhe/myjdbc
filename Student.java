package com.my.jdbc1;

public class Student {
	private int rollno;
	private String firstname;
	private int section;

	public Student(int rollno, String firstname, int class1) {
		super();
		this.rollno = rollno;
		this.firstname = firstname;
		section = class1;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}
	
}