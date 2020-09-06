package ru.sbt.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.company.config.HibernateConfig;
import ru.sbt.company.models.Employee;
import ru.sbt.company.services.EmployeeService;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HibernateConfig.class);
        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);

        employeeService.addEmployee(new Employee("Андрей", "Иванов", 23, 1));

        List<Employee> employees = Arrays.asList(
            new Employee("Андрей", "Иванов", 23, 1),
            new Employee("Илья", "Думаченко", 23, 1),
            new Employee("Владимир", "Орлов", 23, 2),
            new Employee("Александр", "Вертушкин", 23, 3),
            new Employee("Сергей", "Захаров", 23, 3),
            new Employee("Абдула", "Исханбек", 23, 3)
        );

    }
}
