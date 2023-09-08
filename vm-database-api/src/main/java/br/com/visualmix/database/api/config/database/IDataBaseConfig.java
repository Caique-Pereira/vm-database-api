package br.com.visualmix.database.api.config.database;

import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

public interface IDataBaseConfig {
	
	public DataSource dataSource() throws IOException, PropertyVetoException;
	public JdbcTemplate getJdbcTemplate(DataSource dataSource);
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource);
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf);
	
	public String getConnectionType();
	public String getPort();
	public String getServer();
	public String getDataBase();
	public String getUser();
	public String getPassword();
	
}
