package ru.sbt.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.company.config.HibernateConfig;
import ru.sbt.company.dao.EmployeeDAO;
import ru.sbt.company.model.Employee;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HibernateConfig.class);
        EmployeeDAO employeeDAO = applicationContext.getBean(EmployeeDAO.class);
        Employee userinfo = employeeDAO.byId(2L);

        System.out.println(userinfo);
    }
}
