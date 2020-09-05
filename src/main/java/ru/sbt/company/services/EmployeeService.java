package ru.sbt.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbt.company.dao.EmployeeDAO;
import ru.sbt.company.models.Employee;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    List<Employee> allEmployees() {
        return employeeDAO.allEmployees();
    }

    @Transactional
    Employee employeeById(long id) {
        return employeeDAO.employeeById(id);
    }

    @Transactional
    void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Transactional
    void deleteEmployee(Employee employee) {
        employeeDAO.deleteEmployee(employee);
    }

    @Transactional
    void editEmployee(Employee employee) {
        employeeDAO.editEmployee(employee);
    }

}
