package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create
        createEmployee("John Doe", 50000);
        createEmployee("Jane Smith", 60000);

        // Read
        System.out.println("\n--- All Employees ---");
        listEmployees();

        // Update
        updateEmployee(1, "John Updated", 70000);

        // Delete
        deleteEmployee(2);
    }

    // Create
    public static void createEmployee(String name, double salary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = new Employee(name, salary);
        session.save(emp);

        tx.commit();
        session.close();
        System.out.println("Saved: " + emp);
    }

    // Read
    public static void listEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
        for (Employee e : employees) {
            System.out.println(e);
        }
        session.close();
    }

    // Update
    public static void updateEmployee(int id, String newName, double newSalary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            emp.setName(newName);
            emp.setSalary(newSalary);
            session.update(emp);
            System.out.println("Updated: " + emp);
        }

        tx.commit();
        session.close();
    }

    // Delete
    public static void deleteEmployee(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            session.delete(emp);
            System.out.println("Deleted: " + emp);
        }

        tx.commit();
        session.close();
    }
}

