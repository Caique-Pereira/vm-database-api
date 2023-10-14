package br.com.visualmix.database.api.util;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.visualmix.database.api.aspect.AspectDataSourceValidator;
import br.com.visualmix.database.api.config.database.ADataBaseConfig;

public class DataBaseUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(DataBaseUtils.class);
	
	
	public final static String  BSP_BASE_PACKAGES = "br.com.visualmix.visualstore.databsp.md";
	public final static String  LOG_BASE_PACKAGES = "br.com.visualmix.visualstore.log.md";
	public final static String  ESTATISTICA_BASE_PACKAGES = "br.com.visualmix.visualstore.estatistica.base";
	public final static String  H2_BASE_PACKAGES = "br.com.visualmix.visualstore.h2.base";
	
	public static void fieldsValidation(ADataBaseConfig database) {
		logger.info("Banco : {} tipo De conexão : {} Porta : {} server {} Usuario : {} Senha : {}"
				 , database.getDataBase(), database.getConnectionType(), database.getPort(),database.getServer(),database.getUser(),database.getPassword());
		
	    if (Stream.of(database.getConnectionType(),database.getPort(),database.getServer(),database.getDataBase(), database.getUser(), database.getPassword()).anyMatch(String::isEmpty)) {
	        throw new NullPointerException("Erro ao configurar Banco, uma ou mais variáveis de conexão inválidas.");
	    }
	}

}
