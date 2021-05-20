package com.my.jdbc1;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StudentCrud StudentCrud = new StudentCrud();
		Student s = new Student(1, "xyz", 5);
		StudentCrud.saveStudent(s);
		StudentCrud.updateStudent(100, "Ashwin");
		StudentCrud.deleteStudent(101);
		StudentCrud.getStudent(1);
	}

}
