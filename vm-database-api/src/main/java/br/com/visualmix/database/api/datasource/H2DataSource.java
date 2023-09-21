package br.com.visualmix.database.api.datasource;

import java.beans.PropertyVetoException;
import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.visualmix.database.api.config.database.ADataBaseConfig;

public class H2DataSource implements IDataSource  {
	
		private static final String H2_SERVER_DRIVER_CLASS = "org.h2.Driver";
	private static final String H2_SERVER_JDBC_URL = "jdbc:h2:mem:FallBackDataBase";

	@Override
	public ComboPooledDataSource setPoolDataSourceConfigs(ADataBaseConfig config) throws ClassNotFoundException, PropertyVetoException {
		ComboPooledDataSource pool = new ComboPooledDataSource();
			Class.forName(H2DataSource.H2_SERVER_DRIVER_CLASS);
			pool.setDriverClass(H2DataSource.H2_SERVER_DRIVER_CLASS);
			pool.setJdbcUrl(H2_SERVER_JDBC_URL);
			pool.setUser(config.getUser());
			pool.setPassword(config.getPassword());
			return pool;
	}

}
