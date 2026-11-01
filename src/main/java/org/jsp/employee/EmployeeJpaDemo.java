package org.jsp.employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeJpaDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // CREATE
            Employee e = new Employee();
            e.setName("Sushil");
            e.setPhone(9876543210L);
            e.setEmail("sushil@example.com");
            e.setDesignation("Java Developer");
            e.setSalary(30000);
            e.setPassword("demo123");

            tx.begin();
            em.persist(e);
            tx.commit();
            System.out.println("Saved: " + e);

            // READ
            Employee found = em.find(Employee.class, e.getId());
            System.out.println("Found: " + found);

            // UPDATE
            tx.begin();
            found.setSalary(35000);
            em.merge(found);
            tx.commit();
            System.out.println("Updated: " + found);

            // DELETE
            tx.begin();
            em.remove(found);
            tx.commit();
            System.out.println("Deleted employee with id " + e.getId());
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
