package com.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class DatabaseUtility {
	
	Connection connection;
	
	//connect to database
	public void getConnection(String url,String username,String password)
	{
		try {
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			connection=DriverManager.getConnection(url, username, password);
			}
		catch(Exception e) {}
	}
	
	//disconnect database
	public void closeDatabaseConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//execute select query
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet result=null;
		try {
			Statement statement = connection.createStatement();
			result=statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//execute non select query
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		try {
			Statement statement = connection.createStatement();
			result=statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	

}
