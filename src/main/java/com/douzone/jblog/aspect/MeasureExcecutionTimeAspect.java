package com.douzone.jblog.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Aspect
@Component
//@ControllerAdvice
public class MeasureExcecutionTimeAspect {

	
	@Around("execution(* *..repository.*.*(..)) || execution(* *..service.*.*(..))|| execution(* *..controller.*.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable
	{
		//before
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		//method 실행
		Object result = pjp.proceed();
		
		//after
		stopWatch.stop();
		Long totalTime = stopWatch.getTotalTimeMillis();

		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		String taskName = className+"."+methodName;
		
		System.out.println("[ExecutionTime]["+taskName+"]"+totalTime+"mils");
		return result;
	}
}
