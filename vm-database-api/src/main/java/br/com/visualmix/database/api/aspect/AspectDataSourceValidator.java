package br.com.visualmix.database.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDataSourceValidator {
	
	private static final Logger logger = LoggerFactory.getLogger(AspectDataSourceValidator.class);

	String parametros ="";
	boolean invalidParameters = false;
	String className;
	
	
	 @Pointcut("execution(* br.com.visualmix.database.api.config.database.*.newDataSource(..))")
	    public void newDataSourceMethods() {}

	    @Before("newDataSourceMethods()")
	    public void beforeNewDataSourceMethod(JoinPoint joinPoint) {
	    	className = joinPoint.getTarget().getClass().getSimpleName() == null ? " " :  joinPoint.getTarget().getClass().getSimpleName();
	    	logger.info("Intercepted method: " + joinPoint.getSignature().getName() + "Classe : " + className);
	        Object[] args = joinPoint.getArgs();
	        for (Object arg : args) {
	        	logger.info("Argumentos de conexão : " + arg);
	            String str = (String) arg;
	            if (str == null || str.trim().isEmpty()) {
					invalidParameters = true;
				}
	        }
	        
			
	        logger.info("Parametros para conexão com o banco "+ getDataBaseName()
			  + (invalidParameters ? " invalidos : " + parametros +
			  " , tentando conexão com o parametros Default" : "validos : " + parametros
			  ));
			 
	    }
	


	private String getDataBaseName() {
		if (className.contains("VmBspDataBaseConfig"))return "Vm_Databsp";
		else if (className.contains("VmLogDataBaseConfig")) return "Vm_Log";
		else if (className.contains("VmEstatisticaDataBaseConfig")) return "Vm_Estatistica";
		else return "FallBack ";		
	}

}
