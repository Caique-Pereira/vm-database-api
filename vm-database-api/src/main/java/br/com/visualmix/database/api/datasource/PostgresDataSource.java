package br.com.visualmix.database.api.datasource;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.visualmix.database.api.config.database.IDataBaseConfig;

public class PostgresDataSource implements IDataSource  {

	@Override
	public ComboPooledDataSource setPoolDataSourceConfigs(IDataBaseConfig config) {
		// TODO Auto-generated method stub
		return null;
	}


}
