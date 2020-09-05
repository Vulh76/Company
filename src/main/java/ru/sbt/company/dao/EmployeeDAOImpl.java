package ru.sbt.company.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sbt.company.model.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Employee> allEmployees() {
        Session session = sessionFactory.getCurrentSession();

        return null;
    }

    public void add(Employee film) {

    }

    public void delete(Employee film) {

    }

    public void edit(Employee film) {

    }

    public Employee byId(long id) {
        return null;
    }
}
