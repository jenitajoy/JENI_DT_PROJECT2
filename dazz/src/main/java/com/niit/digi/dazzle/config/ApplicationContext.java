package com.niit.digi.dazzle.config;

import java.util.Properties;





import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;



import com.niit.digi.dazzle.dao.EventDao;
import com.niit.digi.dazzle.dao.EventDaoImpl;
import com.niit.digi.dazzle.dao.ForumDao;
import com.niit.digi.dazzle.dao.ForumDaoImpl;
import com.niit.digi.dazzle.dao.JobDao;
import com.niit.digi.dazzle.dao.JobDaoImpl;
import com.niit.digi.dazzle.dao.RegisterDao;
import com.niit.digi.dazzle.dao.RegisterDaoImpl;

import com.niit.digi.dazzle.model.Event;
import com.niit.digi.dazzle.model.Forum;
import com.niit.digi.dazzle.model.Job;
import com.niit.digi.dazzle.model.Register;


@Configuration
@ComponentScan("com.niit.digi.dazzle")
@EnableTransactionManagement

public class ApplicationContext {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

		dataSource.setUsername("hr");
		dataSource.setPassword("manager");
		return dataSource;
	}
    
   
    
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
     	properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClass(Register.class);
    	sessionBuilder.addAnnotatedClass(Job.class);
       	sessionBuilder.addAnnotatedClass(Event.class);
    	sessionBuilder.addAnnotatedClass(Forum.class);
    	
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
    
   
	 @Autowired
	    @Bean(name = "registerDaoImpl")
	    public RegisterDaoImpl getRegisterDAOImpl(SessionFactory sessionFactory) {
	    	return new RegisterDao(sessionFactory);
	    }

	
	 @Autowired
	    @Bean(name = "jobDao")
	    public JobDao getJobDao(SessionFactory sessionFactory) {
	    	return new JobDaoImpl(sessionFactory);
	    }
	 
	
	
	 @Autowired
	    @Bean(name = "eventDao")
	    public EventDao getEventDao(SessionFactory sessionFactory) {
	    	return new EventDaoImpl(sessionFactory);
	    }
	 
	 @Autowired
	    @Bean(name = "forumDao")
	    public ForumDao getForumDao(SessionFactory sessionFactory) {
	    	return new ForumDaoImpl(sessionFactory);
	    }
	
	 
}
