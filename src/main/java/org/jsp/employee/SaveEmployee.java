package org.jsp.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployee {
public static void main(String[] args) {
	Configuration conf = new Configuration();
	conf.configure();
	SessionFactory sef = conf.buildSessionFactory();
	Session ses = sef.openSession();
	Transaction tran = ses.getTransaction();
	
	tran.begin();
	Employee e1 = new Employee();
	e1.setName("Rahul");
	e1.setPhone(1234567891);
	e1.setEmail("rahul@gmail.com");
	e1.setDesignation("Java Developer");
	e1.setSalary(32000);
	e1.setPassword("ritesh123");
	ses.save(e1);
	
	Employee e2 = new Employee();
	e2.setName("Ankit");
	e2.setPhone(1234567892);
	e2.setEmail("ankit@gmail.com");
	e2.setDesignation("Frontend Developer");
	e2.setSalary(22000);
	e2.setPassword("ankit123");
	ses.save(e2);
	
	Employee e3 = new Employee();
	e3.setName("Soubhagya");
	e3.setPhone(1224567892);
	e3.setEmail("soubhagya@gmail.com");
	e3.setDesignation("React Developer");
	e3.setSalary(20000);
	e3.setPassword("soubhagya123");
	ses.save(e3);
	
	Employee e4 = new Employee();
	e4.setName("Soumen");
	e4.setPhone(1234537892);
	e4.setEmail("soumen@gmail.com");
	e4.setDesignation("Backend Developer");
	e4.setSalary(35000);
	e4.setPassword("soumen123");
	ses.save(e4);
	
	Employee e5 = new Employee();
	e5.setName("Bikas");
	e5.setPhone(1334567892);
	e5.setEmail("bikas@gmail.com");
	e5.setDesignation("Dotnet Developer");
	e5.setSalary(42000);
	e5.setPassword("bikas123");
	ses.save(e5);
	
	tran.commit();
	
	
}
}