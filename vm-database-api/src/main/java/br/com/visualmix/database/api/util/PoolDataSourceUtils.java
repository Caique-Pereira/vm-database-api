package br.com.visualmix.database.api.util;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.visualmix.database.api.parameters.Parameters;

@Component
public class PoolDataSourceUtils  {

	public static DataSource setPooldDataSourceConfigs(ComboPooledDataSource pool) { 
		pool.setInitialPoolSize(Integer.valueOf(Funcoes.getParam(Parameters.PARAM_DB_POOL_INIT_SIZE, "5")));
		pool.setMinPoolSize(Integer.valueOf(Funcoes.getParam(Parameters.PARAM_DB_POOL_MIN, "5")));
		pool.setAcquireIncrement(Integer.valueOf(Funcoes.getParam(Parameters.PARAM_DB_POOL_ACQUIRED, "5")));
		pool.setMaxPoolSize(Integer.valueOf(Funcoes.getParam(Parameters.PARAM_DB_POOL_MIN, "20")));
		pool.setMaxIdleTime(10);

		return pool;
	}
}
