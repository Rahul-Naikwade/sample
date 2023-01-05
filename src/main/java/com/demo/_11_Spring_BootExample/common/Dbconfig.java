package com.demo._11_Spring_BootExample.common;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.demo._11_Spring_BootExample.model.Employee;

@Configuration
public class Dbconfig {
	
	@Value("${db.driver}")
	private String driver;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddl;
	@Value("${hibernate.show_sql}")
	private String showsql;
	@Value("${entityToScan}")
	private String entityscan;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(getDataSource());
		Properties properties = new Properties();
		properties.put("hibernate.Dialect", dialect);
		properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
		properties.put("hibernate.show_sql", showsql);
		properties.put("entityToScan", entityscan);
		sf.setHibernateProperties(properties);
		sf.setAnnotatedClasses(Employee.class);
		return sf;
	}

}
