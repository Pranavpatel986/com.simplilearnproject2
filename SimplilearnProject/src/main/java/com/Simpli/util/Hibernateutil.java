package com.Simpli.util;

import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.Simpli.entity.ClassRoom;
import com.Simpli.entity.Student;
import com.Simpli.entity.Teacher;

public class Hibernateutil {
	
	private static SessionFactory factory;
	Session session;
	
	public static SessionFactory getSessionFactory() {
		if (factory==null) {
			try {
				Configuration configuration=new Configuration();
//				configuration.configure();
				Properties hiberProperties=new Properties();
				

				hiberProperties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				hiberProperties.put(Environment.URL, "jdbc:mysql://localhost:3306/tuts");
				hiberProperties.put(Environment.USER, "root");
				hiberProperties.put(Environment.PASS, "1234");
				hiberProperties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				hiberProperties.put(Environment.SHOW_SQL, "true");
				hiberProperties.put(Environment.FORMAT_SQL, "true");
				hiberProperties.put(Environment.HBM2DDL_AUTO, "update");
				
				configuration.setProperties(hiberProperties);
				
				configuration.addAnnotatedClass(Student.class);
				configuration.addAnnotatedClass(ClassRoom.class);
				configuration.addAnnotatedClass(Teacher.class);
				
				ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				
				factory=configuration.buildSessionFactory(serviceRegistry);
				

			
			} catch (Exception e) {
				System.out.println("Error : "+e);
			}
		}
		
		return factory;
		
	}
	
}
