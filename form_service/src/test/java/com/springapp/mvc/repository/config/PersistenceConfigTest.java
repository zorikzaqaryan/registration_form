package com.springapp.mvc.repository.config;

import java.util.Properties;
import javax.sql.DataSource;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IUserRepository;
import com.springapp.mvc.repository.impl.UserRepository;
import org.hibernate.SessionFactory;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.springapp.mvc"})
public class PersistenceConfigTest {

//    @Autowired
//    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan("com.springapp.mvc");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }


    @Bean
    public DataSource restDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/java2");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }




    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties hibernateProperties() {
        return new Properties() {

            {
                setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
                setProperty("hibernate.globally_quoted_identifiers", "true");
            }
        };
    }

    @Bean
    public SessionFactory sessionFactoryBean() {
        return new LocalSessionFactoryBuilder(restDataSource())
                .addAnnotatedClasses(User.class, Address.class, Contact.class)
                .buildSessionFactory();
    }

    @Bean
    public IUserRepository userRepository() {
        return new UserRepository();
    }


}


//env.getProperty("hibernate.hbm2ddl.auto")