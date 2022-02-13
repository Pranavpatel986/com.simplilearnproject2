package com.Simpli.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Simpli.entity.Teacher;
import com.Simpli.util.Hibernateutil;

public class TeacherDao {
	public Teacher getTeacher(int id) {
		Transaction transaction=null;
		Teacher teacher=null;
		Session session=null;
		
		try{
			session=Hibernateutil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			teacher= session.get(Teacher.class, id);
			
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			System.out.println(e);
		}finally {
			session.close();
		}
		
		return teacher;
		
	}
	public Teacher saveTeacher(Teacher teacher) {
		Transaction transaction=null;
		Teacher createdTeacher=null;
		Session session=null;
		
		
		try {
			session=Hibernateutil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			session.save(teacher);
			createdTeacher=teacher;
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
		return createdTeacher;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Teacher> getAllTeachers() {
		Transaction transaction=null;
		List<Teacher> listOfTeachers=null;
		Session session=null;
		try{
			session=Hibernateutil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			
			listOfTeachers=session.createQuery("from Teacher").getResultList();
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			System.out.println(e);
		}finally {
			session.close();
		}
		
		return listOfTeachers;
		
	}
	
}
