package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.database.DB;
import com.javaBeans.Course;
import com.javaBeans.Student;
import com.javaBeans.Teacher;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       

    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String page = request.getParameter("page");
		
		if(page==null)
		{
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
		else
		{
			doPost(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String page = request.getParameter("page");
		
		if(page.equals("teacher-login"))
		{
			request.getRequestDispatcher("teacherlogin.jsp").forward(request, response);
		}
		
		if(page.equals("student-login"))
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}
		
		if(page.equals("login-form"))
		{
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			Student s = new Student();
			s.setId(id);
			s.setPassword(password);
			
			DB db = new DB();
			
			boolean status = false;
			
			try
			{
				status = db.checkUser(s);
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(status)
			{
				session = request.getSession();
				session.setAttribute("id", id);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			
			
			else
			{
				request.setAttribute("msg", "Invalid id or password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		
		if(page.equals("teacher-login-form"))
		{
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			Teacher t = new Teacher();
			t.setId(id);
			t.setPassword(password);
			
			DB db = new DB();
			
			boolean status = false;
			
			try
			{
				status = db.checkTeacher(t);
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(status)
			{
				session = request.getSession();
				session.setAttribute("id", id);
				request.getRequestDispatcher("TeacherHome.jsp").forward(request, response);
			}
			
			
			else
			{
				request.setAttribute("msg", "Invalid id or password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		if(page.equals("course-search"))
		{
			String id = request.getParameter("id");
			
			session = request.getSession();
			session.setAttribute("id", id);
			
			request.getRequestDispatcher("selectcourse.jsp").forward(request, response);
		}
		
		if(page.equals("course-search-form"))
		{
			int subject = Integer.parseInt(request.getParameter("subject"));
			String id = request.getParameter("id");
			
			session = request.getSession();
			session.setAttribute("id", id);
			
			request.setAttribute("subject", subject);
			request.getRequestDispatcher("selectcourse2.jsp").forward(request, response);
		}
		
		if(page.equals("selected-courses"))
		{
			String id = request.getParameter("id");
			
			session = request.getSession();
			session.setAttribute("id", id);
			
			request.getRequestDispatcher("Courses.jsp").forward(request, response);
		}
		
		if(page.equals("add-course"))
		{
			int course_code = Integer.parseInt(request.getParameter("code"));
			long id = Long.parseLong(request.getParameter("id"));

			
			DB db = new DB();
			
			boolean status = false;
			
			try
			{
				status  = db.addCourse(id, course_code);
				
				if(status)
				{	
					request.getRequestDispatcher("Courses.jsp").forward(request, response);
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Time crash with another subject", "Info", JOptionPane.INFORMATION_MESSAGE);
					
					request.getRequestDispatcher("Courses.jsp").forward(request, response);
				}
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			} 
			
			catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(page.equals("remove-course"))
		{
			int course_code = Integer.parseInt(request.getParameter("code"));
			long id = Long.parseLong(request.getParameter("id"));
			
			
			DB db = new DB();
			
			try
			{
				db.removeCourse(course_code, id);
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("Courses.jsp").forward(request, response);
		}
		
		if(page.equals("students-list"))
		{
			int course_code = Integer.parseInt(request.getParameter("code"));
			
			request.setAttribute("code", course_code);
			
			request.getRequestDispatcher("StudentList.jsp").forward(request, response);
		}
		
		if(page.equals("option1"))
		{
			String infomaintain = request.getParameter("info-maintain");
			
			System.out.println(infomaintain);
		}
		
		if(page.equals("change-password"))
		{
			String id = request.getParameter("id");
			
			request.setAttribute("id", id);
			request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
		}
		
		if(page.equals("change-password-form"))
		{
			String id = request.getParameter("id");
			String old = request.getParameter("oldpassword");
			String new1 = request.getParameter("newpassword1");
			String new2 = request.getParameter("newpassword2");
			
			DB db = new DB();
			Student s = new Student();
			s.setId(id);
			s.setPassword(old);
			
			boolean status = false;
			
			try
			{
				status = db.checkPassword(s);
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			if(status)
			{				
				if(new1.equals(new2))
				{
					System.out.println(id);
					System.out.println(old);
					System.out.println(new1);
					System.out.println(new2);
					
					s.setId(id);
					s.setPassword(new1);
					
					try
					{
						db.changePassword(s);
					}
					
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
				else
				{
					request.setAttribute("id", id);
					request.setAttribute("msg", "passwors not same");
					request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
				}
				
			}
			
			else
			{
				request.setAttribute("id", id);
				request.setAttribute("msg", "Old password doesn't match");
				request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
			}


		}
		
	}

}
