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
public class AspectLogger {
	
	String methodName="";
	String className="";
	
	private static final Logger logger = LoggerFactory.getLogger(AspectLogger.class);

	@Pointcut("execution(* br.com.visualmix..*.*(..))")
	public void myPointCut() {
	}

	@Before("myPointCut()") 
	public void generateLog(JoinPoint joinPoint) {
		
		if( joinPoint.getTarget() == null) return;
		String parametros = "";
		Object[] args = joinPoint.getArgs() == null ? new Object[0] : joinPoint.getArgs();
		methodName =  joinPoint.getSignature().getName() == null ? " " : joinPoint.getSignature().getName();
        className = joinPoint.getTarget().getClass().getSimpleName() == null ? " " :  joinPoint.getTarget().getClass().getSimpleName();
		
		for (Object x : args) {
			if(x != null)
				parametros += "'" + x.toString() + "' | ";
		}

		logger.info("Entrou no Metodo " + methodName + " Da classe " + className + (!parametros.equals("") ? " como valor de parametros :" + parametros : ""));
	}
}
