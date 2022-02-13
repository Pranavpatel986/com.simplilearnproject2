
package com.Simpli.servlets;

import java.io.IOException;
import java.util.List;

import com.Simpli.dao.TeacherDao;
import com.Simpli.entity.Teacher;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

    @WebServlet("/Teacher")
    public class TeacherServlet extends HttpServlet {
    	private static final long serialVersionUID = 1L;
           
        /**
         * @see HttpServlet#HttpServlet()
         */
        public TeacherServlet() {
            super();
            // TODO Auto-generated constructor stub
        }

        private void getTeacher(HttpServletRequest request, HttpServletResponse response) {
    		
        	TeacherDao teacherDao=new TeacherDao();
        	String StudentId=request.getParameter("id");
        	Teacher teacher= teacherDao.getTeacher(Integer.parseInt(StudentId));
        	try {
            	HttpSession session= request.getSession();
            	session.setAttribute("teacher", teacher);
            	RequestDispatcher dispatcher=request.getRequestDispatcher("getteacher.jsp");
            	dispatcher.forward(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	
//        	return student;
    		
    	}
        
        
        private List<Teacher> getTeachers(HttpServletRequest request, HttpServletResponse response) {
        	
        	
        	TeacherDao teacherDao=new TeacherDao();
        	List<Teacher> teachers= teacherDao.getAllTeachers();
        	try {
            	HttpSession session= request.getSession();
            	session.setAttribute("teachers", teachers);
            	RequestDispatcher dispatcher=request.getRequestDispatcher("listteacher.jsp");
            	dispatcher.forward(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	
        	return teachers;
        	
        }

        private Teacher createTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
        	
        	TeacherDao teacherDao=new TeacherDao();
        	String name=request.getParameter("teacher_Name");
        	String email=request.getParameter("teacher_email");
        	
        	
        	Teacher teacherModel=new Teacher(name, email, null);
//        	StudentDao.saveStudent(studentModel);
        	Teacher newTeacher= teacherDao.saveTeacher(teacherModel);
        	
        	RequestDispatcher dispatcher=request.getRequestDispatcher("teacherform.jsp");
        	dispatcher.forward(request, response);
        	
//        	getStudents(request, response);
			return newTeacher;
        	
        }

    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		
    		String action=request.getParameter("teacher_action");
    		
    		try {
    			switch(action)  {
    			case "new":
    				createTeacher(request, response);
    				break;
    			case "list":
    				getTeachers(request, response);
    				break;
    			case "one":
    				getTeacher(request, response);
    				break;
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}


    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		doGet(request, response);
    	}

    }

