package br.com.visualmix.database.api.datasource;

import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.visualmix.database.api.config.database.ADataBaseConfig;

public class PostgresDataSource implements IDataSource  {
	
	private static final String POSTGRES_SERVER_DRIVER_CLASS = "org.postgresql.Driver";
	private static final String POSTGRES_SERVER_JDBC_URL = "jdbc:postgresql://%s:%s/%s";



	@Override
	public ComboPooledDataSource setPoolDataSourceConfigs(ADataBaseConfig config) throws ClassNotFoundException, PropertyVetoException {
		   ComboPooledDataSource pool = new ComboPooledDataSource();
			Class.forName(PostgresDataSource.POSTGRES_SERVER_DRIVER_CLASS);
			pool.setDriverClass(PostgresDataSource.POSTGRES_SERVER_DRIVER_CLASS);
			pool.setJdbcUrl(String.format(POSTGRES_SERVER_JDBC_URL,config.getServer(), config.getPort(), config.getDataBase()));
			pool.setUser(config.getUser());
			pool.setPassword(config.getPassword());
			return pool;

	}


}
