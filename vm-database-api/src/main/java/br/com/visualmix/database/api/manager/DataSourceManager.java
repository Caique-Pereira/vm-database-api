package br.com.visualmix.database.api.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import br.com.visualmix.database.api.config.database.IDataBaseConfig;
import br.com.visualmix.database.api.config.database.VmBspDataBaseConfig;
import br.com.visualmix.database.api.config.database.VmLogDataBaseConfig;

@Component
public class DataSourceManager {

	@Value("${DEFAULT.TIPOCONEXAO: }")
	private String connectionType;
	@Value("${DEFAULT.PORTA: }")
	private String port;
	@Value("${DEFAULT.SERVIDOR: }")
	private String server;
	@Value("${DEFAULT.DATABASE: }")
	private String dataBase;
	@Value("${DEFAULT.LOGIN: }")
	private String user;
	@Value("${DEFAULT.SENHA: }")
	private String password;

	boolean isLogDataSourceCreated = false;
	boolean isBspDataSourceCreated = false;
	boolean isEstatisticaDataSourceCreated = false;

	String logDataSourcebeanName = "LogdataSource";
	String BspgDataSourcebeanName = "BspdataSource";
	String EstatisticaDataSourcebeanName = "EstatisticaDataSource";
	/*
	 * private boolean isConnectionBeanCreated() { ApplicationContext context = new
	 * AnnotationConfigApplicationContext(); ConfigurableListableBeanFactory
	 * beanFactory = ((AnnotationConfigApplicationContext)
	 * context).getBeanFactory();
	 * 
	 * System.out.println("Validando conexão com o banco BSP");
	 * 
	 * return beanFactory.containsBean(beanName); }
	 */

		/*
		 * public void validateConnections() { if
		 * (!isConnectionBeanCreated(vmBspDataBaseConfig)) { // Crie o bean de conexão
		 * usando a configuração padrão ou lógica de fallback // Exemplo: //
		 * vmBspDataBaseConfig.createConnectionWithDefaultConfig(); }
		 * 
		 * if (!isConnectionBeanCreated(vmLogDataBaseConfig)) { // Crie o bean de
		 * conexão usando a configuração padrão ou lógica de fallback // Exemplo: //
		 * vmLogDataBaseConfig.createConnectionWithDefaultConfig(); } }
		 * 
		 * private boolean isConnectionBeanCreated(IDataBaseConfig dataBaseConfig) { //
		 * Verifique se o bean de conexão já foi criado // Exemplo: // return
		 * dataBaseConfig.isConnectionBeanCreated(); return false; // Implemente a
		 * lógica real aqui }
		 */
}
