package br.com.visualmix.database.api.config.database;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.visualmix.database.api.datasource.IDataSource;
import br.com.visualmix.database.api.manager.health.BspDataBaseHealthCheck;
import br.com.visualmix.database.api.manager.health.LogDataBaseHealthCheck;
import br.com.visualmix.database.api.util.DataBaseUtils;
import br.com.visualmix.database.api.util.DataSourceUtils;
import br.com.visualmix.database.api.util.PoolDataSourceUtils;
import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "BspEntityManager", 
						transactionManagerRef = "BspTransactionManager",
		basePackages = {DataBaseUtils.BSP_BASE_PACKAGES})
public class VmBspDataBaseConfig extends ADataBaseConfig {
	
	@Value("${BSP.TIPOCONEXAO:null}")
	private String connectionType;
	
	@Value("${BSP.PORTA:null}")
	private String port;
	
	@Value("${BSP.SERVIDOR:null}")
	private String server;
	
	@Value("${BSP.DATABASE:null}")
	private String dataBase;
	
	@Value("${BSP.LOGIN:null}")
	private String user;
	
	@Value("${BSP.SENHA::null}")
	private String password;
	
	@Autowired
	DefaultDataBaseConfig defaultDataBase;
	
	@Autowired
	@Lazy
	BspDataBaseHealthCheck health;
	
	DataSource datasource; 

	@Override
	@Bean(name="BspDataSource")
	@Primary
	public DataSource dataSource() {
		try {
			datasource = newDataSource();
		} catch (Exception e) { 
			 try {
		            setDefaultConfig();
		            datasource = newDataSource();
		        } catch (Exception e2) {
		        	  try {
		        			setFallBackConfig();
							datasource = newDataSource();
						} catch (Exception e3) {
				
					}
  		        }
		}
		return datasource;
	}	
	
	private DataSource newDataSource() throws ClassNotFoundException, PropertyVetoException,NullPointerException {
		variableValidation();
		IDataSource datasource = DataSourceUtils.createDataSource(this.connectionType);
		ComboPooledDataSource pool = datasource.setPoolDataSourceConfigs(this);
		PoolDataSourceUtils.setPooldDataSourceConfigs(pool);
		return pool;
	}
	
	@Override
	@Bean(name="BspJdbcTemplate")
	@Primary
	public JdbcTemplate getJdbcTemplate(@Qualifier("BspDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	

	@Override
	@Bean(name="BspEntityManager")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("BspDataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(DataBaseUtils.BSP_BASE_PACKAGES);
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "none");
		em.setJpaProperties(properties);
		return em;
	}
	
	@Override
	@Bean(name="BspTransactionManager")
	@Primary
	public PlatformTransactionManager transactionManager(@Qualifier("BspEntityManager") EntityManagerFactory emf) {
		
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(emf);
	 
	    return transactionManager;
	}
		
	public void setDefaultConfig() {
		defaultDataBase.setDefaultConfig(this);
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
	
	
	private void variableValidation() {
		if("null".equals(this.connectionType) || "null".equals(this.port) ||  "null".equals(this.server)
		||  "null".equals(this.dataBase) || "null".equals(this.user) || "null".equals(this.password)) 
		{
			throw new NullPointerException("Erro ao configurar Banco Bsp, uma ou mais variaveis de conexão são nulas");
		}
	}
	
}
