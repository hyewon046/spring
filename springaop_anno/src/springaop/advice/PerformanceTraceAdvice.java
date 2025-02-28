package springaop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceTraceAdvice {
	
	@Pointcut("execution(public * springaop.service..*(..))")
	public void pointcut() {
	}
	
	@Around("pointcut()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//메소드 시작 시간
		long startTime = System.currentTimeMillis();
		
		//타겟메소드명
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+ "메소드 수행 시작!");
		
		try {
			//타겟메소드 호출
			return joinPoint.proceed();
		
		} finally {
			//메소드 종료 시간
			long endTime = System.currentTimeMillis();
			System.out.println(methodName + "메소드 수행 종료!");
			
			//메소드 수행 시간
			long runTime = endTime - startTime;
			System.out.println(methodName + " 수행 시간은 " + runTime + "밀리초 입니다!");
		}
		
	}

}
