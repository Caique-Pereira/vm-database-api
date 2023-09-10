package br.com.visualmix.database.api.config.database;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
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
public class DefaultDataBaseConfig  {

	@Value("${DEFAULT.TIPOCONEXAO}")
	private String connectionType;

	@Value("${DEFAULT.PORTA}")
	private String port;

	@Value("${DEFAULT.SERVIDOR}")
	private String server;

	@Value("${DEFAULT.DATABASE}")
	private String dataBase;

	@Value("${DEFAULT.LOGIN}")
	private String user;

	@Value("${DEFAULT.SENHA}")
	private String password;

	
	/*
	 * public IDataSource newDataSource() { IDataSource datasource =
	 * DataSourceUtils.createDataSource(this.connectionType); // pool =
	 * datasource.setPoolDataSourceConfigs(this); //
	 * PoolDataSourceUtils.setPooldDataSourceConfigs(pool); return datasource;
	 * 
	 * }
	 */

	public void setDefaultConfig(IDataBaseConfig dataBaseConfig) {
		dataBaseConfig.setConnectionType(this.connectionType);
		dataBaseConfig.setDataBase(this.dataBase);
		dataBaseConfig.setPassword(this.password);
		dataBaseConfig.setPort(this.port);
		dataBaseConfig.setUser(this.user);
		dataBaseConfig.setServer(this.server);	
	}



}
