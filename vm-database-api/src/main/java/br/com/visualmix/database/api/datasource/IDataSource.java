package br.com.visualmix.database.api.datasource;

import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.visualmix.database.api.config.database.ADataBaseConfig;

public interface IDataSource {
	
	ComboPooledDataSource setPoolDataSourceConfigs(ADataBaseConfig config) throws ClassNotFoundException, PropertyVetoException;

	
}
