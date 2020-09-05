package ru.sbt.company.dao;

import ru.sbt.company.models.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> allEmployees();
    Employee employeeById(long id);
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void editEmployee(Employee employee);
}
