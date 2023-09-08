package br.com.visualmix.database.api.parameters;

import org.springframework.stereotype.Component;

@Component
public class Parameters {
	
	public final static String DEFAULT_TIPOCONEXAO = "DEFAULT.TIPOCONEXAO";
	public final static String DEFAULT_PASSWORD = "DEFAULT.SENHA";
	public final static String DEFAULT_LOGIN =    "DEFAULT.LOGIN";
	public final static String DEFAULT_DATABASE = "DEFAULT.DATABASE";
	public final static String DEFAULT_PORT =     "DEFAULT.PORTA";
	public final static String DEFAULT_SERVER =    "DEFAULT.SERVIDOR";
	
	public static final String PARAM_DB_POOL_INIT_SIZE = "DB.POOL.INIT.SIZE";
	public static final String PARAM_DB_POOL_MIN = "DB.POOL.MIN";
	public static final String PARAM_DB_POOL_MAX = "DB.POOL.MAX";
	public static final String PARAM_DB_POOL_ACQUIRED = "DB.POOL.ACQUIRED";

}
