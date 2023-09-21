package br.com.visualmix.database.api.config.database;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.visualmix.database.api.datasource.IDataSource;
import br.com.visualmix.database.api.util.DataBaseUtils;
import br.com.visualmix.database.api.util.DataSourceUtils;
import br.com.visualmix.database.api.util.PoolDataSourceUtils;
import jakarta.persistence.EntityManagerFactory;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "h2EntityManager", 
transactionManagerRef = "H2TransactionManager",
basePackages = {DataBaseUtils.H2_BASE_PACKAGES})
public class FallBackH2DataBaseConfig extends ADataBaseConfig {
	
	
	private static final String connectionType = "99";
	private static final String dataBase = "HH2";
	private static final String user = "adm";
	private static final String password = "adm";
	private static final String server = "localhost";
	private static final String port = "8080";
	
	DataSource datasource;

	@Override
	@Bean(name="h2DataSource")
	public DataSource dataSource() {
			try {
				datasource = newDataSource();
			} catch (ClassNotFoundException | NullPointerException | PropertyVetoException e) {
				e.printStackTrace();
			}
			return datasource;
	}
	
	private DataSource newDataSource() throws ClassNotFoundException, PropertyVetoException,NullPointerException {
		IDataSource datasource = DataSourceUtils.createDataSource(FallBackH2DataBaseConfig.connectionType);
		ComboPooledDataSource pool = datasource.setPoolDataSourceConfigs(this);
		PoolDataSourceUtils.setPooldDataSourceConfigs(pool);
		return pool;
	}
	
	@Override
	@Bean(name="h2JdbcTemplate")
	public JdbcTemplate getJdbcTemplate(@Qualifier("h2DataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Override
	@Bean(name="h2EntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("h2DataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(DataBaseUtils.H2_BASE_PACKAGES);
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.h2.console.enabled", "true");
		properties.setProperty("hibernate.h2.storage.engine", "mem");
		
		
		
		em.setJpaProperties(properties);
		return em;
	}

	@Override
	@Bean(name="H2TransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("h2EntityManager") EntityManagerFactory emf) {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(emf);
	    return transactionManager;
	}

	@Override
	public String getConnectionType() {return connectionType;}
	@Override
	public String getPort() {return port;}
	@Override
	public String getServer() {return server;}
	@Override
	public String getDataBase() {return dataBase;}
	@Override
	public String getUser() {return user;}
	@Override
	public String getPassword() {return password;}
	
	@Override
	public void setConnectionType(String connectionType) {}
	@Override
	public void setPort(String port) {}
	@Override
	public void setServer(String server){}
	@Override
	public void setDataBase(String dataBase) {}
	@Override
	public void setUser(String user) {}
	@Override
	public void setPassword(String password) {}
	
	@Override
	public Health health() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void setfallBacktConfig(ADataBaseConfig dataBaseConfig) {
		dataBaseConfig.setConnectionType(FallBackH2DataBaseConfig.connectionType);
		dataBaseConfig.setPassword(FallBackH2DataBaseConfig.password);
		dataBaseConfig.setUser(FallBackH2DataBaseConfig.user);
		dataBaseConfig.setPort(FallBackH2DataBaseConfig.port);
		dataBaseConfig.setServer(FallBackH2DataBaseConfig.server);
        dataBaseConfig.setDataBase(FallBackH2DataBaseConfig.dataBase);
		
	}

}
