package br.com.visualmix.database.api.util;

import br.com.visualmix.database.api.datasource.H2DataSource;
import br.com.visualmix.database.api.datasource.IDataSource;
import br.com.visualmix.database.api.datasource.OracleDataSource;
import br.com.visualmix.database.api.datasource.PostgresDataSource;
import br.com.visualmix.database.api.datasource.SqlServerDataSource;

public class DataSourceUtils {
	
	public static IDataSource createDataSource(String connectionType) {
        switch (connectionType) {
            case "1": return new SqlServerDataSource();
            case "2": return new OracleDataSource();
            case "5":  return new PostgresDataSource();
            case "99" : return new H2DataSource();
            default:
            	System.out.println("Tipo de conexão invalida ou nula :  " + connectionType);
                return null; 
        }
    }

}
