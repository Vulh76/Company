package ru.sbt.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.company.config.AppConfig;
import ru.sbt.company.models.Employee;
import ru.sbt.company.services.EmployeeService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);

        employeeService.addEmployee(new Employee("Андрей", "Иванов", 23, 1));
        employeeService.addEmployee(new Employee("Илья", "Думаченко", 27, 1));
        employeeService.addEmployee(new Employee("Наталья", "Синичкина", 31, 1));
        employeeService.addEmployee(new Employee("Владимир", "Орлов", 46, 2));
        employeeService.addEmployee(new Employee("Елизавета", "Котова", 46, 2));
        employeeService.addEmployee(new Employee("Оксана", "Саратова", 28, 3));
        employeeService.addEmployee(new Employee("Александр", "Вертушкин", 28, 3));
        employeeService.addEmployee(new Employee("Сергей", "Захаров", 24, 3));
        employeeService.addEmployee(new Employee("Виктория", "Соколова", 36, 3));

    }
}
