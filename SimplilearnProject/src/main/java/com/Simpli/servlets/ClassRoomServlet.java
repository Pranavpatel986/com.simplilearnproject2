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

/**
 * Servlet implementation class ClassRoomServlet
 */
@WebServlet("/ClassRoom")
public class ClassRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClassRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    private ClassRoom getClass(HttpServletRequest request, HttpServletResponse response) {
		
    	ClassRoomDao classRoomDao=new ClassRoomDao();
    	String ClassId=request.getParameter("id");
    	ClassRoom classRoom= ClassRoomDao.getClassRoom(Integer.parseInt(ClassId));
    	try {
        	HttpSession session= request.getSession();
        	session.setAttribute("classRoom", classRoom);
        	RequestDispatcher dispatcher=request.getRequestDispatcher("getclass.jsp");
        	dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classRoom;
    	

		
	}
    
    
    private ClassRoom createClassRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ClassRoomDao classRoomDao=new ClassRoomDao();
    	String name=request.getParameter("class_name");
    	int id=Integer.parseInt( request.getParameter("class_id"));
    	int capacity=Integer.parseInt( request.getParameter("class_capacity"));
    	ClassRoom classModel=new ClassRoom(id, name, capacity);
    	
    	ClassRoom newclassRoom=ClassRoomDao.saveClassRoom(classModel);
    	RequestDispatcher dispatcher=request.getRequestDispatcher("classform.jsp");
    	dispatcher.forward(request, response);
    	
    	return newclassRoom;
    	
    }
    
    
    private List<ClassRoom> getClasses(HttpServletRequest request, HttpServletResponse response) {
    	
    	
    	ClassRoomDao classRoomDao=new ClassRoomDao();
    	List<ClassRoom> classRooms=ClassRoomDao.getAllClasses();
    	try {
        	HttpSession session= request.getSession();
        	session.setAttribute("classRooms", classRooms);
        	RequestDispatcher dispatcher=request.getRequestDispatcher("listclass.jsp");
        	dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classRooms;
    	
    	
    }
    
    
    
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action=request.getParameter("class_action");
		
		try {
			switch(action)  {
			case "new":
				createClassRoom(request, response);
				break;
			case "list":
				getClasses(request, response);
				break;
			case "one":
				getClass(request, response);
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















    
    



