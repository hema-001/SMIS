package com.javaBeans;

public class Course {
	

	public long id;
	public int course_code;
	
	public int getCourse_code() 
	{
		return course_code;
	}
	
	public void setCourse_code(int course_code) 
	{
		this.course_code = course_code;
	}
	
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}
}
