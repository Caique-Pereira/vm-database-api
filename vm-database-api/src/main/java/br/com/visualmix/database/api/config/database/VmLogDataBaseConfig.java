package br.com.visualmix.database.api.config.database;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.visualmix.database.api.datasource.IDataSource;
import br.com.visualmix.database.api.manager.DataSourceManager;
import br.com.visualmix.database.api.manager.health.EstatisticaDataBaseHealthCheck;
import br.com.visualmix.database.api.manager.health.LogDataBaseHealthCheck;
import br.com.visualmix.database.api.util.DataBaseUtils;
import br.com.visualmix.database.api.util.DataSourceUtils;
import br.com.visualmix.database.api.util.PoolDataSourceUtils;
import jakarta.persistence.EntityManagerFactory;
import lombok.ToString;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "LogEntityManager", 
					   transactionManagerRef = "LogTransactionManager",
					   basePackages = {DataBaseUtils.LOG_BASE_PACKAGES })
@ToString
public class VmLogDataBaseConfig extends ADataBaseConfig {
	
	@Value("${LOG.TIPOCONEXAO: }")
	private String connectionType;

	@Value("${LOG.PORTA: }")
	private String port;

	@Value("${LOG.SERVIDOR: }")
	private String server;

	@Value("${LOG.DATABASE: }")
	private String dataBase;

	@Value("${LOG.LOGIN: }")
	private String user;

	@Value("${LOG.SENHA: }")
	private String password;
	
	@Autowired
	@Lazy
	LogDataBaseHealthCheck health;
	
	DataSource datasource; 

	@Override
	@Bean(name="LogdataSource")
	public DataSource dataSource() {
		try {
			datasource = newDataSource();
		} catch (Exception e) {
			
			e.printStackTrace();
        	System.out.println(e.getMessage());
			try {
				setFallBackConfig();
				datasource = newDataSource();
			} catch (Exception e2) {
				e2.printStackTrace();
	        	System.out.println(e2.getMessage());

			}
		}
		return datasource;
	}	

	private DataSource newDataSource() throws ClassNotFoundException, PropertyVetoException,NullPointerException {
		DataBaseUtils.fieldsValidation(this);
		IDataSource datasource = DataSourceUtils.createDataSource(this.connectionType);
		ComboPooledDataSource pool = datasource.setPoolDataSourceConfigs(this);
		PoolDataSourceUtils.setPooldDataSourceConfigs(pool);
		return pool;
	}
	
	@Override
	@Bean(name = "LogJdbcTemplate")
	public JdbcTemplate getJdbcTemplate(@Qualifier("LogdataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Override
	@Bean(name = "LogEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(DataBaseUtils.LOG_BASE_PACKAGES);
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "none");
		em.setJpaProperties(properties);
		return em;
	}

	
	@Override
	@Bean(name = "LogTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("LogEntityManager") EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
	public void setFallBackConfig() {
		FallBackH2DataBaseConfig.setfallBacktConfig(this);
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
	public void setConnectionType(String connectionType) {this.connectionType = connectionType;}
	@Override
	public void setPort(String port) {this.port=port;}
	@Override
	public void setServer(String server){this.server=server;}
	@Override
	public void setDataBase(String dataBase) {this.dataBase=dataBase;}
	@Override
	public void setUser(String user) {this.user = user;}
	@Override
	public void setPassword(String password) {this.password=password;}

	@Override
	public Health health() {
		return health.checkHealth();
	};
	
}
