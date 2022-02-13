package com.Simpli.servlets;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;

import com.Simpli.dao.ClassRoomDao;
import com.Simpli.dao.StudentDao;
import com.Simpli.entity.ClassRoom;
import com.Simpli.entity.Student;
import com.Simpli.util.Hibernateutil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    private StudentDao studentDao;
 
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
//    
//    public void init() {
//		studentDao=new StudentDao();
//	}
//    
    private void getStudent(HttpServletRequest request, HttpServletResponse response) {
		
    	StudentDao studentDao=new StudentDao();
    	String StudentId=request.getParameter("id");
    	Student student= studentDao.getStudent(Integer.parseInt(StudentId));
    	try {
        	HttpSession session= request.getSession();
        	session.setAttribute("student", student);
        	RequestDispatcher dispatcher=request.getRequestDispatcher("getstudent.jsp");
        	dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
//    	return student;
		
	}
    
    
    private void getStudents(HttpServletRequest request, HttpServletResponse response) {
    	
    	
    	StudentDao studentDao=new StudentDao();
    	List<Student> students= studentDao.getAllStudents();
    	try {
        	HttpSession session= request.getSession();
        	session.setAttribute("students", students);
        	RequestDispatcher dispatcher=request.getRequestDispatcher("liststudent.jsp");
        	dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
//    	return students;
    	
    }

    private Student createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	StudentDao studentDao=new StudentDao();
    	String name=request.getParameter("studentName");
    	String email=request.getParameter("email");
    	int Modelclass=Integer.parseInt(request.getParameter("classroom"));
    	
    	ClassRoom classRoom=ClassRoomDao.getClassRoom(Modelclass);
    	
    	Student studentModel=new Student(name, email, classRoom);

    	Student newStudent= studentDao.saveStudent(studentModel);
    	RequestDispatcher dispatcher=request.getRequestDispatcher("studentform.jsp");
    	dispatcher.forward(request, response);

    	return newStudent;
    	
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action=request.getParameter("action");
		
		try {
			switch(action)  {
			case "new":
				createStudent(request, response);
				break;
			case "list":
				getStudents(request, response);
				break;
			case "one":
				getStudent(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Hibernateutil util=new Hibernateutil();
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
