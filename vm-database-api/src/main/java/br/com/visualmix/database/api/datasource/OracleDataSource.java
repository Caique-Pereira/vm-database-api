package br.com.visualmix.database.api.datasource;

import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.visualmix.database.api.config.database.ADataBaseConfig;

public class OracleDataSource implements IDataSource  {

	private static final String ORACLE_SERVER_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	private static final String ORACLE_SERVER_JDBC_URL = "jdbc:oracle:thin:@%s:%s:%s";

	
	@Override
	public ComboPooledDataSource setPoolDataSourceConfigs(ADataBaseConfig config) throws ClassNotFoundException, PropertyVetoException {
		   ComboPooledDataSource pool = new ComboPooledDataSource();
			Class.forName(OracleDataSource.ORACLE_SERVER_DRIVER_CLASS);
			pool.setDriverClass(OracleDataSource.ORACLE_SERVER_DRIVER_CLASS);
			pool.setJdbcUrl(String.format(ORACLE_SERVER_JDBC_URL,config.getServer(), config.getPort(), config.getDataBase()));
			pool.setUser(config.getUser());
			pool.setPassword(config.getPassword());
			return pool;

	}


}
