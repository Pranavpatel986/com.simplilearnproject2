package com.Simpli.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.Simpli.dao.StudentDao;
import com.Simpli.dao.TeacherDao;
import com.Simpli.entity.Student;
import com.Simpli.entity.Teacher;
import com.Simpli.util.Hibernateutil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDao studentDao;
 
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
		studentDao=new StudentDao();
	}
    
    private Student getStudent(HttpServletRequest request, HttpServletResponse response) {
		
    	String StudentId=request.getParameter("id");
    	Student student= studentDao.getStudent(Integer.parseInt(StudentId));

    	return student;
		
	}
//    private Teacher getTeacher(HttpServletRequest request, HttpServletResponse response) {
//    	
//    	String TeacherId=request.getParameter("id");
//    	Teacher teacher= TeacherDao.getTeacher(Integer.parseInt(TeacherId));
//    	
//    	return teacher;
//    	
//    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		Hibernateutil util=new Hibernateutil();
		
		out.print(getStudent(request, response));

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
