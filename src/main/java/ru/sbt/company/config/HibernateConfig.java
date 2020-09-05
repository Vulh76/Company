package ru.sbt.company.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:db.properties"})
@ComponentScan("ru.sbt.company")
public class HibernateConfig {
    private final Environment environment;

    @Autowired
    public HibernateConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.pass"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        final LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("ru/sbt/company");
        final Properties property = new Properties();
        property.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        property.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        property.setProperty("hibernate.hbm2ddl", environment.getProperty("hibernate.hbm2ddl"));
        factoryBean.setHibernateProperties(property);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(DataSource dataSource, SessionFactory sessionFactory) {
        final HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setDataSource(dataSource);
        htm.setSessionFactory(sessionFactory);
        return htm;
    }
}
