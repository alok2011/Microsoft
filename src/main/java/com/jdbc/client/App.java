package com.jdbc.client;

import com.jdbc.dao.Databases;
import com.jdbc.dao.DatabasesImpl;
import com.jdbc.entity.Employee;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws SQLException 
	{
		Databases db = new DatabasesImpl();
		Employee alok = new Employee(2,"Ramu","Male",20000);
		
//		db.insert(alok);
//		db.insertByPS(alok);
//		db.delete(alok);
//		db.update(alok);
//		db.list();
//		db.getEmployeeById(1);
//		db.getEmployeeByName("Alok'");
		db.getEmployeeByGender("Male");
		
		
		System.out.println("Transaction Done");
		
		
	}

}
