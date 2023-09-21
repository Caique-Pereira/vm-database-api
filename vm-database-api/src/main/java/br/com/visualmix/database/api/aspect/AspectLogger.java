package br.com.visualmix.database.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogger {
	
	String methodName="";
	String className="";
	

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

		System.out.println("Entrou no Metodo " + methodName + " Da classe " + className + (!parametros.equals("") ? " como valor de parametros :" + parametros : ""));
	}
}
