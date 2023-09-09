package br.com.visualmix.database.api.config.database;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.visualmix.database.api.datasource.IDataSource;
import br.com.visualmix.database.api.util.DataBaseUtils;
import br.com.visualmix.database.api.util.DataSourceUtils;
import br.com.visualmix.database.api.util.PoolDataSourceUtils;
import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "EstatisticaEntityManager",
                       transactionManagerRef = "EstatisticaTransactionManager", 
                       basePackages = {DataBaseUtils.ESTATISTICA_BASE_PACKAGES})
public class VmEstatisticaDataBaseConfig implements IDataBaseConfig {
	
	@Value("${ESTATISTICA.TIPOCONEXAO:null}")
	private String connectionType;

	@Value("${ESTATISTICA.PORTA:null}")
	private String port;

	@Value("${ESTATISTICA.SERVIDOR:null}")
	private String server;

	@Value("${ESTATISTICA.DATABASE:null}")
	private String dataBase;

	@Value("${ESTATISTICA.LOGIN:null}")
	private String user;

	@Value("${ESTATISTICA.SENHA:null}")
	private String password;
	
	DefaultDataBaseConfig defaultDataBase;
	
	@Bean(name="EstatisticaDataSource")
	public DataSource dataSource() throws IOException, PropertyVetoException {
		try {
			return newDataSource(this.connectionType, this.port,this.server,this.dataBase,this.user,this.password);
			
		} catch (ClassNotFoundException | PropertyVetoException e) {
			defaultDataBase = new DefaultDataBaseConfig();
			e.printStackTrace();
			return defaultDataBase.newDataSource();	
		}	
	}

	private DataSource newDataSource(String connectionType, String port, String server, String dataBase, String user, String password) throws ClassNotFoundException, PropertyVetoException {
		IDataSource datasource = DataSourceUtils.createDataSource(this.connectionType);
		ComboPooledDataSource pool = datasource.setPoolDataSourceConfigs(this);
		PoolDataSourceUtils.setPooldDataSourceConfigs(pool);
		return pool;
	}

	@Bean(name = "EstatisticaJdbcTemplate")
	public JdbcTemplate getJdbcTemplate(@Qualifier("EstatisticaDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "EstatisticaEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(DataBaseUtils.ESTATISTICA_BASE_PACKAGES);
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "none");
		em.setJpaProperties(properties);
		return em;
	}

	@Bean(name = "EstatisticaTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("EstatisticaEntityManager") EntityManagerFactory emf) {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}
	
	public String getConnectionType() {return connectionType;}
	public String getPort() {return port;}
	public String getServer() {return server;}
	public String getDataBase() {return dataBase;}
	public String getUser() {return user;}
	public String getPassword() {return password;}

}
