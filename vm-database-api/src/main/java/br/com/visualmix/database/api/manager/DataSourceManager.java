package br.com.visualmix.database.api.manager;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.visualmix.database.api.config.database.VmBspDataBaseConfig;
import br.com.visualmix.database.api.config.database.VmEstatisticaDataBaseConfig;
import br.com.visualmix.database.api.config.database.VmLogDataBaseConfig;
import br.com.visualmix.database.api.manager.health.BspDataBaseHealthCheck;
import br.com.visualmix.database.api.manager.health.EstatisticaDataBaseHealthCheck;
import br.com.visualmix.database.api.manager.health.LogDataBaseHealthCheck;
import br.com.visualmix.database.api.parameters.Parameters;
import br.com.visualmix.database.api.util.Funcoes;
import jakarta.annotation.PostConstruct;

@Component
public class DataSourceManager {

	@Autowired
	EstatisticaDataBaseHealthCheck estatisticaDataBaseHealthCheck;
	@Autowired
	VmEstatisticaDataBaseConfig vmEstatisticaDataBaseConfig;

	@Autowired
	LogDataBaseHealthCheck logDataBaseHealthCheck;
	@Autowired
	VmLogDataBaseConfig vmLogDataBaseConfig;
	
	@Autowired
	BspDataBaseHealthCheck bspDataBaseHealthCheck;
	@Autowired
	VmBspDataBaseConfig vmBspDataBaseConfig;
	
	@Autowired
    private ConfigurableApplicationContext context;
	
	int count = 0;
	

	@PostConstruct
	public void initialize() {
		checkDataBases();
	}

	@Scheduled(fixedRate = 300000)
	public void checkDataBases() {
//		
//		if(count > 0) {
//		Funcoes.reReadFileConf();
//		checkBsp();
//		checkLog();
//		checkEstatistica();
//		}
//		count++;
}

	private void checkBsp() {
//		bspDataBaseHealthCheck.checkHealth();
//		if (bspDataBaseHealthCheck.isDatabaseOffline) {
//			vmBspDataBaseConfig.setConnectionType(Funcoes.getParam(Parameters.BSP_TIPOCONEXAO,"null"));
//			vmBspDataBaseConfig.setDataBase(Funcoes.getParam(Parameters.BSP_DATABASE,"null"));
//			vmBspDataBaseConfig.setPassword(Funcoes.getParam(Parameters.BSP_PASSWORD,"null"));
//			vmBspDataBaseConfig.setPort(Funcoes.getParam(Parameters.BSP_PORT,"null"));
//			vmBspDataBaseConfig.setServer(Funcoes.getParam(Parameters.BSP_SERVER,"null"));
//			vmBspDataBaseConfig.setUser(Funcoes.getParam(Parameters.BSP_LOGIN,"null"));
//		
//			
//			context.refresh();
//		}	
			
		
		
		
	}

	private void checkLog() {

	}

	private void checkEstatistica() {

	}
}
