package com.my.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentCrud {
	static String url = "jdbc:mysql://localhost:3306/students";
	static String userName = "root";
	static String password = "root";
	static String driverClassPath = "com.mysql.jdbc.Driver";

	public  Connection getDataBaseConnetion() {
		Connection con = null;
		try {
			Class.forName(driverClassPath);
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	// save students Method
	public void saveStudent(Student stdf) {

		int affetctedRow = 0;

		Connection con = getDataBaseConnetion();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("insert into students (rollno,name,class) values(?,?,?)");
			stmt.setInt(1, stdf.getRollno());
			stmt.setString(2, stdf.getFirstname());
			stmt.setInt(3, stdf.getSection());
			affetctedRow = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// update Student Method
	public int updateStudent(int rollno, String name) {

		int affetctedRow = 0;

		Connection con = getDataBaseConnetion();
		PreparedStatement stmt;
		try {
			String query = "UPDATE students SET name = ? WHERE rollno = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(2, rollno);
			stmt.setString(1, name);
			affetctedRow = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return affetctedRow;
	}

	// Delete student Method
	public void deleteStudent(int rollno) {

		int affetctedRow = 0;

		Connection con = getDataBaseConnetion();
		PreparedStatement stmt;
		try {
			String query = "delete  from students where rollno = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, rollno);
			affetctedRow = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// get information Method
	public void getStudent(int rollno) {

		Connection con = getDataBaseConnetion();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String query = "select * from students where rollno =" + rollno;
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Student with Id : " + rollno + "is =>");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block		
			e.printStackTrace();
		}
	}

}
