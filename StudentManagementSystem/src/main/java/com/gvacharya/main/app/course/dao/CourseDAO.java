package com.gvacharya.main.app.course.dao;
import  com.gvacharya.main.app.course.Course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseDAO {

	private static final String url =  "jdbc:mysql://localhost:3306/java_db";
	private static final String root = "root";
	private static final String password = "Jatin123";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,root,password);
		
	}
	
	public void saveCourse(Course course) {
		String query = "Insert into course(name,credits) values(?,?)";
		try(Connection connection = getConnection();
			PreparedStatement statement = 
			connection
			.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, course.getName());
			statement.setInt(2, course.getCredits());
			statement.executeUpdate();
			ResultSet keys = statement.getGeneratedKeys();
			while(keys.next()) {
				course.setId(keys.getInt(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	public Course getCourse(int id) {
//		String getCourse = "Select * from course where id = ?";
//		try(Connection connection = getConnection();
//			PreparedStatement statement = connection.prepareStatement(getCourse);){
//			
//			Course course = new Course();
////			statement.setString(1,course.getName());
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}
