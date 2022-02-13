package com.Simpli.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Simpli.entity.Student;
import com.Simpli.util.Hibernateutil;

public class StudentDao {
	public Student getStudent(int id) {
		Transaction transaction=null;
		Student student=null;
		Session session=null;
		
		try{
			session=Hibernateutil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			student= session.get(Student.class, id);
			
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			System.out.println(e);
		}finally {
			session.close();
		}
		
		return student;
		
	}
	public Student saveStudent(Student student) {
		Transaction transaction=null;
		Student createdStudent=null;
		Session session=null;
		
		
		try {
			session=Hibernateutil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			session.save(student);
			createdStudent=student;
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			System.out.println(e);
		}
		finally {
			session.close();
		}
		return createdStudent;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		Transaction transaction=null;
		List<Student> listOfStudents=null;
		Session session=null;
		try{
			session=Hibernateutil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			
			listOfStudents=session.createQuery("from Student").getResultList();
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			System.out.println(e);
		}finally {
			session.close();
		}
		
		return listOfStudents;
		
	}
	
}
