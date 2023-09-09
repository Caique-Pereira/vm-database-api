package br.com.visualmix.database.api.datasource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.visualmix.database.api.config.database.IDataBaseConfig;

public interface IDataSource {
	
	ComboPooledDataSource setPoolDataSourceConfigs(IDataBaseConfig config) throws ClassNotFoundException, PropertyVetoException;
	
}
