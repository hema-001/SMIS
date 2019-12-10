package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaBeans.Course;
import com.javaBeans.Student;
import com.javaBeans.Teacher;

public class DB {
	
	public String Driver = "com.mysql.jdbc.Driver";
	public String url = "jdbc:mysql://localhost:3306/student_management_system?autoReconnect=true&&useSSL=false";
	public String root = "root";
	public String password = "124536";

	public Connection con;
	
	
	public void connect() throws SQLException
	{
		try
		{
			Class.forName(Driver);
			con = DriverManager.getConnection(url, root, password);
		}
		
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}
	
	public void close() throws SQLException
	{
		try
		{
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public boolean checkUser(Student s) throws SQLException, ClassNotFoundException
	{
		boolean result = false;
		
		connect();
		
		String sql = "select * from student where id=? and password=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, s.getId());
		ps.setString(2, s.getPassword());
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			result = true;
		}
		
		close();
		
		return result;
	}
	
	public boolean checkPassword(Student s) throws SQLException
	{
		connect();
		
		boolean result = false;
		
		String sql = "select * from student where id=? and password=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, s.getId());
		ps.setString(2, s.getPassword());
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			result = true;
		}
		
		close();
		
		return result;
	}
	
	public void changePassword(Student s) throws SQLException
	{
		connect();
		
		String sql = "update student set password=? where id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, s.getPassword());
		ps.setString(2, s.getId());
		ps.executeUpdate();
		
		close();
	}
	
	public boolean checkTeacher(Teacher t) throws SQLException, ClassNotFoundException
	{
		boolean result = false;
		
		connect();
		
		String sql = "select * from teacher where id=? and password=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, t.getId());
		ps.setString(2, t.getPassword());
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			result = true;
		}
		
		close();
		
		return result;
	}
	

	
	public boolean addCourse(long id, int course_code) throws SQLException, ClassNotFoundException
	{
		connect();
		
		boolean result = false;
		int i = 0;
		
		String check1 = "select day, period from courses where course_code=?";
				
		PreparedStatement ps1 = con.prepareStatement(check1);
		ps1.setInt(1, course_code);
		
		ResultSet rs = ps1.executeQuery();
		
		while(rs.next())
		{
			String day = rs.getString(1);
			String period = rs.getString(2);
			
			String check2 = "select c.day, c.period from courses as c, select_course as sc where sc.course_code=c.course_code and sc.id=? and day=? and period=?";
			
			PreparedStatement ps2 = con.prepareStatement(check2);
			ps2.setLong(1, id);
			ps2.setString(2, day);
			ps2.setString(3, period);
			
			ResultSet rs2 = ps2.executeQuery();
			
			while(rs2.next())
			{
				i = 1;
				result = false;
			}
			
		}
			
		
		if(i==0)
		{
			String sql = "insert into select_course(id, course_code) values(?,?)";
			
			PreparedStatement ps2 = con.prepareStatement(sql);
			ps2.setLong(1, id);
			ps2.setInt(2, course_code);
			
			ps2.executeUpdate();
			result = true;
		}
		
		
		close();
		
		return result;
	}
	
	public void removeCourse(int course_code, long id) throws SQLException, ClassNotFoundException
	{
		connect();
		
		String sql = "delete from select_course where id=? and course_code=? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, id);
		ps.setInt(2, course_code);
		
		ps.executeUpdate();
		
		close();
	}

}
