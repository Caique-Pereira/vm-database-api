package br.com.visualmix.database.api.config.database;


import javax.sql.DataSource;

import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

public abstract class ADataBaseConfig implements HealthIndicator {
	
	public abstract DataSource dataSource();
	public abstract JdbcTemplate getJdbcTemplate(DataSource dataSource);
	public abstract LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource);
	public abstract PlatformTransactionManager transactionManager(EntityManagerFactory emf);
 
	
	public abstract String getConnectionType();
	public abstract String getPort();
	public abstract String getServer();
	public abstract String getDataBase();
	public abstract String getUser();
	public abstract String getPassword();
	
	public abstract void setConnectionType(String connectionType);
	public abstract void setPort(String port);
	public abstract void setServer(String server);
	public abstract void setDataBase(String dataBase);
	public abstract void setUser(String User);
	public abstract void setPassword(String password);
	
	
}
