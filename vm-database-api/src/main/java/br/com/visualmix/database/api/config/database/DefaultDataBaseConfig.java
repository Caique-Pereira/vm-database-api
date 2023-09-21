package br.com.visualmix.database.api.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DefaultDataBaseConfig  {

	@Value("${DEFAULT.TIPOCONEXAO:null}")
	private String connectionType;

	@Value("${DEFAULT.PORTA:null}")
	private String port;

	@Value("${DEFAULT.SERVIDOR:null}")
	private String server;

	@Value("${DEFAULT.DATABASE:null}")
	private String dataBase;

	@Value("${DEFAULT.LOGIN:null}")
	private String user;

	@Value("${DEFAULT.SENHA:null}")
	private String password;

	public void setDefaultConfig(ADataBaseConfig dataBaseConfig) {
		dataBaseConfig.setConnectionType(this.connectionType);
		dataBaseConfig.setDataBase(this.dataBase);
		dataBaseConfig.setPassword(this.password);
		dataBaseConfig.setPort(this.port);
		dataBaseConfig.setUser(this.user);
		dataBaseConfig.setServer(this.server);	
	}



}
