package br.com.visualmix.database.api.config.database;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import br.com.visualmix.database.api.datasource.IDataSource;
import jakarta.persistence.EntityManagerFactory;

public interface IDataBaseConfig {
	
	public DataSource dataSource();
	public JdbcTemplate getJdbcTemplate(DataSource dataSource);
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource);
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf);
 
	
	public String getConnectionType();
	public String getPort();
	public String getServer();
	public String getDataBase();
	public String getUser();
	public String getPassword();
	
	public void setConnectionType(String connectionType);
	public void setPort(String port);
	public void setServer(String server);
	public void setDataBase(String dataBase);
	public void setUser(String User);
	public void setPassword(String password);
	
	
}
