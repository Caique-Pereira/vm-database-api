package br.com.visualmix.database.api.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
import br.com.visualmix.database.api.datasource.OracleDataSource;
import br.com.visualmix.database.api.datasource.PostgresDataSource;
import br.com.visualmix.database.api.datasource.SqlServerDataSource;
import br.com.visualmix.database.api.parameters.Parameters;
import br.com.visualmix.database.api.util.Funcoes;
import br.com.visualmix.database.api.util.PoolDataSourceUtils;
import jakarta.persistence.EntityManagerFactory;

//@Configuration
//@EnableAutoConfiguration
//@EnableJpaRepositories(entityManagerFactoryRef = "EntityManager", 
					//	transactionManagerRef = "TransactionManager",
//		basePackages = {"br.com.visualmix.visualstore.databsp.base","br.com.visualmix.visualstore.log.base","br.com.visualmix.visualstore.databsp.base.models.Casadinha"})
public class DataSourceConfig {
	
	/*
	 * @Bean
	 * 
	 * @Primary
	 * 
	 * @ConfigurationProperties(prefix = "DEFAULT") public DataSource dataSource()
	 * throws IOException, PropertyVetoException { IDataSource datasource =
	 * createDataSource(); ComboPooledDataSource pool =
	 * datasource.setPoolDataSourceConfigs(this);
	 * PoolDataSourceUtils.setPooldDataSourceConfigs(pool); return pool; }
	 * 
	 * @Bean(name="JdbcTemplate")
	 * 
	 * @Primary public JdbcTemplate getJdbcTemplate(@Qualifier("dataSource")
	 * DataSource dataSource) { return new JdbcTemplate(dataSource); }
	 * 
	 * 
	 * @Bean(name="EntityManager")
	 * 
	 * @Primary public LocalContainerEntityManagerFactoryBean
	 * entityManagerFactory(DataSource dataSource) {
	 * LocalContainerEntityManagerFactoryBean em = new
	 * LocalContainerEntityManagerFactoryBean(); em.setDataSource(dataSource);
	 * em.setPackagesToScan("br.com.visualmix.visualstore"); JpaVendorAdapter
	 * vendorAdapter = new HibernateJpaVendorAdapter();
	 * em.setJpaVendorAdapter(vendorAdapter); Properties properties = new
	 * Properties(); properties.setProperty("hibernate.hbm2ddl.auto", "none");
	 * em.setJpaProperties(properties); return em; }
	 * 
	 * @Bean(name="TransactionManager")
	 * 
	 * @Primary public PlatformTransactionManager
	 * transactionManager(@Qualifier("EntityManager") EntityManagerFactory emf) {
	 * 
	 * JpaTransactionManager transactionManager = new JpaTransactionManager();
	 * transactionManager.setEntityManagerFactory(emf);
	 * 
	 * return transactionManager; }
	 * 
	 * 
	 * 
	 * private IDataSource createDataSource() { String connectionType =
	 * Funcoes.getParam(Parameters.DEFAULT_TIPOCONEXAO); switch (connectionType) {
	 * case "1": return new SqlServerDataSource(); case "2": return new
	 * PostgresDataSource(); case "3": return new OracleDataSource(); default: throw
	 * new IllegalArgumentException("Unexpected value connection type: " +
	 * connectionType); } }
	 */

}
