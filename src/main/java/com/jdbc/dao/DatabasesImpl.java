package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.entity.Employee;

public class DatabasesImpl implements Databases {

	static Connection con = null;

	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ducat", "root", "Alok@2001");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insert(Employee e) {
		try (Statement stmt = con.createStatement()) {

			stmt.execute("insert into employee(name, gender,salary) values('" + e.getName() + "','" + e.getGender()
					+ "'," + e.getSalary() + ")");

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void update(Employee e) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update employee set name='" + e.getName() + "', gender ='" + e.getGender()
					+ "' ,salary = " + e.getSalary() + " where id = " + e.getId() + "");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void delete(Employee e) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("delete from employee where id = " + e.getId());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void list() throws SQLException {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from employee");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
		}

	}

	@Override
	public void getEmployeeById(int id) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee where id = " + id);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
		}

	}

	@Override
	public void getEmployeeByName(String name) throws SQLException {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from employee where name = '" + name);

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
		}

	}

	@Override
	public void insertByPS(Employee e) throws SQLException {

		PreparedStatement ps = con.prepareStatement("insert into employee(name,gender,salary) values (?,?,?)");
		ps.setString(1, e.getName());
		ps.setString(2, e.getGender());
		ps.setInt(3, e.getSalary());

		ps.executeUpdate();

	}

	@Override
	public void getEmployeeByGender(String gender) throws SQLException {
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select * from employee where gender = '" + gender);

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
		}
	}

}
