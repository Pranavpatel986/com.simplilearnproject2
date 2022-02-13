package com.Simpli.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Simpli.entity.ClassRoom;
import com.Simpli.entity.Student;
import com.Simpli.util.Hibernateutil;

public class ClassRoomDao {
	
	public static ClassRoom getClassRoom(int id) {
		Transaction transaction=null;
		ClassRoom classRoom=null;
		Session session=null;
		
		try{
			session=Hibernateutil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			classRoom= session.get(ClassRoom.class, id);
			
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			System.out.println(e);
		}finally {
			session.close();
		}
		
		return classRoom;
		
	}
	public static ClassRoom saveClassRoom(ClassRoom classRoom) {
		Transaction transaction=null;
		ClassRoom createdClassRoom=null;
		Session session=null;
		
		
		try {
			session=Hibernateutil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			session.save(classRoom);
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
		return createdClassRoom;
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<ClassRoom> getAllClasses() {
		Transaction transaction=null;
		List<ClassRoom> listOfClassRooms=null;
		Session session=null;
		try{
			session=Hibernateutil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			
			listOfClassRooms=session.createQuery("from ClassRoom").getResultList();
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			System.out.println(e);
		}finally {
			session.close();
		}
		
		return listOfClassRooms;
		
	}

}
