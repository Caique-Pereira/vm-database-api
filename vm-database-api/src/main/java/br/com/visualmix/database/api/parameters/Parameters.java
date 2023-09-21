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
	
	public final static String BSP_TIPOCONEXAO = "BSP.TIPOCONEXAO";
	public final static String BSP_PASSWORD = "BSP.SENHA";
	public final static String BSP_LOGIN =    "BSP.LOGIN";
	public final static String BSP_DATABASE = "BSP.DATABASE";
	public final static String BSP_PORT =     "BSP.PORTA";
	public final static String BSP_SERVER =    "BSP.SERVIDOR";
	
	public final static String LOG_TIPOCONEXAO = "LOG.TIPOCONEXAO";
	public final static String LOG_PASSWORD = "LOG.SENHA";
	public final static String LOG_LOGIN =    "LOG.LOGIN";
	public final static String LOG_DATABASE = "LOG.DATABASE";
	public final static String LOG_PORT =     "LOG.PORTA";
	public final static String LOG_SERVER =    "LOG.SERVIDOR";
	
	public final static String ESTATISTICA_TIPOCONEXAO = "ESTATISTICA.TIPOCONEXAO";
	public final static String ESTATISTICA_PASSWORD = "ESTATISTICA.SENHA";
	public final static String ESTATISTICA_LOGIN =    "ESTATISTICA.LOGIN";
	public final static String ESTATISTICA_DATABASE = "ESTATISTICA.DATABASE";
	public final static String ESTATISTICA_PORT =     "ESTATISTICA.PORTA";
	public final static String ESTATISTICA_SERVER =    "ESTATISTICA.SERVIDOR";
	
	public static final String PARAM_DB_POOL_INIT_SIZE = "DB.POOL.INIT.SIZE";
	public static final String PARAM_DB_POOL_MIN = "DB.POOL.MIN";
	public static final String PARAM_DB_POOL_MAX = "DB.POOL.MAX";
	public static final String PARAM_DB_POOL_ACQUIRED = "DB.POOL.ACQUIRED";

}
