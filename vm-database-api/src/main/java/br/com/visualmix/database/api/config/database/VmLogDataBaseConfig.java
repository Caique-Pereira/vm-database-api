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
import br.com.visualmix.database.api.util.DataSourceUtils;
import br.com.visualmix.database.api.util.PoolDataSourceUtils;
import jakarta.persistence.EntityManagerFactory;
import lombok.Data;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "LogEntityManager", 
					   transactionManagerRef = "LogTransactionManager",
					   basePackages = {"br.com.visualmix.visualstore.log.base" })
@ConditionalOnProperty(name = "LOG.TIPOCONEXAO")
public class VmLogDataBaseConfig implements IDataBaseConfig {
	
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

	@Bean(name="LogdataSource")
	public DataSource dataSource() throws IOException, PropertyVetoException {
		return newDataSource(this.connectionType, this.port,this.server,this.dataBase,this.user,this.password);
		
	}

	private DataSource newDataSource(String connectionType, String port, String server, String dataBase,
			String user, String password) {
		IDataSource datasource = DataSourceUtils.createDataSource(this.connectionType);
		ComboPooledDataSource pool = datasource.setPoolDataSourceConfigs(this);
		PoolDataSourceUtils.setPooldDataSourceConfigs(pool);
		return pool;
	}

	@Bean(name = "LogJdbcTemplate")
	public JdbcTemplate getJdbcTemplate(@Qualifier("LogdataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "LogEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan("br.com.visualmix.visualstore.log.base");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "none");
		em.setJpaProperties(properties);
		return em;
	}

	@Bean(name = "LogTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("LogEntityManager") EntityManagerFactory emf) {

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
