package ru.sbt.company.dao;

import ru.sbt.company.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> allEmployees();
    void add(Employee film);
    void delete(Employee film);
    void edit(Employee film);
    Employee byId(long id);
}
