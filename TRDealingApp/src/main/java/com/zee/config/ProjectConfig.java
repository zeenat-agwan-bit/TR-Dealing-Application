package com.zee.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.zee")
public class ProjectConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.zee");
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", "true");
		sessionFactory.setHibernateProperties(props);
		System.out.println("SESSION FACTORY : ==========================>"+sessionFactory);
		return sessionFactory;
	}

	@Bean
	public ComboPooledDataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) { 
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/tdata");
		ds.setUser("root");
		ds.setPassword("root");
		System.out.println("DATA SOURCE  =====================>: "+ds);
		return ds;
	}

	/*
	 * @Bean public DriverManagerDataSource dataSource() { DriverManagerDataSource
	 * ds = new DriverManagerDataSource();
	 * ds.setDriverClassName("com.mysql.jdbc.Driver");
	 * ds.setUrl("jdbc:mysql://localhost:3306/wpdata"); ds.setUsername("root");
	 * ds.setPassword("root"); return ds; }
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSize(1500000);
		return resolver;
	}
	
	
	
}