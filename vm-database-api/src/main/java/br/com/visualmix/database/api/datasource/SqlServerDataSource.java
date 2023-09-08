package br.com.visualmix.database.api.datasource;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.visualmix.database.api.config.database.IDataBaseConfig;
import lombok.Data;

@Data
public class SqlServerDataSource implements IDataSource {

	private Connection connection = null;
	private static final String SQl_SERVER_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String SQL_SERVER_JDBC_URL = "jdbc:sqlserver://%s:%s;databaseName=%s;user=%s;password=%s;trustServerCertificate=true";



//	public Connection openConexao() {
//		String jdbcUrl = String.format(SQL_SERVER_JDBC_URL, server, port, dataBase, user, password);
//		try {
//			return connection = DriverManager.getConnection(jdbcUrl);
//		} catch (SQLException | RuntimeException e) {
//			e.printStackTrace();
//			return null;
//		}
//		setDriver("oracle.jdbc.driver.OracleDriver");
//		 setDriver("org.postgresql.Driver");
//	}
//
//	public void closeConexao() throws SQLException {
//		if (connection != null) {
//			connection.close();
//		}
// }

	@Override
	public ComboPooledDataSource setPoolDataSourceConfigs(IDataBaseConfig config) {
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			Class.forName(SqlServerDataSource.SQl_SERVER_DRIVER_CLASS);
			pool.setDriverClass(SqlServerDataSource.SQl_SERVER_DRIVER_CLASS);
			pool.setJdbcUrl(String.format(SQL_SERVER_JDBC_URL, config.getServer() , config.getPort() , config.getDataBase() , config.getUser(), config.getPassword()));
			pool.setUser(config.getUser());
			pool.setPassword(config.getPassword());
			return pool;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
